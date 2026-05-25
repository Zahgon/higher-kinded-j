// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.maybe;

import static org.higherkindedj.hkt.maybe.MaybeKindHelper.MAYBE;
import static org.higherkindedj.hkt.util.validation.Operation.*;
import java.util.function.Function;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.Traverse;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.hkt.util.validation.Validation;

/**
 * The Traverse and Foldable instance for {@link Maybe}.
 *
 * <p>Traversal and folding are performed on the 'Just' value. If the instance is 'Nothing', these
 * operations short-circuit or return an empty/identity value.
 */
public enum MaybeTraverse implements Traverse<MaybeKind.Witness> {

    INSTANCE;

    @Override
    public <A, B> Kind<MaybeKind.Witness, B> map(Function<? super A, ? extends B> f, Kind<MaybeKind.Witness, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <G extends WitnessArity<TypeArity.Unary>, A, B> Kind<G, Kind<MaybeKind.Witness, B>> traverse(Applicative<G> applicative, Function<? super A, ? extends Kind<G, ? extends B>> f, Kind<MaybeKind.Witness, A> ta) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <A, M> M foldMap(Monoid<M> monoid, Function<? super A, ? extends M> f, Kind<MaybeKind.Witness, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
