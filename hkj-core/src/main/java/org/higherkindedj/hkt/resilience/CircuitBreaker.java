// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.resilience;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import org.higherkindedj.hkt.vtask.VTask;

/**
 * A circuit breaker that protects {@link VTask} operations from repeatedly calling a failing
 * service.
 *
 * <p>The circuit breaker tracks the health of a dependency through three states:
 *
 * <ul>
 *   <li><b>CLOSED</b> (normal operation): calls flow through. Failures are counted; when
 *       consecutive failures reach the threshold, the circuit opens.
 *   <li><b>OPEN</b> (failing fast): all calls are immediately rejected with {@link
 *       CircuitOpenException}. After the configured open duration, the circuit transitions to
 *       half-open.
 *   <li><b>HALF_OPEN</b> (probing): a limited number of calls are allowed through as probes. If
 *       enough probes succeed, the circuit closes. If a probe fails, the circuit re-opens.
 * </ul>
 *
 * <p>A single {@code CircuitBreaker} instance should be shared across all callers of the same
 * service. The {@link #protect(VTask)} method is generic, so one circuit breaker can protect calls
 * that return different types.
 *
 * <h2>Example</h2>
 *
 * <pre>{@code
 * CircuitBreaker breaker = CircuitBreaker.create(
 *     CircuitBreakerConfig.builder()
 *         .failureThreshold(5)
 *         .openDuration(Duration.ofSeconds(30))
 *         .build());
 *
 * VTask<String> protectedCall = breaker.protect(
 *     VTask.of(() -> httpClient.get(url)));
 *
 * VTask<Integer> protectedOtherCall = breaker.protect(
 *     VTask.of(() -> httpClient.getCount(url)));
 * }</pre>
 *
 * @see CircuitBreakerConfig
 * @see CircuitOpenException
 */
public final class CircuitBreaker {

    /**
     * The possible states of the circuit breaker.
     */
    public enum Status {

        /**
         * Normal operation: calls are allowed through.
         */
        CLOSED,
        /**
         * Failing fast: all calls are rejected immediately.
         */
        OPEN,
        /**
         * Probing: a limited number of calls are allowed to test recovery.
         */
        HALF_OPEN
    }

    private record InternalState(Status status, int failureCount, int successCount, Instant lastStateChange) {
    }

    private final CircuitBreakerConfig config;

    private final AtomicReference<InternalState> stateRef;

    // Metrics counters
    private final AtomicLong totalCalls = new AtomicLong();

    private final AtomicLong successfulCalls = new AtomicLong();

    private final AtomicLong failedCalls = new AtomicLong();

    private final AtomicLong rejectedCalls = new AtomicLong();

    private final AtomicLong stateTransitions = new AtomicLong();

    private CircuitBreaker(CircuitBreakerConfig config) {
        this.config = config;
        this.stateRef = new AtomicReference<>(new InternalState(Status.CLOSED, 0, 0, Instant.now()));
    }

    // ===== Factory Methods =====
    /**
     * Creates a circuit breaker with the given configuration.
     *
     * @param config the configuration; must not be null
     * @return a new CircuitBreaker
     * @throws NullPointerException if config is null
     */
    public static CircuitBreaker create(CircuitBreakerConfig config) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a circuit breaker with default configuration.
     *
     * @return a new CircuitBreaker with default settings
     */
    public static CircuitBreaker withDefaults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Protection =====
    /**
     * Returns a new {@link VTask} that is protected by this circuit breaker.
     *
     * <p>If the circuit is closed or half-open, the task executes normally. If it succeeds, success
     * is recorded. If it fails with an exception that matches the {@link
     * CircuitBreakerConfig#recordFailure()} predicate, the failure is recorded. If the circuit is
     * open, the task is immediately rejected with {@link CircuitOpenException}.
     *
     * <p>The call timeout from the configuration is applied using {@code VTask.timeout()}.
     *
     * @param task the task to protect; must not be null
     * @param <A> the result type
     * @return a new VTask protected by this circuit breaker
     * @throws NullPointerException if task is null
     */
    public <A> VTask<A> protect(VTask<A> task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new {@link VTask} protected by this circuit breaker, with a fallback value when the
     * circuit is open.
     *
     * @param task the task to protect; must not be null
     * @param fallback function to produce a fallback value when the circuit is open; must not be null
     * @param <A> the result type
     * @return a new VTask with circuit breaker protection and fallback
     * @throws NullPointerException if task or fallback is null
     */
    public <A> VTask<A> protectWithFallback(VTask<A> task, Function<Throwable, A> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== State Inspection =====
    /**
     * Returns the current state of the circuit breaker.
     *
     * @return the current state
     */
    public Status currentStatus() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a snapshot of the circuit breaker's metrics.
     *
     * @return the current metrics
     */
    public CircuitBreakerMetrics metrics() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Manual Control =====
    /**
     * Resets the circuit breaker to the closed state with zeroed counters.
     */
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Manually trips the circuit breaker to the open state.
     */
    public void tripOpen() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Internal State Management =====
    private void onSuccess() {
        successfulCalls.incrementAndGet();
        InternalState prev = stateRef.getAndUpdate(current -> switch(current.status()) {
            case CLOSED ->
                current.failureCount() > 0 ? new InternalState(Status.CLOSED, 0, 0, current.lastStateChange()) : current;
            // OPEN state: must NOT transition to CLOSED
            case OPEN ->
                current;
            case HALF_OPEN ->
                {
                    int newSuccesses = current.successCount() + 1;
                    if (newSuccesses >= config.successThreshold()) {
                        yield new InternalState(Status.CLOSED, 0, 0, Instant.now());
                    }
                    yield new InternalState(Status.HALF_OPEN, 0, newSuccesses, current.lastStateChange());
                }
        });
        // Determine if this call caused a state transition based on the previous state.
        // This is done outside the CAS lambda to avoid double-counting on retries.
        if (prev.status() == Status.HALF_OPEN && prev.successCount() + 1 >= config.successThreshold()) {
            stateTransitions.incrementAndGet();
        }
    }

    private void onFailure() {
        failedCalls.incrementAndGet();
        InternalState prev = stateRef.getAndUpdate(current -> switch(current.status()) {
            case CLOSED ->
                {
                    int newFailures = current.failureCount() + 1;
                    if (newFailures >= config.failureThreshold()) {
                        yield new InternalState(Status.OPEN, 0, 0, Instant.now());
                    }
                    yield new InternalState(Status.CLOSED, newFailures, 0, current.lastStateChange());
                }
            case HALF_OPEN ->
                new InternalState(Status.OPEN, 0, 0, Instant.now());
            // Should not happen during execution
            case OPEN ->
                current;
        });
        // Determine if this call caused a state transition based on the previous state.
        // This is done outside the CAS lambda to avoid double-counting on retries.
        boolean transitioned = (prev.status() == Status.CLOSED && prev.failureCount() + 1 >= config.failureThreshold()) || prev.status() == Status.HALF_OPEN;
        if (transitioned) {
            stateTransitions.incrementAndGet();
        }
    }
}
