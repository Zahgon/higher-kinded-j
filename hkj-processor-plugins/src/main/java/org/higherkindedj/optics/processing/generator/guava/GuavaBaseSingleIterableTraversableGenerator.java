// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.guava;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.RecordComponentElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import org.higherkindedj.optics.processing.generator.BaseTraversableGenerator;
import org.higherkindedj.optics.util.Traversals;

/// Base of Traversable Generators for Google Guava Collections that are both:
///  * A collection of 0...n, not 1
///  * Of a single type/column
public abstract class GuavaBaseSingleIterableTraversableGenerator extends BaseTraversableGenerator {

    private static final String COLLECTIONS_PACKAGE = "com.google.common.collect";

    /**
     * Class name for Guava's {@code ImmutableList}.
     */
    public static final ClassName IMMUTABLE_LIST = ClassName.get(COLLECTIONS_PACKAGE, "ImmutableList");

    /**
     * Class name for Guava's {@code ImmutableSet}.
     */
    public static final ClassName IMMUTABLE_SET = ClassName.get(COLLECTIONS_PACKAGE, "ImmutableSet");

    /**
     * The concrete Guava collection type this generator supports.
     */
    protected final ClassName supportedType;

    GuavaBaseSingleIterableTraversableGenerator(final ClassName supportedType) {
        this.supportedType = supportedType;
    }

    @Override
    public String generateOpticExpression() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> getRequiredImports() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean supports(final TypeMirror type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CodeBlock generateModifyF(final RecordComponentElement component, final ClassName recordClassName, final List<? extends RecordComponentElement> allComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
