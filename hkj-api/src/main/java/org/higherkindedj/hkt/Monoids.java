// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * A utility interface providing static factory methods for common {@link Monoid} instances.
 *
 * <p>A Monoid extends {@link Semigroup} with an identity element (`empty`), making it useful for
 * fold operations on potentially empty collections.
 */
public interface Monoids {

    /**
     * Returns a {@code Monoid} for {@link List}, where the combination is list concatenation and the
     * identity element is an empty list.
     *
     * @param <A> the element type of the list
     * @return a Monoid for list concatenation
     */
    static <A> Monoid<List<A>> list() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Set}, where the combination is set union and the identity
     * element is an empty set.
     *
     * @param <A> the element type of the set
     * @return a Monoid for set union
     */
    static <A> Monoid<Set<A>> set() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link String}, where the combination is concatenation and the
     * identity element is an empty string.
     *
     * @return a Monoid for string concatenation
     */
    static Monoid<String> string() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for integer addition. Combination is `+`, identity is `0`.
     *
     * @return a Monoid for integer addition
     */
    static Monoid<Integer> integerAddition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for integer multiplication. Combination is `*`, identity is `1`.
     *
     * @return a Monoid for integer multiplication
     */
    static Monoid<Integer> integerMultiplication() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for boolean conjunction ({@code &&}). Combination is {@code &&},
     * identity is {@code true}.
     *
     * @return a Monoid for boolean conjunction
     */
    static Monoid<Boolean> booleanAnd() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for boolean disjunction (`||`). Combination is `||`, identity is
     * `false`.
     *
     * @return a Monoid for boolean disjunction
     */
    static Monoid<Boolean> booleanOr() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for long addition. Combination is `+`, identity is `0L`.
     *
     * @return a Monoid for long addition
     */
    static Monoid<Long> longAddition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for long multiplication. Combination is `*`, identity is `1L`.
     *
     * @return a Monoid for long multiplication
     */
    static Monoid<Long> longMultiplication() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for double addition. Combination is `+`, identity is `0.0`.
     *
     * @return a Monoid for double addition
     */
    static Monoid<Double> doubleAddition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for double multiplication. Combination is `*`, identity is `1.0`.
     *
     * @return a Monoid for double multiplication
     */
    static Monoid<Double> doubleMultiplication() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Optional} that selects the first non-empty optional.
     *
     * <p>The combination takes the first optional if it is present, otherwise the second. The
     * identity is {@code Optional.empty()}.
     *
     * @param <A> The type contained in the optional.
     * @return A non-null {@code Monoid} for first-wins optional combination.
     */
    static <A> Monoid<Optional<A>> firstOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Optional} that selects the last non-empty optional.
     *
     * <p>The combination takes the second optional if it is present, otherwise the first. The
     * identity is {@code Optional.empty()}.
     *
     * @param <A> The type contained in the optional.
     * @return A non-null {@code Monoid} for last-wins optional combination.
     */
    static <A> Monoid<Optional<A>> lastOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Optional} that returns the maximum value according to the
     * given comparator.
     *
     * <p>The combination returns whichever optional contains the greater value, or the non-empty one
     * if only one is present. The identity is {@code Optional.empty()}.
     *
     * @param <A> The type contained in the optional.
     * @param comparator The comparator to use for determining the maximum value.
     * @return A non-null {@code Monoid} for maximum optional combination.
     */
    static <A> Monoid<Optional<A>> maximum(final Comparator<A> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Optional} that returns the maximum value for comparable
     * types.
     *
     * <p>The combination returns whichever optional contains the greater value, or the non-empty one
     * if only one is present. The identity is {@code Optional.empty()}.
     *
     * @param <A> The comparable type contained in the optional.
     * @return A non-null {@code Monoid} for maximum optional combination.
     */
    static <A extends Comparable<? super A>> Monoid<Optional<A>> maximum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Optional} that returns the minimum value according to the
     * given comparator.
     *
     * <p>The combination returns whichever optional contains the lesser value, or the non-empty one
     * if only one is present. The identity is {@code Optional.empty()}.
     *
     * @param <A> The type contained in the optional.
     * @param comparator The comparator to use for determining the minimum value.
     * @return A non-null {@code Monoid} for minimum optional combination.
     */
    static <A> Monoid<Optional<A>> minimum(final Comparator<A> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a {@code Monoid} for {@link Optional} that returns the minimum value for comparable
     * types.
     *
     * <p>The combination returns whichever optional contains the lesser value, or the non-empty one
     * if only one is present. The identity is {@code Optional.empty()}.
     *
     * @param <A> The comparable type contained in the optional.
     * @return A non-null {@code Monoid} for minimum optional combination.
     */
    static <A extends Comparable<? super A>> Monoid<Optional<A>> minimum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
