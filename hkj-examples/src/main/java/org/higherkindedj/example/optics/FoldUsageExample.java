// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import java.util.*;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.Monoids;
import org.higherkindedj.optics.Fold;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.Traversal;
import org.higherkindedj.optics.annotations.GenerateFolds;
import org.higherkindedj.optics.annotations.GenerateLenses;
import org.higherkindedj.optics.util.Traversals;

/**
 * Comprehensive example demonstrating Fold optics for read-only querying and data extraction.
 *
 * <p>This example showcases:
 *
 * <ul>
 *   <li>Basic query operations: getAll, preview, find, exists, all, isEmpty, length
 *   <li>Composing folds for deep queries across nested structures
 *   <li>Monoid-based aggregation for calculating sums, checking conditions, etc.
 *   <li>Real-world analytics on e-commerce order data
 * </ul>
 *
 * <p>Fold is a read-only optic designed specifically for querying without modification, making code
 * intent clear and preventing accidental mutations.
 */
public class FoldUsageExample {

    @GenerateLenses
    @GenerateFolds
    public record ProductItem(String name, double price, String category, boolean inStock) {
    }

    @GenerateLenses
    @GenerateFolds
    public record Order(String orderId, List<ProductItem> items, String customerName) {
    }

    @GenerateLenses
    @GenerateFolds
    public record OrderHistory(List<Order> orders) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
