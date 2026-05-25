// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.maybe;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Semigroup;
import org.higherkindedj.hkt.Semigroups;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.maybe.Maybe;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.hkt.validated.ValidatedKind;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating the use of a generated Traversal for a field of type {@link
 * org.higherkindedj.hkt.maybe.Maybe}.
 */
public class MaybeTraversalExample {

    /**
     * A simple record representing a device owner.
     */
    public record Owner(String name) {
    }

    /**
     * An immutable Device record. A device must have a serial number, but it may not have an assigned
     * owner (represented by {@code Maybe<Owner>}). We use {@code @GenerateTraversals} to generate the
     * optics for this record.
     */
    @GenerateTraversals
    public record Device(String serialNumber, Maybe<Owner> owner) {
    }

    /**
     * An "effectful" function that checks the status of an owner. For this example, we'll say an
     * owner is "Active" if their name is not empty. The function returns a {@link Validated} type to
     * make success/failure explicit.
     *
     * @param owner The Owner to check.
     * @return A {@code Kind<Validated.Witness<String>, Owner>} which is either Valid(owner) or
     *     Invalid("Error...").
     */
    public static Kind<ValidatedKind.Witness<String>, Owner> checkOwnerStatus(Owner owner) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
