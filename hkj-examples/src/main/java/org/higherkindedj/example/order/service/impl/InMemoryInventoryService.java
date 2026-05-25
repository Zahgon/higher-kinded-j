// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.higherkindedj.example.order.error.OrderError;
import org.higherkindedj.example.order.model.InventoryReservation;
import org.higherkindedj.example.order.model.ProductAvailability;
import org.higherkindedj.example.order.model.ValidatedOrderLine;
import org.higherkindedj.example.order.model.value.OrderId;
import org.higherkindedj.example.order.service.InventoryService;
import org.higherkindedj.hkt.either.Either;

/**
 * In-memory implementation of InventoryService for testing and examples.
 *
 * <p><strong>Thread Safety Note:</strong> While this implementation uses ConcurrentHashMap for
 * storage, the {@link #reserve} method is not fully atomic. It checks availability first, then
 * reserves stock in a separate operation. In a concurrent environment, this could lead to race
 * conditions (e.g., overselling). This is acceptable for testing and demonstration purposes but
 * would require proper synchronisation or database transactions in production.
 */
public class InMemoryInventoryService implements InventoryService {

    private final Map<String, Integer> stock = new ConcurrentHashMap<>();

    private final Map<String, String> productWarehouses = new ConcurrentHashMap<>();

    private final Map<String, InventoryReservation> reservations = new ConcurrentHashMap<>();

    public InMemoryInventoryService() {
        // Pre-populate with sample stock across different warehouses
        stock.put("PROD-001", 100);
        stock.put("PROD-002", 50);
        stock.put("PROD-003", 25);
        // Out of stock
        stock.put("PROD-004", 0);
        stock.put("PROD-005", 10);
        stock.put("PROD-006", 5);
        // Assign products to warehouses for split shipment demos
        productWarehouses.put("PROD-001", "WAREHOUSE-UK-01");
        productWarehouses.put("PROD-002", "WAREHOUSE-UK-01");
        productWarehouses.put("PROD-003", "WAREHOUSE-EU-01");
        productWarehouses.put("PROD-004", "WAREHOUSE-UK-01");
        productWarehouses.put("PROD-005", "WAREHOUSE-EU-01");
        productWarehouses.put("PROD-006", "WAREHOUSE-INTL-01");
    }

    public void setStock(String productId, int quantity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStock(String productId, int quantity, String warehouseId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, InventoryCheckResult> checkAvailability(List<ValidatedOrderLine> lines) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, InventoryReservation> reserve(OrderId orderId, List<ValidatedOrderLine> lines) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, Void> confirmReservation(String reservationId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, Void> releaseReservation(String reservationId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, List<ProductAvailability>> getDetailedAvailability(List<ValidatedOrderLine> lines) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, InventoryReservation> reserveAvailable(OrderId orderId, List<ProductAvailability> availability) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
