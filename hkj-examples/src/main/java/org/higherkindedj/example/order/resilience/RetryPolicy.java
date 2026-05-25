// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.resilience;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

/**
 * Policy for retry operations with exponential backoff.
 *
 * <p>Defines when and how to retry failed operations, including:
 *
 * <ul>
 *   <li>Maximum number of attempts
 *   <li>Initial delay and backoff multiplier
 *   <li>Maximum delay cap
 *   <li>Conditions for retry (which exceptions to retry on)
 * </ul>
 *
 * @param maxAttempts maximum number of attempts (including the first try)
 * @param initialDelay delay before the first retry
 * @param backoffMultiplier multiplier applied to delay after each retry
 * @param maxDelay maximum delay between retries
 * @param retryOn predicate determining which exceptions trigger retry
 */
public record RetryPolicy(int maxAttempts, Duration initialDelay, double backoffMultiplier, Duration maxDelay, Predicate<Throwable> retryOn) {

    /**
     * Creates a default retry policy. Retries on IOException and TimeoutException.
     *
     * @return default retry policy
     */
    public static RetryPolicy defaults() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a retry policy for testing with minimal delays.
     *
     * @return testing retry policy
     */
    public static RetryPolicy forTesting() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a retry policy that never retries.
     *
     * @return no-retry policy
     */
    public static RetryPolicy noRetry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a retry policy from workflow configuration.
     *
     * @param maxRetries maximum retries
     * @param initialDelay initial delay
     * @param maxDelay maximum delay
     * @param backoffMultiplier backoff multiplier
     * @return configured retry policy
     */
    public static RetryPolicy of(int maxRetries, Duration initialDelay, Duration maxDelay, double backoffMultiplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates the delay for a given attempt number.
     *
     * @param attempt the attempt number (1-based)
     * @return the delay before this attempt
     */
    public Duration delayForAttempt(int attempt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new policy with a custom retry predicate.
     *
     * @param predicate the predicate for retry conditions
     * @return new policy with custom predicate
     */
    public RetryPolicy withRetryOn(Predicate<Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new policy that also retries on the given exception type.
     *
     * @param exceptionType exception class to retry on
     * @return new policy with extended retry conditions
     */
    public RetryPolicy alsoRetryOn(Class<? extends Throwable> exceptionType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
