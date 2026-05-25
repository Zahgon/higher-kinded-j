// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.focus;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import java.util.List;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.maybe.Maybe;
import org.higherkindedj.hkt.maybe.MaybeKind;
import org.higherkindedj.hkt.maybe.MaybeKindHelper;
import org.higherkindedj.optics.annotations.GenerateFocus;
import org.higherkindedj.optics.annotations.GenerateLenses;
import org.higherkindedj.optics.focus.FocusPath;
import org.higherkindedj.optics.focus.TraversalPath;

/**
 * Demonstrates validation pipelines using the Focus DSL with effectful operations.
 *
 * <p>This example shows how to use {@code modifyF()} for validation that can fail, and {@code
 * foldMap()} for aggregating values with monoids.
 *
 * <h2>Key Concepts</h2>
 *
 * <ul>
 *   <li>Using {@code modifyF()} with Maybe for validation that may fail
 *   <li>Short-circuit validation (fail-fast)
 *   <li>Using {@code foldMap()} with custom Monoids for aggregation
 *   <li>Combining validation with transformation
 *   <li>Using generated Focus classes for type-safe navigation
 * </ul>
 */
public class ValidationPipelineExample {

    // ============= Domain Model =============
    /**
     * Configuration with various fields that need validation.
     */
    @GenerateLenses
    @GenerateFocus
    public record Config(String apiKey, String databaseUrl, int timeout, int maxConnections) {
    }

    /**
     * User profile with fields requiring validation.
     */
    @GenerateLenses
    @GenerateFocus
    public record UserProfile(String username, String email, int age) {
    }

    /**
     * Order with line items for aggregation example.
     */
    @GenerateLenses
    @GenerateFocus
    public record Order(String orderId, List<LineItem> items) {
    }

    /**
     * Line item in an order.
     */
    @GenerateLenses
    @GenerateFocus
    public record LineItem(String productId, int quantity, double unitPrice) {

        double total() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // ============= Examples =============
    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates basic validation using modifyF with Maybe.
     */
    static void basicValidationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates chaining multiple validations.
     */
    static void chainedValidationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void validateProfile(UserProfile profile, FocusPath<UserProfile, String> usernamePath, FocusPath<UserProfile, String> emailPath, FocusPath<UserProfile, Integer> agePath, Function<String, Kind<MaybeKind.Witness, String>> validateUsername, Function<String, Kind<MaybeKind.Witness, String>> validateEmail, Function<Integer, Kind<MaybeKind.Witness, Integer>> validateAge) {
        // Chain validations: username -> email -> age
        Kind<MaybeKind.Witness, UserProfile> step1 = usernamePath.modifyF(validateUsername, profile, Instances.monadError(maybe()));
        Maybe<UserProfile> afterUsername = MaybeKindHelper.MAYBE.narrow(step1);
        if (afterUsername.isNothing()) {
            System.out.println("  Failed at: username validation");
            return;
        }
        Kind<MaybeKind.Witness, UserProfile> step2 = emailPath.modifyF(validateEmail, afterUsername.get(), Instances.monadError(maybe()));
        Maybe<UserProfile> afterEmail = MaybeKindHelper.MAYBE.narrow(step2);
        if (afterEmail.isNothing()) {
            System.out.println("  Failed at: email validation");
            return;
        }
        Kind<MaybeKind.Witness, UserProfile> step3 = agePath.modifyF(validateAge, afterEmail.get(), Instances.monadError(maybe()));
        Maybe<UserProfile> result = MaybeKindHelper.MAYBE.narrow(step3);
        if (result.isJust()) {
            System.out.println("  All validations passed!");
            System.out.println("  Final profile: " + result.get());
        } else {
            System.out.println("  Failed at: age validation");
        }
    }

    /**
     * Demonstrates aggregation using foldMap with various Monoids.
     */
    static void aggregationWithFoldMapExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates conditional modification with modifyWhen.
     */
    static void conditionalModificationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void printOrderItems(Order order) {
        for (LineItem item : order.items()) {
            System.out.printf("  %s: qty=%d, price=$%.2f, total=$%.2f%n", item.productId(), item.quantity(), item.unitPrice(), item.total());
        }
    }
}
