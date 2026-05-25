// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.fetch;

import static java.util.Objects.requireNonNull;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.higherkindedj.hkt.either.Either;

/**
 * Railway-safe runners for {@link Fetch}.
 *
 * <p>The substrate runners ({@link Fetch#runCached} / {@link Fetch#runAsync}) signal an
 * infrastructure failure (a resolver that throws, a missing key, a loader future that completes
 * exceptionally) by throwing or by failing the returned future. These wrappers move that failure
 * onto the value channel: the run never throws, and its outcome is an {@link Either} whose {@code
 * Left} is the failure and whose {@code Right} is the {@link Fetch.RunResult}.
 *
 * <p>This is the run-boundary form of the error channel. Per-key domain failures (a backend that
 * reports "not found" for one key while succeeding for others) are a separate, finer-grained
 * concern handled by running with a {@code V} of {@code Either<E, ...>}.
 */
public final class SafeFetch {

    private SafeFetch() {
    }

    /**
     * Runs {@link Fetch#runCached} without throwing. A {@code RuntimeException} from the run (a
     * resolver exception, a {@link MissingKeyException}, a contract violation) is returned as {@code
     * Either.left}; a completed run is returned as {@code Either.right}.
     */
    public static <K, V, A> Either<Throwable, Fetch.RunResult<K, A>> runCached(Fetch<K, V, A> fetch, Function<Set<K>, Map<K, V>> resolver) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs {@link Fetch#runAsync} without ever producing a failed future. Whether the loader throws
     * synchronously or its future completes exceptionally, the returned future completes
     * <em>normally</em> with {@code Either.left}; a completed run yields {@code Either.right}.
     */
    public static <K, V, A> CompletableFuture<Either<Throwable, Fetch.RunResult<K, A>>> runAsync(Fetch<K, V, A> fetch, BatchLoader<K, V> loader, Map<K, V> cache) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs {@link Fetch#runAsync} under an overall deadline. If the whole run has not completed
     * within {@code timeout}, the returned future completes normally with {@code
     * Either.left(TimeoutException)}; otherwise it behaves as {@link #runAsync(Fetch, BatchLoader,
     * Map)}.
     *
     * <p>The deadline abandons the wait; it does not cancel loader work already in flight.
     */
    public static <K, V, A> CompletableFuture<Either<Throwable, Fetch.RunResult<K, A>>> runAsync(Fetch<K, V, A> fetch, BatchLoader<K, V> loader, Map<K, V> cache, Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs {@link Guards#runCached} without throwing. A {@link GuardViolationException} (or any other
     * {@code RuntimeException} from the run) is returned as {@code Either.left}; a completed run is
     * returned as {@code Either.right}.
     */
    public static <K, V, A> Either<Throwable, Fetch.RunResult<K, A>> runCachedWithGuard(Fetch<K, V, A> fetch, Function<Set<K>, Map<K, V>> resolver, Guard<K> guard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs {@link Guards#runAsync} without ever producing a failed future. A guard refusal completes
     * the returned future <em>normally</em> with {@code Either.left(GuardViolationException)}.
     */
    public static <K, V, A> CompletableFuture<Either<Throwable, Fetch.RunResult<K, A>>> runAsyncWithGuard(Fetch<K, V, A> fetch, BatchLoader<K, V> loader, Map<K, V> cache, Guard<K> guard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Moves a run's exceptional completion onto the value channel as {@code Either.left}.
     */
    private static <K, V, A> CompletableFuture<Either<Throwable, Fetch.RunResult<K, A>>> railwayify(CompletableFuture<Fetch.RunResult<K, A>> run) {
        return run.handle((result, failure) -> failure == null ? Either.<Throwable, Fetch.RunResult<K, A>>right(result) : Either.<Throwable, Fetch.RunResult<K, A>>left(unwrap(failure)));
    }

    /**
     * Unwraps the {@link CompletionException} a failed stage wraps its cause in.
     */
    private static Throwable unwrap(Throwable failure) {
        return (failure instanceof CompletionException && failure.getCause() != null) ? failure.getCause() : failure;
    }

    /**
     * The split of a per-key batch into its successes and failures.
     *
     * <p>When a run carries per-key {@code Either} values (a resolver that reports {@code Left} for a
     * key the backend could not resolve while succeeding for others), the run's result is a {@code
     * List<Either<E, A>>}. {@code Partitioned} is the "nothing discarded" view of that list: both
     * lists are always populated, so partial-batch success is preserved alongside the failures.
     */
    public record Partitioned<E, A>(List<A> successes, List<E> failures) {
    }

    /**
     * Fail-fast collapse of a per-key result list: {@code Either.right} of every success, in order,
     * if every element succeeded; otherwise the first {@code Left}.
     */
    public static <E, A> Either<E, List<A>> sequence(List<Either<E, A>> results) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Accumulating collapse of a per-key result list: every success and every failure, split into two
     * lists. This keeps partial-batch success when some keys fail.
     */
    public static <E, A> Partitioned<E, A> partition(List<Either<E, A>> results) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
