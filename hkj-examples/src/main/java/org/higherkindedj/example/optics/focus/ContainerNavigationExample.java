// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.focus;

import java.util.Optional;
import org.higherkindedj.hkt.either.Either;
import org.higherkindedj.hkt.trymonad.Try;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.annotations.GenerateFocus;
import org.higherkindedj.optics.focus.AffinePath;
import org.higherkindedj.optics.focus.FocusPath;
import org.higherkindedj.optics.util.Affines;

/**
 * Demonstrates navigating into custom container types with the Focus DSL.
 *
 * <p>Shows how to use {@code some(Affine)} to navigate into container types like {@link Either},
 * {@link Try}, and {@link Validated}. These types each hold zero or one value from the perspective
 * of the "success" channel, making {@link org.higherkindedj.optics.Affine} the appropriate optic
 * for navigating into them.
 *
 * <h2>Key Concepts</h2>
 *
 * <ul>
 *   <li>{@link Affines#eitherRight()} - focuses on the Right value of an Either
 *   <li>{@link Affines#trySuccess()} - focuses on the Success value of a Try
 *   <li>{@link Affines#validatedValid()} - focuses on the Valid value of a Validated
 *   <li>{@code some(Affine)} composition - widens a FocusPath into an AffinePath
 *   <li>Composing through multiple container types via chained {@code .via()} calls
 *   <li>Comparing manual composition with {@code @GenerateFocus} SPI auto-widening
 * </ul>
 */
public class ContainerNavigationExample {

    // ============= Domain Models =============
    /**
     * A configuration entry with a name and a port that may be an error message or a valid port.
     */
    record Config(String name, Either<String, Integer> port) {
    }

    /**
     * A service result containing the service name and a response that may have failed.
     */
    record ServiceResult(String service, Try<String> response) {
    }

    /**
     * A form field with a label and a validated answer that may hold an error or a valid integer.
     */
    record FormField(String label, Validated<String, Integer> answer) {
    }

    /**
     * A payment with an amount and currency.
     */
    record Payment(int amount, String currency) {
    }

    /**
     * An order with an identifier and a result that is either an error message or a payment.
     */
    record Order(String id, Either<String, Payment> result) {
    }

    // ============= @GenerateFocus Records (SPI auto-widening) =============
    /**
     * Same Config model but with {@code @GenerateFocus}.
     *
     * <p>The SPI {@code EitherGenerator} recognises {@code Either<String, Integer>} as a ZERO_OR_ONE
     * container, so {@code AutoConfigFocus.port()} automatically returns {@code
     * AffinePath<AutoConfig, Integer>} — no manual {@code some(Affine)} needed.
     */
    @GenerateFocus
    record AutoConfig(String name, Either<String, Integer> port) {
    }

    /**
     * Same ServiceResult model but with {@code @GenerateFocus}.
     *
     * <p>The SPI {@code TryGenerator} recognises {@code Try<String>} as ZERO_OR_ONE, so {@code
     * AutoServiceResultFocus.response()} returns {@code AffinePath<AutoServiceResult, String>}.
     */
    @GenerateFocus
    record AutoServiceResult(String service, Try<String> response) {
    }

    /**
     * Same FormField model but with {@code @GenerateFocus}.
     *
     * <p>The SPI {@code ValidatedGenerator} recognises {@code Validated<String, Integer>} as
     * ZERO_OR_ONE, so {@code AutoFormFieldFocus.answer()} returns {@code AffinePath<AutoFormField,
     * Integer>}.
     */
    @GenerateFocus
    record AutoFormField(String label, Validated<String, Integer> answer) {
    }

    // ============= Manual Lenses =============
    static final Lens<Config, Either<String, Integer>> CONFIG_PORT = Lens.of(Config::port, (c, p) -> new Config(c.name(), p));

    static final Lens<ServiceResult, Try<String>> RESULT_RESPONSE = Lens.of(ServiceResult::response, (r, resp) -> new ServiceResult(r.service(), resp));

    static final Lens<FormField, Validated<String, Integer>> FIELD_ANSWER = Lens.of(FormField::answer, (f, a) -> new FormField(f.label(), a));

    static final Lens<Order, Either<String, Payment>> ORDER_RESULT = Lens.of(Order::result, (o, r) -> new Order(o.id(), r));

    static final Lens<Payment, Integer> PAYMENT_AMOUNT = Lens.of(Payment::amount, (p, a) -> new Payment(a, p.currency()));

    static final Lens<Payment, String> PAYMENT_CURRENCY = Lens.of(Payment::currency, (p, c) -> new Payment(p.amount(), c));

    // ============= Examples =============
    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates navigating into an Either field using {@link Affines#eitherRight()}.
     *
     * <p>The {@code some(Affine)} call widens the FocusPath into an AffinePath, reflecting the fact
     * that the Right value may or may not be present.
     */
    static void eitherNavigationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates navigating into a Try field using {@link Affines#trySuccess()}.
     *
     * <p>When the Try holds a Failure, the AffinePath returns empty, leaving the structure unchanged
     * on modification.
     */
    static void tryNavigationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates navigating into a Validated field using {@link Affines#validatedValid()}.
     *
     * <p>Validated is commonly used for accumulating validation errors. The affine focuses only on
     * the Valid case.
     */
    static void validatedNavigationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates composing container-widened paths to navigate through nested structures.
     *
     * <p>An Order contains an Either that, when Right, holds a Payment record. By composing {@code
     * some(Affines.eitherRight())} with a Lens into Payment fields, we can navigate the entire path
     * in a single expression.
     */
    static void composedContainerPathExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Compares manual container navigation with {@code @GenerateFocus} SPI auto-widening.
     *
     * <p>The TraversableGenerator SPI allows the annotation processor to recognise container types
     * and automatically generate the correct path widening. This eliminates the boilerplate of
     * creating manual Lenses and calling {@code some(Affine)}.
     *
     * <p>Manual approach (above examples):
     *
     * <pre>{@code
     * Lens<Config, Either<String, Integer>> lens = Lens.of(Config::port, ...);
     * AffinePath<Config, Integer> path = FocusPath.of(lens).some(Affines.eitherRight());
     * }</pre>
     *
     * <p>Generated approach (SPI auto-widening):
     *
     * <pre>{@code
     * // @GenerateFocus on the record is all you need:
     * AffinePath<AutoConfig, Integer> path = AutoConfigFocus.port();
     * }</pre>
     */
    static void autoWideningComparisonExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
