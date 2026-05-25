// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.openrewrite;

import java.util.Set;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.AddImport;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.JavaTemplate;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.JavaType;
import org.openrewrite.java.tree.TypeTree;

/**
 * Recipe that adds {@code implements WitnessArity<TypeArity.Unary>} or {@code implements
 * WitnessArity<TypeArity.Binary>} to witness class definitions.
 *
 * <p>A witness class is identified by:
 *
 * <ul>
 *   <li>Being named "Witness" (inner class convention)
 *   <li>Implementing a Kind or Kind2 interface (directly or indirectly)
 * </ul>
 *
 * <p>The recipe detects the arity based on whether the class relates to Kind (unary) or Kind2
 * (binary).
 */
public class AddWitnessArityToWitnessClass extends Recipe {

    /**
     * Creates a new instance of this recipe.
     */
    public AddWitnessArityToWitnessClass() {
    }

    private static final String WITNESS_ARITY_FQN = "org.higherkindedj.hkt.WitnessArity";

    private static final String TYPE_ARITY_FQN = "org.higherkindedj.hkt.TypeArity";

    private static final String KIND_FQN = "org.higherkindedj.hkt.Kind";

    private static final String KIND2_FQN = "org.higherkindedj.hkt.Kind2";

    @Override
    public String getDisplayName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> getTags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum Arity {

        UNARY, BINARY
    }
}
