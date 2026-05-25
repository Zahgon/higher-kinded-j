// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.workflow;

import java.util.Optional;
import org.higherkindedj.example.order.model.DiscountResult;
import org.higherkindedj.example.order.model.InventoryReservation;
import org.higherkindedj.example.order.model.NotificationResult;
import org.higherkindedj.example.order.model.OrderRequest;
import org.higherkindedj.example.order.model.PaymentConfirmation;
import org.higherkindedj.example.order.model.ShipmentInfo;
import org.higherkindedj.example.order.model.ValidatedOrder;
import org.higherkindedj.optics.annotations.GenerateFocus;
import org.higherkindedj.optics.annotations.GenerateLenses;

/**
 * Immutable workflow state that accumulates results from each workflow step.
 *
 * <p>This record tracks the progress of an order through the workflow, carrying the original
 * request and accumulated results. Each step uses generated lenses to update specific fields
 * immutably.
 *
 * @param request the original order request
 * @param validatedOrder the validated order, once validation completes
 * @param inventoryReservation the inventory reservation, once inventory is reserved
 * @param discountResult the discount calculation result
 * @param paymentConfirmation the payment confirmation, once payment succeeds
 * @param shipmentInfo the shipment information, once shipment is created
 * @param notificationResult the notification result, once notifications are sent
 */
@GenerateLenses
@GenerateFocus
public record OrderWorkflowState(OrderRequest request, Optional<ValidatedOrder> validatedOrder, Optional<InventoryReservation> inventoryReservation, Optional<DiscountResult> discountResult, Optional<PaymentConfirmation> paymentConfirmation, Optional<ShipmentInfo> shipmentInfo, Optional<NotificationResult> notificationResult) {

    /**
     * Creates the initial workflow state from a request.
     *
     * @param request the order request
     * @return a new workflow state
     */
    public static OrderWorkflowState start(OrderRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new state with the validated order set.
     *
     * @param order the validated order
     * @return updated state
     */
    public OrderWorkflowState withValidatedOrder(ValidatedOrder order) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new state with the inventory reservation set.
     *
     * @param reservation the inventory reservation
     * @return updated state
     */
    public OrderWorkflowState withInventoryReservation(InventoryReservation reservation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new state with the discount result set.
     *
     * @param result the discount result
     * @return updated state
     */
    public OrderWorkflowState withDiscountResult(DiscountResult result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new state with the payment confirmation set.
     *
     * @param confirmation the payment confirmation
     * @return updated state
     */
    public OrderWorkflowState withPaymentConfirmation(PaymentConfirmation confirmation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new state with the shipment info set.
     *
     * @param info the shipment info
     * @return updated state
     */
    public OrderWorkflowState withShipmentInfo(ShipmentInfo info) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new state with the notification result set.
     *
     * @param result the notification result
     * @return updated state
     */
    public OrderWorkflowState withNotificationResult(NotificationResult result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
