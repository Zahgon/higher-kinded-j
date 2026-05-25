// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.market.model.value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * A decimal price value with fixed scale.
 *
 * @param value the price as a BigDecimal
 */
public record Price(BigDecimal value) implements Comparable<Price> {

    public Price {
        Objects.requireNonNull(value, "price value must not be null");
    }

    public static Price of(String s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Price of(double d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Price multiply(BigDecimal factor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Price add(Price other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Price subtract(Price other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double toDouble() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int compareTo(Price other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
