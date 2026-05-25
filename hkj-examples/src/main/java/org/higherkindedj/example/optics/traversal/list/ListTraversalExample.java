// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.list;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import java.util.List;
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
 * java.util.List}.
 */
public class ListTraversalExample {

    /**
     * An immutable Project record. A project has a name and a list of team members. We use
     * {@code @GenerateTraversals} to generate optics for this record.
     */
    @GenerateTraversals
    public record Project(String name, List<String> teamMembers) {
    }

    // A simple "database" of valid users.
    private static final Set<String> VALID_USERS = Set.of("Alice", "Bob", "Charlie");

    /**
     * An "effectful" function that looks up a user by name. It returns a {@link Validated} type to
     * make success and failure explicit.
     *
     * @param username The name to look up.
     * @return A {@code Kind<Validated.Witness<String>, String>} which is either Valid(username) or
     *     Invalid("Error...").
     */
    public static Kind<ValidatedKind.Witness<String>, String> lookupUser(String username) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
