// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.effect;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.higherkindedj.hkt.effect.IOPath;
import org.higherkindedj.hkt.effect.MaybePath;
import org.higherkindedj.hkt.effect.Path;

/**
 * Examples demonstrating sequential composition with the Effect Path API.
 *
 * <p>This example shows:
 *
 * <ul>
 *   <li>Chaining dependent computations with {@code via} and {@code flatMap}
 *   <li>Using {@code then} for sequencing with ignored results
 *   <li>Building complex pipelines
 * </ul>
 *
 * <p>Run with: {@code ./gradlew :hkj-examples:run
 * -PmainClass=org.higherkindedj.example.effect.ChainedComputationsExample}
 */
public class ChainedComputationsExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void basicChaining() {
        System.out.println("--- Basic Chaining with via ---");
        // via chains computations where the next step depends on the previous result
        MaybePath<String> result = Path.just(5).via(// 10
        n -> n > 0 ? Path.just(n * 2) : Path.nothing()).via(// "Result: 10"
        n -> Path.just("Result: " + n));
        // Result: 10
        System.out.println("Chained result: " + result.getOrElse("no value"));
        // via with Nothing short-circuits
        MaybePath<String> shortCircuited = Path.just(-5).via(// Nothing
        n -> n > 0 ? Path.just(n * 2) : Path.nothing()).via(// Never executed
        n -> Path.just("Result: " + n));
        System.out.println(// computation
        "Short-circuited: " + shortCircuited.getOrElse("computation stopped"));
        // stopped
        System.out.println();
    }

    private static void dependentChaining() {
        System.out.println("--- Dependent Computations ---");
        // Simulating a user lookup followed by permission check
        record User(String id, String name, String role) {
        }
        // User database (simulated)
        Function<String, MaybePath<User>> findUser = id -> switch(id) {
            case "1" ->
                Path.just(new User("1", "Alice", "admin"));
            case "2" ->
                Path.just(new User("2", "Bob", "user"));
            default ->
                Path.nothing();
        };
        // Permission check depends on user
        Function<User, MaybePath<String>> checkPermission = user -> user.role().equals("admin") ? Path.just("Access granted to " + user.name()) : Path.nothing();
        // Chain: find user -> check permission
        MaybePath<String> accessResult = findUser.apply("1").via(checkPermission);
        // Access
        System.out.println("Admin access: " + accessResult.getOrElse("Access denied"));
        // granted to Alice
        MaybePath<String> userAccessResult = findUser.apply("2").via(checkPermission);
        System.out.println(// Access denied
        "User access: " + userAccessResult.getOrElse("Access denied"));
        MaybePath<String> unknownUserResult = findUser.apply("999").via(checkPermission);
        System.out.println(// User not found
        "Unknown user: " + unknownUserResult.getOrElse("User not found"));
        System.out.println();
    }

    private static void usingThen() {
        System.out.println("--- Using then() for Sequencing ---");
        // then() executes effects in sequence, discarding the first result
        // Useful when you want side effects but don't need the value
        AtomicInteger step = new AtomicInteger();
        MaybePath<String> sequence = Path.just("start").peek(s -> System.out.println("Step 1: " + s)).then(() -> {
            step.incrementAndGet();
            return Path.just("middle");
        }).peek(s -> System.out.println("Step 2: " + s)).then(() -> {
            step.incrementAndGet();
            return Path.just("end");
        }).peek(s -> System.out.println("Step 3: " + s));
        System.out.println("Final value: " + sequence.getOrElse("none"));
        System.out.println("Steps executed: " + step.get());
        System.out.println();
    }

    private static void ioChaining() {
        System.out.println("--- IO Chaining (Deferred Execution) ---");
        // IOPath chains are lazy - nothing happens until unsafeRun()
        IOPath<String> deferredChain = Path.io(() -> "Hello").map(String::toUpperCase).via(s -> Path.io(() -> s + " WORLD")).map(s -> s + "!");
        System.out.println("IO chain created (nothing executed yet)");
        // HELLO WORLD!
        System.out.println("Executing IO chain: " + deferredChain.unsafeRun());
        // Demonstrating lazy evaluation
        System.out.println("\n--- Lazy Evaluation Demo ---");
        AtomicInteger counter = new AtomicInteger();
        IOPath<Integer> lazyChain = Path.io(() -> {
            System.out.println("Computing first value...");
            return counter.incrementAndGet();
        }).via(n -> Path.io(() -> {
            System.out.println("Computing second value based on: " + n);
            return n * 10;
        }));
        // 0
        System.out.println("Chain created. Counter is: " + counter.get());
        System.out.println("Running chain...");
        // 10
        System.out.println("Result: " + lazyChain.unsafeRun());
        // 1
        System.out.println("Counter after run: " + counter.get());
        System.out.println();
    }
}
