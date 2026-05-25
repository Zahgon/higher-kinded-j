// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Selective;
import org.higherkindedj.hkt.Semigroups;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.hkt.validated.ValidatedKind;
import org.higherkindedj.hkt.validated.ValidatedSelective;
import org.higherkindedj.optics.Traversal;
import org.higherkindedj.optics.annotations.GenerateLenses;
import org.higherkindedj.optics.annotations.GeneratePrisms;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating composition of optics (Lens, Prism, and Traversal) to perform a
 * deep validation on a nested data structure.
 */
public class ValidatedTraversalExample {

    // --- Data Model ---
    @GenerateLenses
    public record Permission(String name) {
    }

    @GeneratePrisms
    public sealed interface Principal {
    }

    @GenerateLenses
    @GenerateTraversals
    public record VTUser(String username, List<Permission> permissions) implements Principal {
    }

    public record Guest() implements Principal {
    }

    @GenerateLenses
    public record Form(int formId, Principal principal) {
    }

    // --- Validation Logic ---
    private static final Set<String> VALID_PERMISSIONS = Set.of("PERM_READ", "PERM_WRITE", "PERM_DELETE");

    public static Kind<ValidatedKind.Witness<String>, String> validatePermissionName(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Reusable Optic Compositions ---
    public static final Traversal<Form, String> FORM_TO_PERMISSION_NAMES = FormLenses.principal().asTraversal().andThen(PrincipalPrisms.vTUser().asTraversal()).andThen(VTUserTraversals.permissions()).andThen(PermissionLenses.name().asTraversal());

    // --- Helper Methods ---
    private static Applicative<ValidatedKind.Witness<String>> getValidatedApplicative() {
        return Instances.validated(Semigroups.string("; "));
    }

    public static Validated<String, Form> validateFormPermissions(Form form) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates using Selective for smarter validation. Skip expensive validations if cheap checks
     * fail.
     */
    private static void selectiveValidationExample() {
        System.out.println("--- Scenario 7: Selective Validation (Smart Short-Circuiting) ---");
        var userWithInvalidPerms = new VTUser("eve", List.of(// Empty - cheap check fails
        new Permission(""), // Valid
        new Permission("PERM_READ"), // Invalid - would need expensive check
        new Permission("INVALID_PERM")));
        var form = new Form(7, userWithInvalidPerms);
        System.out.println("Input: " + form);
        // Two-stage validation: cheap check first, expensive check only if needed
        Predicate<String> notEmpty = name -> !name.isEmpty();
        Function<String, Kind<ValidatedKind.Witness<String>, String>> expensiveValidation = name -> {
            System.out.println("  Running EXPENSIVE validation for: " + name);
            return validatePermissionName(name);
        };
        Selective<ValidatedKind.Witness<String>> selective = ValidatedSelective.instance(Semigroups.string("; "));
        Kind<ValidatedKind.Witness<String>, Form> selectiveResult = FORM_TO_PERMISSION_NAMES.modifyWhen(// Cheap check
        notEmpty, // Expensive check (only if cheap passes)
        expensiveValidation, form, selective);
        System.out.println("Result: " + VALIDATED.narrow(selectiveResult));
        System.out.println("Note: Expensive validation only ran for non-empty permissions\n");
    }
}
