// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.validated;

import static org.higherkindedj.hkt.util.validation.Operation.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.higherkindedj.hkt.*;
import org.higherkindedj.hkt.util.validation.Validation;

/**
 * Implements the {@link Selective} type class for {@link Validated}, with a fixed error type {@code
 * E}. This provides selective applicative operations with error accumulation.
 *
 * <p>Unlike {@link org.higherkindedj.hkt.either.EitherSelective} which fails fast on the first
 * error, {@code ValidatedSelective} accumulates all errors using the provided {@link Semigroup}.
 * This is the key advantage of Validated over Either for validation scenarios.
 *
 * <p>The Selective interface sits between {@link org.higherkindedj.hkt.Applicative} and {@link
 * org.higherkindedj.hkt.Monad} in terms of power. For Validated with error accumulation:
 *
 * <ul>
 *   <li>{@link Valid} values: Operations are applied
 *   <li>{@link Invalid} values: Errors are accumulated using the semigroup
 *   <li>Multiple invalids: All errors are combined, not just the first
 * </ul>
 *
 * <p>Key operations:
 *
 * <ul>
 *   <li>{@link #select(Kind, Kind)}: Conditionally applies an effectful function, accumulating
 *       errors.
 *   <li>{@link #branch(Kind, Kind, Kind)}: Provides two-way conditional choice with error
 *       accumulation.
 *   <li>{@link #whenS(Kind, Kind)}: Conditionally executes an effect, accumulating errors.
 *   <li>{@link #ifS(Kind, Kind, Kind)}: Ternary conditional with error accumulation.
 * </ul>
 *
 * <p>This class requires a {@link Semigroup} for combining errors. Use the {@link
 * #instance(Semigroup)} factory method to create instances.
 *
 * @param <E> The fixed type for the error value.
 * @see Validated
 * @see ValidatedMonad
 * @see Selective
 * @see Semigroup
 */
public final class ValidatedSelective<E> extends ValidatedMonad<E> implements Selective<ValidatedKind.Witness<E>> {

    private final Semigroup<E> semigroup;

    /**
     * Constructs a {@code ValidatedSelective} with the specified semigroup for error accumulation.
     *
     * @param semigroup The semigroup for combining errors. Must not be null.
     */
    private ValidatedSelective(Semigroup<E> semigroup) {
        super(semigroup);
        this.semigroup = semigroup;
    }

    /**
     * Provides an instance of {@code ValidatedSelective} for a given error type {@code E}, which
     * requires a {@link Semigroup} for error accumulation.
     *
     * @param semigroup The semigroup for combining errors. Must not be null.
     * @param <E> The error type.
     * @return A new instance of {@code ValidatedSelective}.
     * @throws NullPointerException if {@code semigroup} is null.
     */
    public static <E> ValidatedSelective<E> instance(Semigroup<E> semigroup) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The core selective operation for Validated with error accumulation. Given an effectful choice
     * {@code fab} and an effectful function {@code ff}, applies the function only if the choice is a
     * {@code Left}, accumulating any errors encountered.
     *
     * <p>Behavior with error accumulation:
     *
     * <ul>
     *   <li>If {@code fab} is {@code Valid(Choice.Right(b))}: Returns {@code Valid(b)}, {@code ff} is
     *       not evaluated.
     *   <li>If {@code fab} is {@code Valid(Choice.Left(a))} and {@code ff} is {@code
     *       Valid(function)}: Returns {@code Valid(function.apply(a))}.
     *   <li>If {@code fab} is {@code Invalid(e1)} and {@code ff} is {@code Invalid(e2)}: Returns
     *       {@code Invalid(semigroup.combine(e1, e2))}.
     *   <li>If only one is {@code Invalid}: Returns that {@code Invalid}.
     * </ul>
     *
     * @param fab A {@link Kind} representing {@code Validated<E, Choice<A, B>>}. Must not be null.
     * @param ff A {@link Kind} representing {@code Validated<E, Function<A, B>>}. Must not be null.
     * @param <A> The input type of the function (the type inside {@code Left} of the Choice).
     * @param <B> The output type and the type inside {@code Right} of the Choice.
     * @return A {@link Kind} representing {@code Validated<E, B>}. Never null.
     * @throws NullPointerException if {@code fab} or {@code ff} is null.
     * @throws org.higherkindedj.hkt.exception.KindUnwrapException if {@code fab} or {@code ff} cannot
     *     be unwrapped.
     */
    @Override
    public <A, B> Kind<ValidatedKind.Witness<E>, B> select(Kind<ValidatedKind.Witness<E>, Choice<A, B>> fab, Kind<ValidatedKind.Witness<E>, Function<A, B>> ff) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Optimised implementation of {@code branch} for Validated with error accumulation. Provides a
     * two-way conditional choice, applying the appropriate handler and accumulating all errors.
     *
     * @param fab A {@link Kind} representing {@code Validated<E, Choice<A, B>>}. Must not be null.
     * @param fl A {@link Kind} representing {@code Validated<E, Function<A, C>>} for the Left case.
     *     Must not be null.
     * @param fr A {@link Kind} representing {@code Validated<E, Function<B, C>>} for the Right case.
     *     Must not be null.
     * @param <A> The type inside {@code Left} of the Choice.
     * @param <B> The type inside {@code Right} of the Choice.
     * @param <C> The result type.
     * @return A {@link Kind} representing {@code Validated<E, C>}. Never null.
     */
    @Override
    public <A, B, C> Kind<ValidatedKind.Witness<E>, C> branch(Kind<ValidatedKind.Witness<E>, Choice<A, B>> fab, Kind<ValidatedKind.Witness<E>, Function<A, C>> fl, Kind<ValidatedKind.Witness<E>, Function<B, C>> fr) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Conditionally executes a Unit-returning effect based on a boolean condition, with error
     * accumulation.
     *
     * <p>Key improvement: Returns Valid(Unit.INSTANCE) instead of Valid(null), making the "skipped
     * effect" case explicit and type-safe.
     *
     * @param fcond The effectful condition
     * @param fa The Unit-returning effect to execute if condition is true
     * @return Validated with Unit result
     */
    @Override
    public Kind<ValidatedKind.Witness<E>, Unit> whenS(Kind<ValidatedKind.Witness<E>, Boolean> fcond, Kind<ValidatedKind.Witness<E>, Unit> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Optimised implementation of {@code ifS} for Validated with error accumulation. A ternary
     * conditional operator that accumulates errors from all branches.
     *
     * @param fcond A {@link Kind} representing {@code Validated<E, Boolean>}. Must not be null.
     * @param fthen A {@link Kind} representing {@code Validated<E, A>} for the true branch. Must not
     *     be null.
     * @param felse A {@link Kind} representing {@code Validated<E, A>} for the false branch. Must not
     *     be null.
     * @param <A> The type of the result.
     * @return A {@link Kind} representing {@code Validated<E, A>}. Never null.
     */
    @Override
    public <A> Kind<ValidatedKind.Witness<E>, A> ifS(Kind<ValidatedKind.Witness<E>, Boolean> fcond, Kind<ValidatedKind.Witness<E>, A> fthen, Kind<ValidatedKind.Witness<E>, A> felse) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
