// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.state;

import static org.higherkindedj.hkt.state.StateKindHelper.STATE;
import java.util.function.Function;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.util.validation.Validation;
import org.jspecify.annotations.Nullable;

/**
 * Applicative implementation for {@link State}, using {@link StateKind.Witness} as the HKT marker.
 * An instance of this class is specific to a state type {@code S}. It extends {@link StateFunctor}.
 *
 * @param <S> The type of the state (fixed for this Applicative instance).
 * @see State
 * @see StateKind.Witness
 * @see StateFunctor
 */
public class StateApplicative<S> extends StateFunctor<S> implements Applicative<StateKind.Witness<S>> {

    /**
     * Lifts a value into a {@code State} context, represented as {@code Kind<StateKind.Witness<S>,
     * A>}. The state remains unchanged.
     *
     * @param <A> The type of the value.
     * @param value The value to lift. Can be {@code null}.
     * @return A {@code Kind<StateKind.Witness<S>, A>} representing {@code State.pure(value)}.
     */
    @Override
    public <A> Kind<StateKind.Witness<S>, A> of(@Nullable A value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies a function wrapped in a {@code Kind<StateKind.Witness<S>, Function<A, B>>}
     * (representing a {@code State<S, Function<A,B>>}) to a value wrapped in a {@code
     * Kind<StateKind.Witness<S>, A>} (representing a {@code State<S, A>}). The state is threaded
     * through both computations.
     *
     * @param <A> The input type of the function.
     * @param <B> The output type of the function.
     * @param ff The {@code Kind<StateKind.Witness<S>, Function<A, B>>} containing the function.
     * @param fa The {@code Kind<StateKind.Witness<S>, A>} containing the value.
     * @return A new {@code Kind<StateKind.Witness<S>, B>} resulting from the application.
     * @throws NullPointerException if {@code ff} or {@code fa} is null, or if the function wrapped in
     *     the State is null.
     * @throws org.higherkindedj.hkt.exception.KindUnwrapException if {@code ff} or {@code fa} cannot
     *     be unwrapped to valid {@code State} representations.
     */
    @Override
    public <A, B> Kind<StateKind.Witness<S>, B> ap(Kind<StateKind.Witness<S>, ? extends Function<A, B>> ff, Kind<StateKind.Witness<S>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
