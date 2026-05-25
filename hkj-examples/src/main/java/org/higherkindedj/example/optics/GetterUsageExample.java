// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import java.util.*;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.optics.Fold;
import org.higherkindedj.optics.Getter;
import org.higherkindedj.optics.annotations.GenerateGetters;

/**
 * Comprehensive example demonstrating Getter optics for read-only value extraction.
 *
 * <p>This example showcases:
 *
 * <ul>
 *   <li>Creating Getters from functions for computed/derived values
 *   <li>Composing Getters for deep access into nested structures
 *   <li>Integrating Getters with Folds for complex queries
 *   <li>Using Getters as a Fold to leverage query operations (exists, all, find, etc.)
 *   <li>Real-world use cases in data transformation and reporting
 * </ul>
 *
 * <p>Getter is ideal when you need to:
 *
 * <ul>
 *   <li>Extract derived/computed values without storing them
 *   <li>Create composable read-only accessors
 *   <li>Build data pipelines for reporting and analytics
 * </ul>
 */
public class GetterUsageExample {

    @GenerateGetters
    public record Person(String firstName, String lastName, int age, Address address) {
    }

    @GenerateGetters
    public record Address(String street, String city, String zipCode, String country) {
    }

    @GenerateGetters
    public record Company(String name, Person ceo, List<Person> employees, Address headquarters) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Monoid<Integer> sumMonoid() {
        return new Monoid<>() {

            @Override
            public Integer empty() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public Integer combine(Integer a, Integer b) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }
}
