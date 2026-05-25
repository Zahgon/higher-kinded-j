// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.apache;

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

/// Base of Traversable Generators for Apache Collections that are both:
///  * A collection of 0...n, not 1
///  * Of a single type/column
public abstract class ApacheBaseSingleIterableTraversableGenerator extends BaseTraversableGenerator {

    /**
     * Base package name for Apache Commons Collections 4.
     */
    protected static final String PACKAGE = "org.apache.commons.collections4";

    /**
     * Package name for Apache Commons Collections bag implementations.
     */
    protected static final String BAG_PACKAGE = PACKAGE + ".bag";

    /**
     * Package name for Apache Commons Collections list implementations.
     */
    protected static final String LIST_PACKAGE = PACKAGE + ".list";

    /**
     * Class name for Apache Commons Collections {@code HashBag}.
     */
    public static final ClassName HASH_BAG = ClassName.get(BAG_PACKAGE, "HashBag");

    /**
     * Class name for Apache Commons Collections {@code UnmodifiableList}.
     */
    public static final ClassName UNMODIFIABLE_LIST = ClassName.get(LIST_PACKAGE, "UnmodifiableList");

    // Unfortunately, the return type of making both `UnmodifiableBag` and `UnmodifiableSet` is
    //   `Bag` and `Set` respectively, which means we would probably need to do an unsafe cast to
    //   properly convert them.
    /**
     * The concrete Apache collection type this generator supports.
     */
    protected final ClassName supportedType;

    ApacheBaseSingleIterableTraversableGenerator(final ClassName supportedType) {
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
