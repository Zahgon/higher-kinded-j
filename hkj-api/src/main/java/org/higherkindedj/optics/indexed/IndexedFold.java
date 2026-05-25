// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.indexed;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.optics.Fold;
import org.jspecify.annotations.NullMarked;

/**
 * An indexed fold for read-only querying and extraction with access to indices.
 *
 * <p>An {@code IndexedFold} is the indexed equivalent of a {@link Fold}. While a regular fold
 * allows you to query and extract multiple elements from a structure, an indexed fold also provides
 * the index/position of each element, enabling position-aware queries.
 *
 * <p>Common use cases include:
 *
 * <ul>
 *   <li>Extracting elements with their positions: {@code toIndexedList()}
 *   <li>Finding elements by position-aware criteria
 *   <li>Aggregating with position weighting
 *   <li>Debugging: tracking which positions contain certain values
 * </ul>
 *
 * @param <I> The index type (e.g., Integer for lists, K for Map&lt;K, V&gt;)
 * @param <S> The source structure type
 * @param <A> The focused element type
 */
@NullMarked
public interface IndexedFold<I, S, A> extends IndexedOptic<I, S, A> {

    /**
     * Folds all focused parts into a summary value using a {@link Monoid}, with access to both index
     * and value.
     *
     * <p>This is the fundamental operation of an IndexedFold. It maps each focused part {@code A}
     * along with its index {@code I} to a monoidal value {@code M}, then combines all these values
     * using the monoid's {@code combine} operation.
     *
     * <p>Example:
     *
     * <pre>{@code
     * // Weight prices by position (earlier items cost more)
     * Monoid<Double> sumMonoid = Monoid.of(0.0, Double::sum);
     * double weightedTotal = itemsFold.ifoldMap(
     *     sumMonoid,
     *     (index, item) -> item.price() * (1.0 - index * 0.1),
     *     order
     * );
     * }</pre>
     *
     * @param monoid The {@link Monoid} used to combine the mapped values
     * @param f The function to map each index-value pair to the monoidal type {@code M}
     * @param source The source structure
     * @param <M> The monoidal type
     * @return The aggregated result of type {@code M}
     */
    <M> M ifoldMap(Monoid<M> monoid, BiFunction<? super I, ? super A, ? extends M> f, S source);

    /**
     * {@inheritDoc}
     *
     * <p>Default implementation that uses ifoldMap to apply the effectful function to each element.
     */
    @Override
    default <F extends WitnessArity<TypeArity.Unary>> Kind<F, S> imodifyF(BiFunction<I, A, Kind<F, A>> f, S source, Applicative<F> app) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extracts all focused parts along with their indices into a list of pairs.
     *
     * <p>Example:
     *
     * <pre>{@code
     * IndexedFold<Integer, List<String>, String> ifold = IndexedTraversals.forList();
     * List<Pair<Integer, String>> indexed = ifold.toIndexedList(List.of("a", "b", "c"));
     * // [Pair(0, "a"), Pair(1, "b"), Pair(2, "c")]
     * }</pre>
     *
     * @param source The source structure
     * @return A list of index-value pairs in traversal order
     */
    default List<Pair<I, A>> toIndexedList(S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extracts all focused parts, discarding index information.
     *
     * @param source The source structure
     * @return A list of all focused values
     */
    default List<A> getAll(S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Finds the first element that satisfies a predicate based on both index and value.
     *
     * <p>Example:
     *
     * <pre>{@code
     * // Find first element at an even position with value > 10
     * Optional<Pair<Integer, Integer>> found = ifold.findWithIndex(
     *     (index, value) -> index % 2 == 0 && value > 10,
     *     source
     * );
     * }</pre>
     *
     * @param predicate Predicate that takes both index and value
     * @param source The source structure
     * @return The first matching index-value pair, or empty if none found
     */
    default Optional<Pair<I, A>> findWithIndex(BiPredicate<? super I, ? super A> predicate, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Finds the first element that satisfies a predicate on the value.
     *
     * @param predicate Predicate on the focused value
     * @param source The source structure
     * @return The first matching index-value pair, or empty if none found
     */
    default Optional<Pair<I, A>> find(Predicate<? super A> predicate, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if any element satisfies a predicate based on both index and value.
     *
     * @param predicate Predicate that takes both index and value
     * @param source The source structure
     * @return true if any element matches, false otherwise
     */
    default boolean existsWithIndex(BiPredicate<? super I, ? super A> predicate, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if any element satisfies a predicate on the value.
     *
     * @param predicate Predicate on the focused value
     * @param source The source structure
     * @return true if any element matches, false otherwise
     */
    default boolean exists(Predicate<? super A> predicate, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if all elements satisfy a predicate based on both index and value.
     *
     * @param predicate Predicate that takes both index and value
     * @param source The source structure
     * @return true if all elements match (or if empty), false otherwise
     */
    default boolean allWithIndex(BiPredicate<? super I, ? super A> predicate, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if all elements satisfy a predicate on the value.
     *
     * @param predicate Predicate on the focused value
     * @param source The source structure
     * @return true if all elements match (or if empty), false otherwise
     */
    default boolean all(Predicate<? super A> predicate, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Counts the number of focused parts in the structure.
     *
     * @param source The source structure
     * @return The number of focused parts
     */
    default int length(S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if there are no focused parts in the structure.
     *
     * @param source The source structure
     * @return true if no focused parts, false otherwise
     */
    default boolean isEmpty(S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Composes this {@code IndexedFold<I, S, A>} with another {@code IndexedFold<J, A, B>} to create
     * a new {@code IndexedFold<Pair<I, J>, S, B>} with paired indices.
     *
     * @param other The {@link IndexedFold} to compose with
     * @param <J> The index type of the other fold
     * @param <B> The focus type of the other fold
     * @return A new {@link IndexedFold} with paired indices
     */
    default <J, B> IndexedFold<Pair<I, J>, S, B> iandThen(IndexedFold<J, A, B> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Composes this {@code IndexedFold<I, S, A>} with a regular {@code Fold<A, B>} to create a new
     * {@code IndexedFold<I, S, B>} that preserves the outer index.
     *
     * @param other The {@link Fold} to compose with
     * @param <B> The focus type of the other fold
     * @return A new {@link IndexedFold} preserving the outer index
     */
    default <B> IndexedFold<I, S, B> andThen(Fold<A, B> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters elements based on their index.
     *
     * @param predicate Predicate on the index
     * @return A new indexed fold that only focuses on matching indices
     */
    default IndexedFold<I, S, A> filterIndex(Predicate<? super I> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Filters elements based on their value.
     *
     * @param predicate Predicate on the focused value
     * @return A new indexed fold that only focuses on matching values
     */
    default IndexedFold<I, S, A> filtered(Predicate<? super A> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Views this {@code IndexedFold} as a regular (non-indexed) {@link Fold}.
     *
     * @return A {@link Fold} that ignores index information
     */
    default Fold<S, A> asFold() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Private helper monoids
    private static <T> Monoid<Optional<T>> firstOptionalMonoid() {
        return new Monoid<>() {

            @Override
            public Optional<T> empty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Optional<T> combine(Optional<T> a, Optional<T> b) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }

    private static Monoid<Integer> sumIntMonoid() {
        return new Monoid<>() {

            @Override
            public Integer empty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Integer combine(Integer a, Integer b) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }

    private static Monoid<Boolean> anyBooleanMonoid() {
        return new Monoid<>() {

            @Override
            public Boolean empty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Boolean combine(Boolean a, Boolean b) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }

    private static Monoid<Boolean> allBooleanMonoid() {
        return new Monoid<>() {

            @Override
            public Boolean empty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Boolean combine(Boolean a, Boolean b) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }
}
