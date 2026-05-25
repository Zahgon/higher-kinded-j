// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.hkj;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.ParameterizedTypeName;
import com.palantir.javapoet.TypeName;
import com.palantir.javapoet.TypeVariableName;
import io.avaje.spi.ServiceProvider;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.RecordComponentElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.optics.processing.generator.BaseTraversableGenerator;
import org.higherkindedj.optics.processing.spi.Cardinality;
import org.higherkindedj.optics.processing.spi.TraversableGenerator;

/**
 * A {@link TraversableGenerator} that adds support for traversing fields of type {@link Validated}.
 * This version uses a robust if/else block to avoid type inference issues.
 */
@ServiceProvider(TraversableGenerator.class)
public class ValidatedGenerator extends BaseTraversableGenerator {

    /**
     * Creates a new generator for {@link Validated} fields.
     */
    public ValidatedGenerator() {
    }

    private static final String FQN_VALIDATED = "org.higherkindedj.hkt.validated.Validated";

    @Override
    public boolean supports(final TypeMirror type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Cardinality getCardinality() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int getFocusTypeArgumentIndex() {
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

    @Override
    public CodeBlock generateModifyF(final RecordComponentElement component, final ClassName recordClassName, final List<? extends RecordComponentElement> allComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the 'valid' type from a {@code Validated<E, A>} component. This overrides the base
     * implementation to get the second generic argument.
     */
    @Override
    protected TypeName getGenericTypeName(final RecordComponentElement component) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the 'error' type from a {@code Validated<E, A>} component.
     */
    private TypeName getErrorTypeName(final RecordComponentElement component) {
        if (component.asType() instanceof DeclaredType containerType) {
            if (containerType.getTypeArguments().isEmpty()) {
                // Fallback
                return ClassName.get(Object.class);
            }
            // For Validated<E, A>, the 'error' type E is the first argument.
            return TypeName.get(containerType.getTypeArguments().getFirst());
        }
        return ClassName.get(Object.class);
    }
}
