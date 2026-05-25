// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.effect;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.effect.capability.Chainable;
import org.higherkindedj.hkt.effect.capability.Combinable;
import org.higherkindedj.hkt.function.Function3;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.maybe.Maybe;
import org.higherkindedj.hkt.state.State;
import org.higherkindedj.hkt.state.StateTuple;

/**
 * A fluent path wrapper for {@link State} computations.
 *
 * <p>{@code WithStatePath} represents computations that thread state through a sequence of
 * operations. Each step can read and modify the state, producing both a new state and a result
 * value.
 *
 * <h2>Use Cases</h2>
 *
 * <ul>
 *   <li>Stateful parsers
 *   <li>Random number generation
 *   <li>Counter or ID generation
 *   <li>Building data structures
 * </ul>
 *
 * <h2>Creating WithStatePath instances</h2>
 *
 * <p>Use the {@link Path} factory class or static factory methods:
 *
 * <pre>{@code
 * // Pure value (state unchanged)
 * WithStatePath<Integer, String> pure = WithStatePath.pure("hello");
 *
 * // Get current state
 * WithStatePath<Integer, Integer> getState = WithStatePath.get();
 *
 * // Set new state
 * WithStatePath<Integer, Unit> setState = WithStatePath.set(42);
 *
 * // Modify state
 * WithStatePath<Integer, Unit> increment = WithStatePath.modify(n -> n + 1);
 *
 * // Inspect state
 * WithStatePath<AppState, String> getName = WithStatePath.inspect(AppState::userName);
 * }</pre>
 *
 * <h2>Composing operations</h2>
 *
 * <pre>{@code
 * // Counter state example
 * WithStatePath<Integer, Integer> nextId = WithStatePath.<Integer>modify(n -> n + 1)
 *     .then(() -> WithStatePath.get());
 *
 * // Generate multiple IDs
 * WithStatePath<Integer, List<Integer>> threeIds = nextId
 *     .via(id1 -> nextId.via(id2 -> nextId.map(id3 -> List.of(id1, id2, id3))));
 *
 * // Run starting from 0
 * StateTuple<Integer, List<Integer>> result = threeIds.run(0);
 * // result = StateTuple(value=[1, 2, 3], state=3)
 * }</pre>
 *
 * @param <S> the state type
 * @param <A> the type of the computed value
 */
public final class WithStatePath<S, A> implements Chainable<A> {

    private final State<S, A> state;

    /**
     * Creates a new WithStatePath wrapping the given State.
     *
     * @param state the State to wrap; must not be null
     */
    WithStatePath(State<S, A> state) {
        this.state = Objects.requireNonNull(state, "state must not be null");
    }

    // ===== Factory Methods =====
    /**
     * Creates a WithStatePath that returns a constant value without modifying state.
     *
     * @param value the value to return
     * @param <S> the state type
     * @param <A> the type of the value
     * @return a WithStatePath that always returns the given value
     */
    public static <S, A> WithStatePath<S, A> pure(A value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a WithStatePath that returns the current state as its value.
     *
     * @param <S> the state type
     * @return a WithStatePath that returns the current state
     */
    public static <S> WithStatePath<S, S> get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a WithStatePath that sets the state to the given value and returns {@link Unit}.
     *
     * @param newState the new state value; must not be null
     * @param <S> the state type
     * @return a WithStatePath that sets the state
     * @throws NullPointerException if newState is null
     */
    public static <S> WithStatePath<S, Unit> set(S newState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a WithStatePath that modifies the state using the given function and returns {@link
     * Unit}.
     *
     * @param f the function to modify the state; must not be null
     * @param <S> the state type
     * @return a WithStatePath that modifies the state
     * @throws NullPointerException if f is null
     */
    public static <S> WithStatePath<S, Unit> modify(UnaryOperator<S> f) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a WithStatePath that extracts a value from the state without modifying it.
     *
     * @param f the function to extract a value from the state; must not be null
     * @param <S> the state type
     * @param <A> the type of the extracted value
     * @return a WithStatePath that inspects the state
     * @throws NullPointerException if f is null
     */
    public static <S, A> WithStatePath<S, A> inspect(Function<? super S, ? extends A> f) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Terminal Operations =====
    /**
     * Runs this computation with the given initial state.
     *
     * @param initialState the initial state; must not be null
     * @return a tuple containing the computed value and the final state
     * @throws NullPointerException if initialState is null
     */
    public StateTuple<S, A> run(S initialState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs this computation and returns only the result, discarding the final state.
     *
     * @param initialState the initial state; must not be null
     * @return the computed value
     * @throws NullPointerException if initialState is null
     */
    public A evalState(S initialState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs this computation and returns only the final state, discarding the result.
     *
     * @param initialState the initial state; must not be null
     * @return the final state
     * @throws NullPointerException if initialState is null
     */
    public S execState(S initialState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the underlying State.
     *
     * @return the wrapped State
     */
    public State<S, A> toState() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Composable implementation =====
    @Override
    public <B> WithStatePath<S, B> map(Function<? super A, ? extends B> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public WithStatePath<S, A> peek(Consumer<? super A> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Combinable implementation =====
    @Override
    public <B, C> WithStatePath<S, C> zipWith(Combinable<B> other, BiFunction<? super A, ? super B, ? extends C> combiner) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Combines this path with two others using a ternary function.
     *
     * @param second the second path; must not be null
     * @param third the third path; must not be null
     * @param combiner the function to combine the values; must not be null
     * @param <B> the type of the second path's value
     * @param <C> the type of the third path's value
     * @param <D> the type of the combined result
     * @return a new path containing the combined result
     */
    public <B, C, D> WithStatePath<S, D> zipWith3(WithStatePath<S, B> second, WithStatePath<S, C> third, Function3<? super A, ? super B, ? super C, ? extends D> combiner) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Chainable implementation =====
    @Override
    public <B> WithStatePath<S, B> via(Function<? super A, ? extends Chainable<B>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> WithStatePath<S, B> then(Supplier<? extends Chainable<B>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Conversions =====
    /**
     * Converts to an IOPath by providing the initial state.
     *
     * <p>The resulting IOPath, when run, will execute this State with the given initial state and
     * return only the computed value.
     *
     * @param initialState the initial state to use; must not be null
     * @return an IOPath that produces the computed value
     * @throws NullPointerException if initialState is null
     */
    public IOPath<A> toIOPath(S initialState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts to an IdPath by providing the initial state.
     *
     * @param initialState the initial state to use; must not be null
     * @return an IdPath containing the computed value
     * @throws NullPointerException if initialState is null
     */
    public IdPath<A> toIdPath(S initialState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts to a MaybePath by providing the initial state.
     *
     * <p>If the computed value is null, returns an empty MaybePath.
     *
     * @param initialState the initial state to use; must not be null
     * @return a MaybePath containing the computed value if non-null
     * @throws NullPointerException if initialState is null
     */
    public MaybePath<A> toMaybePath(S initialState) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Object methods =====
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
