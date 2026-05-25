// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.validated;

import static org.higherkindedj.hkt.util.validation.Operation.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
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
 * Implements the {@link Traverse} and {@link Foldable} typeclasses for {@link Validated}.
 *
 * <p>Traversal and folding operations are right-biased, meaning they operate on the value inside a
 * {@link Valid} and pass through an {@link Invalid} unchanged.
 *
 * @param <E> The type of the error value.
 */
public final class ValidatedTraverse<E> implements Traverse<ValidatedKind.Witness<E>> {

    private static final ValidatedTraverse<?> INSTANCE = new ValidatedTraverse<>();

    private ValidatedTraverse() {
    }

    @SuppressWarnings("unchecked")
    public static <E> ValidatedTraverse<E> instance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A, B> Kind<ValidatedKind.Witness<E>, B> map(Function<? super A, ? extends B> f, Kind<ValidatedKind.Witness<E>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <G extends WitnessArity<TypeArity.Unary>, A, B> Kind<G, Kind<ValidatedKind.Witness<E>, B>> traverse(Applicative<G> applicative, Function<? super A, ? extends Kind<G, ? extends B>> f, Kind<ValidatedKind.Witness<E>, A> ta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A, M> M foldMap(Monoid<M> monoid, Function<? super A, ? extends M> f, Kind<ValidatedKind.Witness<E>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
