// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.set;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import java.util.Set;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Semigroup;
import org.higherkindedj.hkt.Semigroups;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.hkt.validated.ValidatedKind;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating the use of a generated Traversal for a field of type {@link
 * Set}.
 */
public class SetTraversalExample {

    /**
     * An immutable UserGroup record containing a set of user emails. {@code @GenerateTraversals}
     * generates optics for this record.
     */
    @GenerateTraversals
    public record UserGroup(String name, Set<String> memberEmails) {
    }

    /**
     * An "effectful" function that validates an email address format.
     */
    public static Kind<ValidatedKind.Witness<String>, String> validateEmail(String email) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
