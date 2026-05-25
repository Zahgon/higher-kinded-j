// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.indexed.Pair;

/**
 * A runnable example demonstrating how to use {@link Lens#paired} to safely update coupled fields
 * that participate in invariants.
 *
 * <p><b>The Problem:</b> When a record has an invariant that spans multiple fields (e.g., {@code lo
 * <= hi} in a Range), sequential lens updates can create invalid intermediate states that violate
 * the invariant.
 *
 * <p><b>The Solution:</b> Use {@code Lens.paired} to combine two lenses into a single lens that
 * focuses on a tuple of both values. This allows atomic updates where both fields are set
 * simultaneously via a single constructor call, bypassing invalid intermediate states.
 */
public class PairedLensExample {

    /**
     * A range with an invariant: lo must be less than or equal to hi.
     *
     * <p>This is a common pattern where two fields are coupled by a constraint.
     */
    public record Range(int lo, int hi) {

        public Range {
            if (lo > hi) {
                throw new IllegalArgumentException("Range invariant violated: lo (" + lo + ") must be <= hi (" + hi + ")");
            }
        }

        /**
         * Convenience method to display the range.
         */
        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Individual lens for the 'lo' field.
     */
    static final Lens<Range, Integer> loLens = Lens.of(Range::lo, (r, lo) -> new Range(lo, r.hi()));

    /**
     * Individual lens for the 'hi' field.
     */
    static final Lens<Range, Integer> hiLens = Lens.of(Range::hi, (r, hi) -> new Range(r.lo(), hi));

    /**
     * Paired lens that focuses on both bounds as a pair. Uses the Range constructor directly for
     * atomic reconstruction.
     */
    static final Lens<Range, Pair<Integer, Integer>> boundsLens = Lens.paired(loLens, hiLens, Range::new);

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
