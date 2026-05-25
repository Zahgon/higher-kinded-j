// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.annotations.GenerateLenses;

/**
 * A runnable example demonstrating how to compose Lenses and use generated helper methods to
 * perform deep, immutable updates on nested data structures.
 */
public class LensUsageExample {

    // 1. Define a nested, immutable data model.
    // The @GenerateLenses annotation will automatically create Lens implementations
    // and `with*` helper methods for each record component.
    @GenerateLenses
    public record Address(String street, String city) {
    }

    @GenerateLenses
    public record Company(String name, Address address) {
    }

    @GenerateLenses
    public record Employee(String name, Company company) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
