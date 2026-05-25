// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.model;

/**
 * Order lifecycle status.
 */
public enum OrderStatus {

    /**
     * Order has been created but not yet validated.
     */
    PENDING,
    /**
     * Order has been validated and is being processed.
     */
    PROCESSING,
    /**
     * Inventory has been reserved for the order.
     */
    INVENTORY_RESERVED,
    /**
     * Payment has been processed successfully.
     */
    PAYMENT_COMPLETE,
    /**
     * Shipment has been created.
     */
    SHIPPED,
    /**
     * Order has been delivered.
     */
    DELIVERED,
    /**
     * Order has been cancelled.
     */
    CANCELLED,
    /**
     * Order has been refunded.
     */
    REFUNDED,
    /**
     * Order partially fulfilled (some items shipped, others back-ordered).
     */
    PARTIALLY_FULFILLED;

    /**
     * Checks if the order can be cancelled in this status.
     *
     * @return true if cancellation is allowed
     */
    public boolean isCancellable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if the order is in a terminal state.
     *
     * @return true if no further state transitions are possible
     */
    public boolean isTerminal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if inventory should be released on cancellation.
     *
     * @return true if inventory was reserved
     */
    public boolean hasReservedInventory() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if a refund is required on cancellation.
     *
     * @return true if payment was processed
     */
    public boolean requiresRefund() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
