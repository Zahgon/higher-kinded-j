// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.either;

import static org.higherkindedj.hkt.either.EitherKindHelper.EITHER;
import static org.higherkindedj.hkt.util.validation.Operation.*;
import java.util.function.Function;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Foldable;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.Traverse;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.hkt.util.validation.Validation;

/**
 * Implements the {@link Traverse} and {@link Foldable} typeclasses for {@link Either}, using {@link
 * EitherKind.Witness} as the higher-kinded type witness.
 *
 * <p>Traversal and folding operations are right-biased, meaning they operate on the value inside a
 * {@link Either.Right} and pass through a {@link Either.Left} unchanged.
 *
 * @param <E> The type of the left-hand value (typically an error).
 */
public final class EitherTraverse<E> implements Traverse<EitherKind.Witness<E>> {

    private static final EitherTraverse<?> INSTANCE = new EitherTraverse<>();

    private EitherTraverse() {
        // Private constructor to prevent external instantiation
    }

    /**
     * Returns the singleton instance of {@code EitherTraverse} for the specified error type.
     *
     * @param <E> The type of the error value
     * @return The singleton {@code EitherTraverse} instance
     */
    @SuppressWarnings("unchecked")
    public static <E> EitherTraverse<E> instance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies a function to the "Right" value if the provided {@link Kind} represents a {@link
     * Either.Right}. If it represents a {@link Either.Left}, the "Left" value is propagated
     * unchanged.
     *
     * <p>This implementation delegates to the {@link Either#map} method after narrowing the Kind.
     *
     * @param f The function to apply to the "Right" value. Must not be null.
     * @param fa The input {@code Kind<EitherKind.Witness<E>, A>}, representing an {@code Either<E,
     *     A>}. Must not be null.
     * @param <A> The type of the "Right" value in the input {@code Either}.
     * @param <B> The type of the "Right" value in the resulting {@code Either} after function
     *     application.
     * @return A new {@code Kind<EitherKind.Witness<E>, B>} representing the transformed {@code
     *     Either<E, B>}. Never null.
     * @throws NullPointerException if {@code f} or {@code fa} is null.
     * @throws org.higherkindedj.hkt.exception.KindUnwrapException if {@code fa} cannot be unwrapped
     *     to a valid {@code Either} representation.
     */
    @Override
    public <A, B> Kind<EitherKind.Witness<E>, B> map(Function<? super A, ? extends B> f, Kind<EitherKind.Witness<E>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Traverses this Either structure, applying a function {@code f} to the "Right" value that
     * results in an Applicative effect {@code Kind<G, B>}. If this is a "Left", the effect is lifted
     * into the applicative context containing the original "Left" value.
     *
     * <p>This is right-biased: only "Right" values are transformed, while "Left" values pass through
     * unchanged wrapped in the target applicative context.
     *
     * @param <G> The type constructor of the applicative effect (e.g., {@code Maybe.Witness}, {@code
     *     List.Witness}).
     * @param <A> The type of elements in the input Either (the "Right" type).
     * @param <B> The type of elements in the output Either after transformation, wrapped in effect
     *     {@code G}.
     * @param applicative The {@link Applicative} instance for the effect type {@code G}. Must not be
     *     null.
     * @param f A function from {@code A} to {@code Kind<G, B>}, producing an effectful value. Must
     *     not be null.
     * @param ta The traversable Either structure {@code Kind<EitherKind.Witness<E>, A>}. Must not be
     *     null.
     * @return An applicative effect {@code Kind<G, Kind<EitherKind.Witness<E>, B>>}, which is the
     *     Either structure of results {@code B}, all wrapped in the effect {@code G}. For example,
     *     {@code Maybe<Either<E, B>>} or {@code List<Either<E, B>>}. Never null.
     * @throws NullPointerException if {@code applicative}, {@code f}, or {@code ta} is null.
     * @throws org.higherkindedj.hkt.exception.KindUnwrapException if {@code ta} cannot be unwrapped
     *     to a valid {@code Either} representation.
     */
    @Override
    public <G extends WitnessArity<TypeArity.Unary>, A, B> Kind<G, Kind<EitherKind.Witness<E>, B>> traverse(Applicative<G> applicative, Function<? super A, ? extends Kind<G, ? extends B>> f, Kind<EitherKind.Witness<E>, A> ta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Maps each element of the Either to a {@link Monoid} {@code M} and combines the results. This is
     * right-biased: only "Right" values are mapped and contribute to the result, while "Left" values
     * result in the monoid's empty value.
     *
     * @param monoid The Monoid used to combine the results. Must not be null.
     * @param f A function to map the "Right" element of type {@code A} to the Monoidal type {@code
     *     M}. This function can accept any supertype of {@code A} and return any subtype of {@code
     *     M}. Must not be null.
     * @param fa The foldable Either structure {@code Kind<EitherKind.Witness<E>, A>}. Must not be
     *     null.
     * @param <A> The type of elements in the Either structure (the "Right" type).
     * @param <M> The Monoidal type.
     * @return The aggregated result of type {@code M}. For "Left" values, returns {@code
     *     monoid.empty()}. For "Right" values, returns {@code f.apply(rightValue)}. Never null.
     * @throws NullPointerException if {@code monoid}, {@code f}, or {@code fa} is null.
     * @throws org.higherkindedj.hkt.exception.KindUnwrapException if {@code fa} cannot be unwrapped
     *     to a valid {@code Either} representation.
     */
    @Override
    public <A, M> M foldMap(Monoid<M> monoid, Function<? super A, ? extends M> f, Kind<EitherKind.Witness<E>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
