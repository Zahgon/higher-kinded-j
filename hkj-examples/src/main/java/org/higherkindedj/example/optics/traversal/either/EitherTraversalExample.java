// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.either;

import static org.higherkindedj.hkt.id.IdKindHelper.ID;
import static org.higherkindedj.hkt.instances.Witnesses.*;
import org.higherkindedj.hkt.either.Either;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating traversing the 'Right' side of an {@link Either}.
 */
public class EitherTraversalExample {

    /**
     * A record representing a computation that can either succeed (Right) or fail (Left).
     * {@code @GenerateTraversals} generates optics to focus on the result field.
     */
    @GenerateTraversals
    public record Computation(String name, Either<String, Integer> result) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
