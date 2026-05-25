// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.array;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.validated.ValidatedKindHelper.VALIDATED;
import java.util.Arrays;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Semigroup;
import org.higherkindedj.hkt.Semigroups;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.hkt.validated.ValidatedKind;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating how to use a generated Traversal for a field of type Array.
 */
public class ArrayTraversalExample {

    /**
     * An immutable Survey record containing an array of answers. {@code @GenerateTraversals} will
     * generate a {@code SurveyTraversals} class.
     */
    @GenerateTraversals
    public record Survey(String id, Integer[] answers) {
    }

    /**
     * An "effectful" function to validate a single survey answer. It must be between 1 and 5.
     */
    public static Kind<ValidatedKind.Witness<String>, Integer> validateAnswer(Integer answer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
