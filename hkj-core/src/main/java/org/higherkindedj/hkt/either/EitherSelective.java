// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.either;

import static org.higherkindedj.hkt.either.EitherKindHelper.EITHER;
import static org.higherkindedj.hkt.util.validation.Operation.*;
import java.util.function.Function;
import org.higherkindedj.hkt.Choice;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Selective;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.util.validation.Validation;

/**
 * Implements the {@link Selective} type class for {@link Either}, with a fixed "Left" type {@code
 * L}. This provides selective applicative operations that allow conditional execution based on the
 * result of previous computations.
 *
 * <p>The Selective interface sits between {@link org.higherkindedj.hkt.Applicative} and {@link
 * org.higherkindedj.hkt.Monad} in terms of power. It allows for static analysis of effects while
 * still supporting conditional behaviour, unlike pure Applicatives which have no conditional
 * execution, and Monads which are fully dynamic.
 *
 * <p>Key operations:
 *
 * <ul>
 *   <li>{@link #select(Kind, Kind)}: Conditionally applies an effectful function based on a Choice.
 *   <li>{@link #branch(Kind, Kind, Kind)}: Provides two-way conditional choice with different
 *       handlers.
 *   <li>{@link #whenS(Kind, Kind)}: Conditionally executes an effect based on a boolean.
 *   <li>{@link #ifS(Kind, Kind, Kind)}: Ternary conditional for selective functors.
 * </ul>
 *
 * <p>This implementation is right-biased: operations work on {@link Either.Right} values and
 * propagate {@link Either.Left} unchanged.
 *
 * @param <L> The fixed type for the "Left" value, representing errors or alternative values.
 * @see Either
 * @see EitherMonad
 * @see Selective
 * @see Choice
 */
public final class EitherSelective<L> extends EitherMonad<L> implements Selective<EitherKind.Witness<L>> {

    private static final EitherSelective<?> INSTANCE = new EitherSelective<>();

    private EitherSelective() {
        super();
    }

    /**
     * Returns the singleton instance of {@code EitherSelective} for the specified Left type.
     *
     * @param <L> The type of the Left value (error type).
     * @return The singleton instance.
     */
    @SuppressWarnings("unchecked")
    public static <L> EitherSelective<L> instance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The core selective operation for Either. Given an effectful choice {@code fab} and an effectful
     * function {@code ff}, applies the function only if the choice is a {@code Left}.
     *
     * <p>Since Either already implements Choice, we can work with it directly without conversion.
     *
     * <p>Behavior:
     *
     * <ul>
     *   <li>If {@code fab} is {@code Right(b)}: Returns {@code Right(b)}, {@code ff} is not
     *       evaluated.
     *   <li>If {@code fab} is {@code Left(a)}: Applies the function from {@code ff} to {@code a}.
     *   <li>If both {@code fab} and {@code ff} are {@code Left}: Returns the first {@code Left}
     *       (fail-fast).
     * </ul>
     *
     * @param fab A {@link Kind} representing {@code Either<L, Choice<A, B>>}. Must not be null.
     * @param ff A {@link Kind} representing {@code Either<L, Function<A, B>>}. Must not be null.
     * @param <A> The input type of the function (the type inside {@code Left} of the Choice).
     * @param <B> The output type and the type inside {@code Right} of the Choice.
     * @return A {@link Kind} representing {@code Either<L, B>}. Never null.
     * @throws NullPointerException if {@code fab} or {@code ff} is null.
     * @throws org.higherkindedj.hkt.exception.KindUnwrapException if {@code fab} or {@code ff} cannot
     *     be unwrapped.
     */
    @Override
    public <A, B> Kind<EitherKind.Witness<L>, B> select(Kind<EitherKind.Witness<L>, Choice<A, B>> fab, Kind<EitherKind.Witness<L>, Function<A, B>> ff) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Optimised implementation of {@code branch} for Either. Provides a two-way conditional choice,
     * applying the appropriate handler based on whether the Choice is Left or Right.
     *
     * <p>This implementation is more efficient than the default because it can short-circuit on the
     * first Left (error) encountered.
     *
     * @param fab A {@link Kind} representing {@code Either<L, Choice<A, B>>}. Must not be null.
     * @param fl A {@link Kind} representing {@code Either<L, Function<A, C>>} for the Left case. Must
     *     not be null.
     * @param fr A {@link Kind} representing {@code Either<L, Function<B, C>>} for the Right case.
     *     Must not be null.
     * @param <A> The type inside {@code Left} of the Choice.
     * @param <B> The type inside {@code Right} of the Choice.
     * @param <C> The result type.
     * @return A {@link Kind} representing {@code Either<L, C>}. Never null.
     */
    @Override
    public <A, B, C> Kind<EitherKind.Witness<L>, C> branch(Kind<EitherKind.Witness<L>, Choice<A, B>> fab, Kind<EitherKind.Witness<L>, Function<A, C>> fl, Kind<EitherKind.Witness<L>, Function<B, C>> fr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Conditionally executes a Unit-returning effect based on a boolean condition.
     *
     * <p>Key improvement: Returns Either.right(Unit.INSTANCE) instead of Either.right(null), making
     * the "no-op" case explicit and type-safe.
     *
     * @param fcond The effectful condition
     * @param fa The Unit-returning effect to execute if condition is true
     * @return Either with Unit result
     */
    @Override
    public Kind<EitherKind.Witness<L>, Unit> whenS(Kind<EitherKind.Witness<L>, Boolean> fcond, Kind<EitherKind.Witness<L>, Unit> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Optimised implementation of {@code ifS} for Either. A ternary conditional operator for
     * selective functors.
     *
     * @param fcond A {@link Kind} representing {@code Either<L, Boolean>}. Must not be null.
     * @param fthen A {@link Kind} representing {@code Either<L, A>} for the true branch. Must not be
     *     null.
     * @param felse A {@link Kind} representing {@code Either<L, A>} for the false branch. Must not be
     *     null.
     * @param <A> The type of the result.
     * @return A {@link Kind} representing {@code Either<L, A>}. Never null.
     */
    @Override
    public <A> Kind<EitherKind.Witness<L>, A> ifS(Kind<EitherKind.Witness<L>, Boolean> fcond, Kind<EitherKind.Witness<L>, A> fthen, Kind<EitherKind.Witness<L>, A> felse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
