// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.state;

import static org.higherkindedj.hkt.state.StateKindHelper.STATE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.expression.For;
import org.higherkindedj.hkt.state.State;
import org.higherkindedj.hkt.state.StateKind;
import org.higherkindedj.hkt.state.StateMonad;
import org.higherkindedj.hkt.state.StateTuple;

/**
 * see {<a href="https://higher-kinded-j.github.io/state_monad.html">State Monad</a>}
 */
public class StateExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void runStateExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    record CounterState(int count) {
    }

    record StackState(List<Integer> stack) {
    }
}
