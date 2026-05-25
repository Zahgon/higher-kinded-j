// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import java.util.*;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.optional.OptionalKind;
import org.higherkindedj.hkt.optional.OptionalKindHelper;
import org.higherkindedj.optics.Setter;
import org.higherkindedj.optics.annotations.GenerateSetters;

/**
 * Comprehensive example demonstrating Setter optics for write-only modifications.
 *
 * <p>This example showcases:
 *
 * <ul>
 *   <li>Basic modify and set operations on fields
 *   <li>Composing Setters for deep modifications in nested structures
 *   <li>Working with collection Setters to modify all elements
 *   <li>Effectful modifications using Applicative contexts
 *   <li>Real-world use cases in data normalization and batch updates
 * </ul>
 *
 * <p>Setter is ideal when you need to:
 *
 * <ul>
 *   <li>Modify values without necessarily reading them first
 *   <li>Apply transformations to multiple elements (like in a Traversal)
 *   <li>Create write-only access patterns for encapsulation
 *   <li>Build data transformation pipelines
 * </ul>
 */
public class SetterUsageExample {

    @GenerateSetters
    public record User(String username, String email, int loginCount, UserSettings settings) {
    }

    @GenerateSetters
    public record UserSettings(String theme, boolean notifications, int fontSize, Map<String, String> preferences) {
    }

    @GenerateSetters
    public record Product(String name, double price, int stock, List<String> tags) {
    }

    @GenerateSetters
    public record Inventory(List<Product> products, String warehouseId) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
