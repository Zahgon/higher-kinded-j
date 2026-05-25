// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.model;

import java.time.Instant;
import java.util.List;
import org.higherkindedj.example.order.model.value.Money;
import org.higherkindedj.example.order.model.value.OrderId;
import org.higherkindedj.optics.annotations.GenerateLenses;

/**
 * Result of creating split shipments from multiple warehouses. Tracks all shipments and provides
 * aggregate information.
 *
 * @param orderId the order identifier
 * @param shipments list of individual shipments
 * @param latestEstimatedDelivery the latest estimated delivery across all shipments
 * @param totalShippingCost combined shipping cost for all shipments
 */
@GenerateLenses
public record SplitShipmentResult(OrderId orderId, List<ShipmentInfo> shipments, Instant latestEstimatedDelivery, Money totalShippingCost) {

    /**
     * Returns the number of shipments created.
     *
     * @return the shipment count
     */
    public int shipmentCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns all tracking numbers for this order.
     *
     * @return list of tracking numbers
     */
    public List<String> allTrackingNumbers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Checks if this is actually a split shipment (multiple shipments).
     *
     * @return true if more than one shipment exists
     */
    public boolean isSplit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the earliest shipment date.
     *
     * @return the earliest estimated delivery
     */
    public Instant earliestEstimatedDelivery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a single-shipment result (not actually split).
     *
     * @param orderId the order ID
     * @param shipment the single shipment
     * @return a SplitShipmentResult with one shipment
     */
    public static SplitShipmentResult single(OrderId orderId, ShipmentInfo shipment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a split shipment result from multiple shipments.
     *
     * @param orderId the order ID
     * @param shipments the list of shipments
     * @return a SplitShipmentResult
     */
    public static SplitShipmentResult fromShipments(OrderId orderId, List<ShipmentInfo> shipments) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
