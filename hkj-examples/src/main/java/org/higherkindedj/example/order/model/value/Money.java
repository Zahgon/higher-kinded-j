// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.model.value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Objects;
import org.higherkindedj.optics.annotations.GenerateLenses;

/**
 * Currency-aware money value object.
 *
 * <p>Provides arithmetic operations that preserve currency safety and proper decimal handling.
 *
 * @param amount the monetary amount
 * @param currency the currency
 */
@GenerateLenses
public record Money(BigDecimal amount, Currency currency) {

    /**
     * Zero pounds sterling.
     */
    public static final Money ZERO_GBP = new Money(BigDecimal.ZERO, Currency.getInstance("GBP"));

    public Money {
        Objects.requireNonNull(amount, "amount cannot be null");
        Objects.requireNonNull(currency, "currency cannot be null");
    }

    /**
     * Creates a Money instance for the given amount in GBP.
     *
     * @param amount the amount
     * @return a Money in GBP
     */
    public static Money gbp(BigDecimal amount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a Money instance for the given amount in GBP.
     *
     * @param amount the amount as a string
     * @return a Money in GBP
     */
    public static Money gbp(String amount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds another Money value, requiring matching currencies.
     *
     * @param other the amount to add
     * @return the sum
     * @throws IllegalArgumentException if currencies do not match
     */
    public Money add(Money other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Subtracts another Money value, requiring matching currencies.
     *
     * @param other the amount to subtract
     * @return the difference
     * @throws IllegalArgumentException if currencies do not match
     */
    public Money subtract(Money other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Multiplies by a quantity.
     *
     * @param quantity the multiplier
     * @return the product
     */
    public Money multiply(int quantity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies a percentage discount.
     *
     * @param discount the discount percentage
     * @return the discounted amount
     */
    public Money applyDiscount(Percentage discount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if this amount is positive.
     *
     * @return true if amount is greater than zero
     */
    public boolean isPositive() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if this amount is zero or negative.
     *
     * @return true if amount is zero or less
     */
    public boolean isZeroOrNegative() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void requireSameCurrency(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch: " + currency + " vs " + other.currency);
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
