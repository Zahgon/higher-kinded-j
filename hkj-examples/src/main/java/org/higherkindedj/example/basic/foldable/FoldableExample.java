// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.foldable;

import static org.higherkindedj.hkt.list.ListKindHelper.LIST;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.Monoids;
import org.higherkindedj.hkt.list.ListKind;
import org.higherkindedj.hkt.list.ListTraverse;

/**
 * An example demonstrating the power of the {@link org.higherkindedj.hkt.Foldable} typeclass and
 * the {@link Monoid} structure.
 *
 * <p>A Monoid allows us to combine elements in a collection and provides an "empty" or "identity"
 * element, which is crucial for handling empty collections gracefully. This example showcases a
 * common functional pattern: {@code foldMap}.
 *
 * <p><b>foldMap:</b> This operation, provided by the {@code Foldable} typeclass, maps each element
 * of a collection to a Monoidal type and then combines all the results using the Monoid's {@code
 * combine} operation. It's incredibly powerful because by simply changing the Monoid, we can get
 * completely different aggregations from the same data.
 */
public class FoldableExample {

    // We use ListTraverse as our Foldable instance for List.
    private static final ListTraverse listFoldable = ListTraverse.INSTANCE;

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates the {@code combineN} method for repeated application of a value.
     *
     * <p>{@code combineN(value, n)} combines a value with itself {@code n} times using the monoid's
     * operation. This is useful for scenarios like compound interest calculations, text formatting,
     * and other patterns requiring repeated application.
     */
    private static void demonstrateCombineN() {
        System.out.println("\n=== Using combineN for Repeated Application ===");
        // Calculate compound interest: initial * (1.05)^10
        Monoid<Double> growth = Monoids.doubleMultiplication();
        // 5% annual growth
        Double rate = 1.05;
        Double compoundFactor = growth.combineN(rate, 10);
        Double initialInvestment = 1000.0;
        Double finalValue = initialInvestment * compoundFactor;
        System.out.println("Initial investment: $" + initialInvestment);
        System.out.println("After 10 years at 5%: $" + String.format("%.2f", finalValue));
        // Build repeated string pattern
        Monoid<String> stringConcat = Monoids.string();
        String separator = "=";
        String border = stringConcat.combineN(separator, 50);
        System.out.println("\n" + border);
        System.out.println("Repeated border created with combineN");
        System.out.println(border);
    }
}
