// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.state;

import static java.util.Objects.requireNonNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record AccountState(BigDecimal balance, List<Transaction> history) {

    public AccountState {
        requireNonNull(balance, "Balance cannot be null.");
        requireNonNull(history, "History cannot be null.");
        // Ensure history is unmodifiable and a defensive copy is made.
        history = Collections.unmodifiableList(new ArrayList<>(history));
    }

    // Convenience constructor for initial state
    public static AccountState initial(BigDecimal initialBalance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AccountState addTransaction(Transaction transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AccountState withBalance(BigDecimal newBalance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
