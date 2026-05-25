// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.io.IOKindHelper.IO_OP;
import static org.higherkindedj.hkt.list.ListKindHelper.LIST;
import static org.higherkindedj.hkt.optional.OptionalKindHelper.OPTIONAL;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.higherkindedj.hkt.Functor;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.MonadError;
import org.higherkindedj.hkt.MonadZero;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.hkt.exception.KindUnwrapException;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.io.IOKind;
import org.higherkindedj.hkt.list.ListKind;
import org.higherkindedj.hkt.optional.OptionalKind;

/**
 * see {<a href="https://higher-kinded-j.github.io/usage=guide.html">Usage Guide</a>}
 */
public class GenericExample {

    // Generic function: Doubles the number inside any Functor context F_WITNESS.
    // Requires the specific Functor<F_WITNESS> instance to be passed in.
    public static <F_WITNESS extends WitnessArity<TypeArity.Unary>, A, B> Kind<F_WITNESS, B> mapWithFunctor(// Pass the type class instance for F_WITNESS
    Functor<F_WITNESS> functorInstance, Function<A, B> fn, Kind<F_WITNESS, A> kindABox) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void basicUsageExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void handlingUnwrapExceptions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void genricExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
