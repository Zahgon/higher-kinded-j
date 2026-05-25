// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.vavr;

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

/// Base of Traversable Generators for Vavr's collections that are both:
///  * A collection of 0...n, not 1
///  * Of a single type/column
public abstract class VavrBaseSingleIterableTraversableGenerator extends BaseTraversableGenerator {

    private static final String COLLECTION_PACKAGE = "io.vavr.collection";

    /**
     * Class name for Vavr's {@code Set} interface.
     */
    public static final ClassName SET = ClassName.get(COLLECTION_PACKAGE, "Set");

    /**
     * Class name for Vavr's {@code HashSet} implementation.
     */
    public static final ClassName HASH_SET = ClassName.get(COLLECTION_PACKAGE, "HashSet");

    /**
     * Class name for Vavr's {@code List}.
     */
    public static final ClassName LIST = ClassName.get(COLLECTION_PACKAGE, "List");

    /**
     * The Vavr collection type this generator matches against.
     */
    protected final ClassName supportedType;

    /**
     * The concrete Vavr type used to construct new collection instances.
     */
    protected final ClassName constructedType;

    VavrBaseSingleIterableTraversableGenerator(final ClassName supportedType, final ClassName constructedType) {
        this.supportedType = supportedType;
        this.constructedType = constructedType;
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
