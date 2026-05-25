// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.market.model.value;

/**
 * A trade volume value.
 *
 * @param value the number of units traded
 */
public record Volume(long value) {

    public Volume {
        if (value < 0) {
            throw new IllegalArgumentException("volume must not be negative: " + value);
        }
    }

    public static Volume of(long v) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Volume add(Volume other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
