// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.state_t;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.optional.OptionalKindHelper.OPTIONAL;
import static org.higherkindedj.hkt.state_t.StateTKindHelper.STATE_T;
import java.util.Optional;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.MonadError;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.id.IdKind;
import org.higherkindedj.hkt.id.IdKindHelper;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.optional.OptionalKind;
import org.higherkindedj.hkt.state.StateTuple;
import org.higherkindedj.hkt.state_t.StateT;
import org.higherkindedj.hkt.state_t.StateTKind;

public class StateTExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <S, F extends WitnessArity<TypeArity.Unary>> Kind<StateTKind.Witness<S, F>, S> get(Monad<F> monadF) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Usage: stateTMonad.flatMap(currentState -> ..., get(optionalMonad))
    public static <S, F extends WitnessArity<TypeArity.Unary>> Kind<StateTKind.Witness<S, F>, Void> set(S newState, Monad<F> monadF) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <S, F extends WitnessArity<TypeArity.Unary>> Kind<StateTKind.Witness<S, F>, Void> modify(Function<S, S> f, Monad<F> monadF) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <S, F extends WitnessArity<TypeArity.Unary>, A> Kind<StateTKind.Witness<S, F>, A> gets(Function<S, A> f, Monad<F> monadF) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- mapT: Switching from Optional to Id ---
    //
    // mapT swaps the outer monad without touching the state-threading logic.
    // StateT uniquely requires a new Monad instance because it stores its monad
    // for internal sequencing.
    public static void mapTExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
