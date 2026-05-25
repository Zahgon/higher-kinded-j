// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.basejdk;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.TypeName;
import io.avaje.spi.ServiceProvider;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.lang.model.element.RecordComponentElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.TypeMirror;
import org.higherkindedj.optics.processing.generator.BaseTraversableGenerator;
import org.higherkindedj.optics.processing.spi.TraversableGenerator;
import org.higherkindedj.optics.util.Traversals;

/**
 * A {@link org.higherkindedj.optics.processing.spi.TraversableGenerator} that adds support for
 * traversing native Java arrays (e.g., {@code String[]}, {@code int[]}).
 *
 * <p>This class is discovered by the {@code TraversalProcessor} using the Java ServiceLoader
 * mechanism.
 */
@ServiceProvider(TraversableGenerator.class)
public class ArrayGenerator extends BaseTraversableGenerator {

    /**
     * Creates a new generator for native Java array fields.
     */
    public ArrayGenerator() {
    }

    /**
     * Supports any type that is an instance of {@link ArrayType}.
     */
    @Override
    public boolean supports(final TypeMirror type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String generateOpticExpression() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> getRequiredImports() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Generates the body of the `modifyF` method for a traversal over an array.
     */
    @Override
    public CodeBlock generateModifyF(final RecordComponentElement component, final ClassName recordClassName, final List<? extends RecordComponentElement> allComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the component type of an array. This overrides the base implementation to handle {@link
     * ArrayType}.
     *
     * @param component The record component which must be an array type.
     * @return The {@link TypeName} of the array's component type (e.g., {@code String} for a {@code
     *     String[]}).
     */
    @Override
    protected TypeName getGenericTypeName(final RecordComponentElement component) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
