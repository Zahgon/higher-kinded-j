// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import java.util.List;
import java.util.Optional;
import org.higherkindedj.optics.Affine;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.Prism;
import org.higherkindedj.optics.util.Affines;
import org.higherkindedj.optics.util.Prisms;

/**
 * A runnable example demonstrating how to use Affines for working with optional fields and
 * zero-or-one element focus patterns in immutable data structures.
 *
 * <p>Affines sit between Lenses and Traversals in the optic hierarchy: they focus on exactly zero
 * or one element, making them ideal for {@code Optional<T>} fields and nullable properties.
 */
public class AffineUsageExample {

    // 1. Define a nested, immutable data model with optional fields.
    public record UserProfile(String username, Optional<ContactInfo> contact) {
    }

    public record ContactInfo(String email, Optional<String> phone) {
    }

    public record AppConfig(String appName, Optional<DatabaseConfig> database) {
    }

    public record DatabaseConfig(String host, int port, Optional<PoolConfig> pool) {
    }

    public record PoolConfig(int minSize, int maxSize) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
