// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.higherkindedj.example.order.error.OrderError;
import org.higherkindedj.example.order.model.Customer;
import org.higherkindedj.example.order.model.NotificationResult;
import org.higherkindedj.example.order.model.ShipmentInfo;
import org.higherkindedj.example.order.model.value.Money;
import org.higherkindedj.example.order.model.value.OrderId;
import org.higherkindedj.example.order.service.NotificationService;
import org.higherkindedj.hkt.either.Either;

/**
 * In-memory implementation of NotificationService for testing and examples.
 *
 * <p>Tracks sent notifications for verification in tests.
 */
public class InMemoryNotificationService implements NotificationService {

    private final List<NotificationRecord> sentNotifications = new ArrayList<>();

    private boolean emailEnabled = true;

    private boolean smsEnabled = true;

    public void setEmailEnabled(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setSmsEnabled(boolean enabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<NotificationRecord> getSentNotifications() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void clearNotifications() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, NotificationResult> sendOrderConfirmation(OrderId orderId, Customer customer, Money total) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, NotificationResult> sendShipmentNotification(OrderId orderId, Customer customer, ShipmentInfo shipmentInfo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, NotificationResult> sendCancellationNotification(OrderId orderId, Customer customer, String reason) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Record of a sent notification for testing verification.
     */
    public record NotificationRecord(NotificationType type, String recipient, String message) {
    }

    /**
     * Types of notifications sent.
     */
    public enum NotificationType {

        ORDER_CONFIRMATION, ORDER_CONFIRMATION_SMS, SHIPMENT_NOTIFICATION, SHIPMENT_NOTIFICATION_SMS, CANCELLATION
    }
}
