// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.optional;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import java.util.Optional;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Semigroup;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.hkt.validated.ValidatedKind;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating the use of a generated Traversal for a field of type {@link
 * java.util.Optional}.
 */
public class OptionalTraversalExample {

    /**
     * An immutable User record. A user must have an ID, but their email address is optional. We use
     * {@code @GenerateTraversals} to ask the annotation processor to create optics for us.
     */
    @GenerateTraversals
    public record User(int id, Optional<String> email) {
    }

    /**
     * An "effectful" function that validates an email address.
     *
     * <p>Instead of throwing an exception or returning null on failure, it returns a {@link
     * Validated} type. This makes the success and failure cases explicit and type-safe. The result is
     * "widened" to a {@code Kind} to be compatible with the Traverse interface.
     *
     * @param email The email string to validate.
     * @return A {@code Kind<Validated.Witness<String>, String>} which is either Valid(email) or
     *     Invalid("Error...").
     */
    public static Kind<ValidatedKind.Witness<String>, String> validateEmail(String email) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
