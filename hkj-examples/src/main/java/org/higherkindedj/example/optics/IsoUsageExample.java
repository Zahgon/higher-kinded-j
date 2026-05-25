// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import org.higherkindedj.example.optics.iso.CircleLenses;
import org.higherkindedj.hkt.tuple.Tuple;
import org.higherkindedj.hkt.tuple.Tuple2;
import org.higherkindedj.hkt.tuple.Tuple2Lenses;
import org.higherkindedj.optics.Iso;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.annotations.GenerateIsos;
import org.higherkindedj.optics.annotations.GenerateLenses;

/**
 * A runnable example demonstrating how to use an Iso (Isomorphism) to perform lossless, two-way
 * conversions between equivalent types.
 */
public class IsoUsageExample {

    @GenerateLenses(targetPackage = "org.higherkindedj.example.optics.iso")
    public record Point(int x, int y) {
    }

    @GenerateLenses(targetPackage = "org.higherkindedj.example.optics.iso")
    public record Circle(Point centre, int radius) {
    }

    public static class Converters {

        @GenerateIsos
        public static Iso<Point, Tuple2<Integer, Integer>> pointToTuple() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // Additional useful Isos
        public static final Iso<Point, String> POINT_STRING = Iso.of(point -> point.x() + "," + point.y(), str -> {
            String[] parts = str.split(",");
            return new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        });
    }

    // Test helper
    private static <A, B> void testRoundTrip(Iso<A, B> iso, A original, String description) {
        B converted = iso.get(original);
        A roundTrip = iso.reverse().get(converted);
        System.out.println(description + ":");
        System.out.println("  Original:  " + original);
        System.out.println("  Converted: " + converted);
        System.out.println("  Round-trip: " + roundTrip);
        System.out.println("  Success: " + original.equals(roundTrip));
        System.out.println();
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
