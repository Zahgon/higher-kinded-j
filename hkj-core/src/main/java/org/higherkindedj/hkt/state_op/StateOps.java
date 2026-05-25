// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.state_op;

import static org.higherkindedj.hkt.util.validation.Operation.CONSTRUCTION;
import static org.higherkindedj.hkt.util.validation.Operation.LIFT_F;
import java.util.Optional;
import java.util.function.Function;
import org.higherkindedj.hkt.Functor;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.hkt.free.Free;
import org.higherkindedj.hkt.inject.Inject;
import org.higherkindedj.hkt.util.validation.Validation;
import org.higherkindedj.optics.Getter;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.Prism;
import org.higherkindedj.optics.Traversal;
import org.jspecify.annotations.NullMarked;

/**
 * Smart constructors for {@link StateOp} operations, lifting them into the Free monad.
 *
 * <p>For standalone use (single-effect programs):
 *
 * <pre>{@code
 * Free<StateOpKind.Witness<MyState>, String> program = StateOps.view(nameLens);
 * }</pre>
 *
 * <p>For combined-effect use via {@link Bound}:
 *
 * <pre>{@code
 * StateOps.Bound<MyState, AppEffects> state = StateOps.boundTo(stateInject, functorG);
 * Free<AppEffects, String> combined = state.view(nameLens);
 * }</pre>
 *
 * @see StateOp
 * @see StateOpKind
 */
@NullMarked
public final class StateOps {

    private static final StateOpFunctor<?> FUNCTOR = StateOpFunctor.instance();

    private StateOps() {
    }

    @SuppressWarnings("unchecked")
    private static <S> StateOpFunctor<S> functor() {
        return (StateOpFunctor<S>) FUNCTOR;
    }

    /**
     * Reads a value through a {@link Getter}.
     *
     * @param optic The getter to read through. Must not be null.
     * @param <S> The state type
     * @param <A> The focused value type
     * @return A Free program that reads through the getter
     */
    public static <S, A> Free<StateOpKind.Witness<S>, A> view(Getter<S, A> optic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a value through a {@link Lens} (convenience overload since Lens does not extend Getter).
     *
     * @param optic The lens to read through. Must not be null.
     * @param <S> The state type
     * @param <A> The focused value type
     * @return A Free program that reads through the lens
     */
    public static <S, A> Free<StateOpKind.Witness<S>, A> view(Lens<S, A> optic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Modifies a focus through a {@link Lens} and returns the new value.
     *
     * @param optic The lens to modify through. Must not be null.
     * @param f The modification function. Must not be null.
     * @param <S> The state type
     * @param <A> The focused value type
     * @return A Free program that modifies through the lens
     */
    public static <S, A> Free<StateOpKind.Witness<S>, A> over(Lens<S, A> optic, Function<A, A> f) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets a focus through a {@link Lens} to a fixed value.
     *
     * @param optic The lens to set through. Must not be null.
     * @param value The value to set. Must not be null.
     * @param <S> The state type
     * @param <A> The focused value type
     * @return A Free program that sets the value through the lens
     */
    public static <S, A> Free<StateOpKind.Witness<S>, A> assign(Lens<S, A> optic, A value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads a value through a {@link Prism}, returning an {@link Optional}.
     *
     * @param optic The prism to read through. Must not be null.
     * @param <S> The state type
     * @param <A> The prism's focus type
     * @return A Free program that reads through the prism
     */
    public static <S, A> Free<StateOpKind.Witness<S>, Optional<A>> preview(Prism<S, A> optic) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Modifies all targets of a {@link Traversal} and returns the modified state.
     *
     * @param optic The traversal to modify through. Must not be null.
     * @param f The modification function. Must not be null.
     * @param <S> The state type
     * @param <A> The focused element type
     * @return A Free program that modifies all traversal targets
     */
    public static <S, A> Free<StateOpKind.Witness<S>, S> traverseOver(Traversal<S, A> optic, Function<A, A> f) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Reads the entire state.
     *
     * @param <S> The state type
     * @return A Free program that returns the entire state
     */
    public static <S> Free<StateOpKind.Witness<S>, S> getState() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a Bound instance for combined-effect programs.
     *
     * @param inject The Inject instance for embedding StateOp into the combined effect type
     * @param functorG The Functor for the combined effect type
     * @param <S> The state type
     * @param <G> The combined effect type
     * @return A Bound instance
     */
    public static <S, G extends WitnessArity<TypeArity.Unary>> Bound<S, G> boundTo(Inject<StateOpKind.Witness<S>, G> inject, Functor<G> functorG) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bound instance for using StateOp in combined-effect programs. Each method lifts a StateOp
     * instruction into the combined effect type G via the provided Inject instance.
     *
     * @param <S> The state type
     * @param <G> The combined effect type
     */
    public static final class Bound<S, G extends WitnessArity<TypeArity.Unary>> {

        private final Inject<StateOpKind.Witness<S>, G> inject;

        private final Functor<G> functorG;

        Bound(Inject<StateOpKind.Witness<S>, G> inject, Functor<G> functorG) {
            this.inject = Validation.function().require(inject, "inject", CONSTRUCTION);
            this.functorG = Validation.function().require(functorG, "functorG", CONSTRUCTION);
        }

        /**
         * Reads a value through a Getter in the combined effect type.
         */
        public <A> Free<G, A> view(Getter<S, A> optic) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Reads a value through a Lens in the combined effect type.
         */
        public <A> Free<G, A> view(Lens<S, A> optic) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Modifies a focus through a Lens in the combined effect type.
         */
        public <A> Free<G, A> over(Lens<S, A> optic, Function<A, A> f) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets a focus through a Lens in the combined effect type.
         */
        public <A> Free<G, A> assign(Lens<S, A> optic, A value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Reads a value through a Prism in the combined effect type.
         */
        public <A> Free<G, Optional<A>> preview(Prism<S, A> optic) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Modifies all Traversal targets in the combined effect type.
         */
        public <A> Free<G, S> traverseOver(Traversal<S, A> optic, Function<A, A> f) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Reads the entire state in the combined effect type.
         */
        public Free<G, S> getState() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
