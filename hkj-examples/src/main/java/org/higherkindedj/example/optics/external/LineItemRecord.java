// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.external;

import java.math.BigDecimal;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * A builder-based immutable class representing an order line item.
 *
 * <p>This class simulates a line item entity that might come from JOOQ code generation or similar
 * ORM tools. It demonstrates the builder pattern that {@code @ViaBuilder} optics can target.
 *
 * <p>Used together with {@link OrderRecord} to demonstrate {@code @ThroughField} traversals into
 * collection fields.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * LineItemRecord item = LineItemRecord.builder()
 *     .productId("SKU-001")
 *     .productName("Widget")
 *     .quantity(3)
 *     .unitPrice(new BigDecimal("29.99"))
 *     .build();
 *
 * // Create modified copy using builder
 * LineItemRecord updated = item.toBuilder()
 *     .quantity(5)
 *     .build();
 * }</pre>
 *
 * @see OrderRecord
 * @see OrderRecordOpticsSpec
 */
public final class LineItemRecord {

    private final String productId;

    private final String productName;

    private final int quantity;

    private final BigDecimal unitPrice;

    private LineItemRecord(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
    }

    /**
     * Returns a new builder for creating LineItemRecord instances.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a builder pre-populated with this record's values for creating modified copies.
     */
    public Builder toBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the product ID (SKU).
     */
    public String productId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the product name.
     */
    public String productName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the quantity ordered.
     */
    public int quantity() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the unit price.
     */
    public BigDecimal unitPrice() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Calculates the line total (quantity * unitPrice).
     */
    public BigDecimal lineTotal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(@Nullable Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Builder for creating LineItemRecord instances.
     */
    public static final class Builder {

        @Nullable
        private String productId;

        @Nullable
        private String productName;

        private int quantity;

        @Nullable
        private BigDecimal unitPrice;

        private Builder() {
        }

        /**
         * Sets the product ID.
         */
        public Builder productId(String productId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the product name.
         */
        public Builder productName(String productName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the quantity.
         */
        public Builder quantity(int quantity) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the unit price.
         */
        public Builder unitPrice(BigDecimal unitPrice) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Builds the LineItemRecord instance.
         */
        public LineItemRecord build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
