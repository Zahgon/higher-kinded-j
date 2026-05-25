// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.effect;

import java.util.List;
import java.util.Optional;
import org.higherkindedj.hkt.Semigroup;
import org.higherkindedj.hkt.Semigroups;
import org.higherkindedj.hkt.effect.EitherPath;
import org.higherkindedj.hkt.effect.IdPath;
import org.higherkindedj.hkt.effect.MaybePath;
import org.higherkindedj.hkt.effect.OptionalPath;
import org.higherkindedj.hkt.effect.Path;
import org.higherkindedj.hkt.effect.TryPath;
import org.higherkindedj.hkt.effect.ValidationPath;

/**
 * Examples demonstrating conversions between different Path types.
 *
 * <p>This example shows:
 *
 * <ul>
 *   <li>Converting between MaybePath, EitherPath, TryPath, ValidationPath, OptionalPath, and IdPath
 *   <li>Error transformation during conversion
 *   <li>When to use which conversion
 *   <li>Information loss in certain conversions
 * </ul>
 *
 * <p>Run with: {@code ./gradlew :hkj-examples:run
 * -PmainClass=org.higherkindedj.example.effect.CrossPathConversionsExample}
 */
public class CrossPathConversionsExample {

    private static final Semigroup<List<String>> LIST_SEMIGROUP = Semigroups.list();

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== MaybePath Conversions =====
    private static void maybePathConversions() {
        System.out.println("--- MaybePath Conversions ---");
        // From Just
        MaybePath<Integer> justPath = Path.just(42);
        // To EitherPath - provide error for Nothing case
        EitherPath<String, Integer> eitherFromJust = justPath.toEitherPath("No value");
        // Right[42]
        System.out.println("Just -> Either: " + eitherFromJust.run());
        // To OptionalPath
        OptionalPath<Integer> optionalFromJust = justPath.toOptionalPath();
        // Optional[42]
        System.out.println("Just -> Optional: " + optionalFromJust.run());
        // To ValidationPath
        ValidationPath<List<String>, Integer> validationFromJust = justPath.toValidationPath(List.of("No value"), LIST_SEMIGROUP);
        // Valid[42]
        System.out.println("Just -> Validation: " + validationFromJust.run());
        // From Nothing
        MaybePath<Integer> nothingPath = Path.nothing();
        EitherPath<String, Integer> eitherFromNothing = nothingPath.toEitherPath("Value was absent");
        // Left[Value was absent]
        System.out.println("Nothing -> Either: " + eitherFromNothing.run());
        System.out.println();
    }

    // ===== EitherPath Conversions =====
    private static void eitherPathConversions() {
        System.out.println("--- EitherPath Conversions ---");
        // From Right
        EitherPath<String, Integer> rightPath = Path.right(42);
        // To MaybePath - error information is LOST
        MaybePath<Integer> maybeFromRight = rightPath.toMaybePath();
        // Just[42]
        System.out.println("Right -> Maybe: " + maybeFromRight.run());
        // To TryPath
        TryPath<Integer> tryFromRight = rightPath.toTryPath(RuntimeException::new);
        // Success[42]
        System.out.println("Right -> Try: " + tryFromRight.run());
        // To ValidationPath - preserves error type
        ValidationPath<String, Integer> validationFromRight = rightPath.toValidationPath(Semigroups.first());
        // Valid[42]
        System.out.println("Right -> Validation: " + validationFromRight.run());
        // To OptionalPath - error information is LOST
        OptionalPath<Integer> optionalFromRight = rightPath.toOptionalPath();
        // Optional[42]
        System.out.println("Right -> Optional: " + optionalFromRight.run());
        // From Left
        EitherPath<String, Integer> leftPath = Path.left("Something went wrong");
        MaybePath<Integer> maybeFromLeft = leftPath.toMaybePath();
        // Nothing
        System.out.println("Left -> Maybe (loses error): " + maybeFromLeft.run());
        System.out.println();
    }

    // ===== TryPath Conversions =====
    private static void tryPathConversions() {
        System.out.println("--- TryPath Conversions ---");
        // From Success
        TryPath<Integer> successPath = Path.success(42);
        // To MaybePath
        MaybePath<Integer> maybeFromSuccess = successPath.toMaybePath();
        // Just[42]
        System.out.println("Success -> Maybe: " + maybeFromSuccess.run());
        // To EitherPath - transform Throwable to custom error type
        EitherPath<String, Integer> eitherFromSuccess = successPath.toEitherPath(Throwable::getMessage);
        // Right[42]
        System.out.println("Success -> Either: " + eitherFromSuccess.run());
        // To OptionalPath
        OptionalPath<Integer> optionalFromSuccess = successPath.toOptionalPath();
        // Optional[42]
        System.out.println("Success -> Optional: " + optionalFromSuccess.run());
        // From Failure
        TryPath<Integer> failurePath = Path.failure(new RuntimeException("Database error"));
        MaybePath<Integer> maybeFromFailure = failurePath.toMaybePath();
        // Nothing
        System.out.println("Failure -> Maybe: " + maybeFromFailure.run());
        EitherPath<String, Integer> eitherFromFailure = failurePath.toEitherPath(Throwable::getMessage);
        // Left[Database error]
        System.out.println("Failure -> Either: " + eitherFromFailure.run());
        System.out.println();
    }

    // ===== ValidationPath Conversions =====
    private static void validationPathConversions() {
        System.out.println("--- ValidationPath Conversions ---");
        // From Valid
        ValidationPath<List<String>, Integer> validPath = Path.valid(42, LIST_SEMIGROUP);
        // To EitherPath
        EitherPath<List<String>, Integer> eitherFromValid = validPath.toEitherPath();
        // Right[42]
        System.out.println("Valid -> Either: " + eitherFromValid.run());
        // To MaybePath - error information is LOST
        MaybePath<Integer> maybeFromValid = validPath.toMaybePath();
        // Just[42]
        System.out.println("Valid -> Maybe: " + maybeFromValid.run());
        // To TryPath - need to convert error to Throwable
        TryPath<Integer> tryFromValid = validPath.toTryPath(errors -> new RuntimeException(String.join(", ", errors)));
        // Success[42]
        System.out.println("Valid -> Try: " + tryFromValid.run());
        // To OptionalPath
        OptionalPath<Integer> optionalFromValid = validPath.toOptionalPath();
        // Optional[42]
        System.out.println("Valid -> Optional: " + optionalFromValid.run());
        // From Invalid
        ValidationPath<List<String>, Integer> invalidPath = Path.invalid(List.of("Error 1", "Error 2"), LIST_SEMIGROUP);
        EitherPath<List<String>, Integer> eitherFromInvalid = invalidPath.toEitherPath();
        // Left[[Error 1, Error 2]]
        System.out.println("Invalid -> Either: " + eitherFromInvalid.run());
        System.out.println();
    }

    // ===== OptionalPath Conversions =====
    private static void optionalPathConversions() {
        System.out.println("--- OptionalPath Conversions ---");
        // From Present
        OptionalPath<Integer> presentPath = Path.present(42);
        // To MaybePath
        MaybePath<Integer> maybeFromPresent = presentPath.toMaybePath();
        // Just[42]
        System.out.println("Present -> Maybe: " + maybeFromPresent.run());
        // To EitherPath - provide error for empty case
        EitherPath<String, Integer> eitherFromPresent = presentPath.toEitherPath("No value");
        // Right[42]
        System.out.println("Present -> Either: " + eitherFromPresent.run());
        // To ValidationPath
        ValidationPath<List<String>, Integer> validationFromPresent = presentPath.toValidationPath(List.of("Required value missing"), LIST_SEMIGROUP);
        // Valid[42]
        System.out.println("Present -> Validation: " + validationFromPresent.run());
        // From Absent
        OptionalPath<Integer> absentPath = Path.absent();
        MaybePath<Integer> maybeFromAbsent = absentPath.toMaybePath();
        // Nothing
        System.out.println("Absent -> Maybe: " + maybeFromAbsent.run());
        EitherPath<String, Integer> eitherFromAbsent = absentPath.toEitherPath("Value is required");
        // Left[Value is required]
        System.out.println("Absent -> Either: " + eitherFromAbsent.run());
        System.out.println();
    }

    // ===== IdPath Conversions =====
    private static void idPathConversions() {
        System.out.println("--- IdPath Conversions ---");
        // IdPath always has a value
        IdPath<Integer> idPath = Path.id(42);
        // To MaybePath - always Just
        MaybePath<Integer> maybeFromId = idPath.toMaybePath();
        // Just[42]
        System.out.println("Id -> Maybe: " + maybeFromId.run());
        // To EitherPath - always Right
        EitherPath<String, Integer> eitherFromId = idPath.toEitherPath();
        // Right[42]
        System.out.println("Id -> Either: " + eitherFromId.run());
        System.out.println();
    }

    // ===== Conversion Chains =====
    private static void conversionChains() {
        System.out.println("--- Conversion Chains ---");
        // Start with Optional from Java stdlib
        Optional<Integer> javaOptional = Optional.of(42);
        // OptionalPath -> EitherPath -> ValidationPath -> TryPath
        String result = // OptionalPath
        Path.optional(javaOptional).toEitherPath(// EitherPath
        "No value").map(// Still EitherPath
        x -> x * 2).toValidationPath(// ValidationPath
        Semigroups.first()).map(// Still ValidationPath
        x -> x + 10).toTryPath(// TryPath
        RuntimeException::new).run().fold(// Success case
        n -> "Final result: " + n, // Error case
        Throwable::getMessage);
        // Final result: 94
        System.out.println("Conversion chain: " + result);
        // Chain starting from empty Optional
        Optional<Integer> emptyOptional = Optional.empty();
        String emptyResult = Path.optional(emptyOptional).toEitherPath("Value was required").toValidationPath(Semigroups.first()).toTryPath(RuntimeException::new).run().fold(n -> "Success: " + n, Throwable::getMessage);
        // Value was required
        System.out.println("Empty chain: " + emptyResult);
        System.out.println();
    }
}
