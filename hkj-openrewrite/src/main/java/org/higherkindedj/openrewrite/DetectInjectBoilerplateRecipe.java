// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.openrewrite;

import java.util.List;
import java.util.Set;
import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.MethodMatcher;
import org.openrewrite.java.tree.J;
import org.openrewrite.marker.SearchResult;

/**
 * Recipe that identifies manual {@code Inject} instance construction and suggests using the
 * generated {@code @ComposeEffects} support class instead.
 *
 * <p>When users manually create Inject instances via {@code InjectInstances.injectLeft()}, {@code
 * InjectInstances.injectRight()}, and {@code InjectInstances.injectRightThen()}, this recipe
 * detects the pattern and marks it with a TODO comment suggesting migration to the generated
 * Support class from {@code @ComposeEffects}.
 *
 * <h2>Detection Pattern</h2>
 *
 * <p>Any call to {@code InjectInstances.injectLeft()}, {@code InjectInstances.injectRight()}, or
 * {@code InjectInstances.injectRightThen()} is flagged with an OpenRewrite {@link
 * org.openrewrite.marker.SearchResult} marker.
 *
 * <h2>Why this is detection-only</h2>
 *
 * <p>The {@code Support} class produced by {@code @ComposeEffects} is generated per composition,
 * with class and accessor names derived from the user's effect set and nesting order. The correct
 * replacement therefore cannot be synthesised generically, so this recipe flags the boilerplate for
 * a human to replace rather than risking an incorrect automated rewrite.
 *
 * @see "org.higherkindedj.hkt.inject.InjectInstances"
 * @see "org.higherkindedj.hkt.effect.annotation.ComposeEffects"
 */
public class DetectInjectBoilerplateRecipe extends Recipe {

    /**
     * Creates a new instance of this recipe.
     */
    public DetectInjectBoilerplateRecipe() {
    }

    private static final List<MethodMatcher> INJECT_MATCHERS = List.of(new MethodMatcher("org.higherkindedj.hkt.inject.InjectInstances injectLeft(..)"), new MethodMatcher("org.higherkindedj.hkt.inject.InjectInstances injectRight(..)"), new MethodMatcher("org.higherkindedj.hkt.inject.InjectInstances injectRightThen(..)"));

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
}
