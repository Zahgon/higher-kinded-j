// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.maybe;

import static org.higherkindedj.hkt.util.validation.Operation.*;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;
import org.higherkindedj.hkt.util.validation.Validation;
import org.jspecify.annotations.Nullable;

/**
 * Concrete implementation of Maybe representing the absence of a value (singleton).
 *
 * <p>As part of the HKT pattern, this class implements {@link MaybeKind}, allowing it to be used
 * with typeclasses expecting {@code Kind<MaybeKind.Witness, T>}.
 */
final class Nothing<T> implements Maybe<T>, MaybeKind<T> {

    // Singleton instance
    private static final Nothing<?> INSTANCE = new Nothing<>();

    // Private constructor to enforce singleton pattern
    private Nothing() {
    }

    /**
     * Factory method to get the singleton instance
     */
    @SuppressWarnings("unchecked")
    static <T> Nothing<T> instance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isJust() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isNothing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // get() throws, return type annotation isn't critical but technically should match Maybe<T>
    @Override
    public T get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T orElse(T other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public T orElseGet(Supplier<? extends T> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <U> Maybe<U> map(Function<? super T, ? extends @Nullable U> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <U> Maybe<U> flatMap(Function<? super T, ? extends Maybe<? extends U>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
