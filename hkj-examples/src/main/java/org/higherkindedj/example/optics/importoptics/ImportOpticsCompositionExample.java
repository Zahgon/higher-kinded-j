// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.importoptics;

import java.time.LocalDate;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.annotations.GenerateLenses;

/**
 * A runnable example demonstrating how to compose imported optics with locally generated optics.
 *
 * <p>This example shows how optics generated via {@code @ImportOptics} can be seamlessly composed
 * with optics generated via {@code @GenerateLenses} on your own types.
 */
public class ImportOpticsCompositionExample {

    // Local domain records with generated lenses
    @GenerateLenses
    public record Event(String name, LocalDate date, String location) {
    }

    @GenerateLenses
    public record Calendar(String owner, Event nextEvent) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
