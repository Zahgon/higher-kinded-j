// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.state;

import static org.higherkindedj.hkt.state.StateKindHelper.STATE;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.expression.For;
import org.higherkindedj.hkt.state.*;

/**
 * see {<a href="https://higher-kinded-j.github.io/state_monad.html">Managing State
 * Functionally</a>}
 */
public class BankAccountWorkflow {

    private static final StateMonad<AccountState> accountStateMonad = new StateMonad<>();

    public static Function<BigDecimal, Kind<StateKind.Witness<AccountState>, Unit>> deposit(String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Function<BigDecimal, Kind<StateKind.Witness<AccountState>, Boolean>> withdraw(String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Kind<StateKind.Witness<AccountState>, BigDecimal> getBalance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Kind<StateKind.Witness<AccountState>, List<Transaction>> getHistory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
