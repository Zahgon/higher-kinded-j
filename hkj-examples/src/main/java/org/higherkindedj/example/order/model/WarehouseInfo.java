// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.model;

import java.math.BigDecimal;

/**
 * Information about a warehouse for split shipment processing.
 *
 * @param warehouseId unique warehouse identifier
 * @param name warehouse name
 * @param location warehouse location/region
 * @param shippingCost base shipping cost from this warehouse
 * @param processingDays typical days to process shipments
 */
public record WarehouseInfo(String warehouseId, String name, String location, BigDecimal shippingCost, int processingDays) {

    /**
     * Creates a warehouse in the UK.
     *
     * @param warehouseId the warehouse ID
     * @param name the warehouse name
     * @param shippingCost the shipping cost
     * @return a WarehouseInfo for a UK warehouse
     */
    public static WarehouseInfo uk(String warehouseId, String name, BigDecimal shippingCost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a warehouse in the EU.
     *
     * @param warehouseId the warehouse ID
     * @param name the warehouse name
     * @param shippingCost the shipping cost
     * @return a WarehouseInfo for an EU warehouse
     */
    public static WarehouseInfo eu(String warehouseId, String name, BigDecimal shippingCost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a warehouse for international shipping.
     *
     * @param warehouseId the warehouse ID
     * @param name the warehouse name
     * @param location the location
     * @param shippingCost the shipping cost
     * @return a WarehouseInfo for an international warehouse
     */
    public static WarehouseInfo international(String warehouseId, String name, String location, BigDecimal shippingCost) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
