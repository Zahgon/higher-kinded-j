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
import org.higherkindedj.hkt.either.Either;
import org.higherkindedj.optics.processing.generator.BaseTraversableGenerator;
import org.higherkindedj.optics.processing.spi.Cardinality;
import org.higherkindedj.optics.processing.spi.TraversableGenerator;

/**
 * A {@link TraversableGenerator} that adds support for traversing fields of type {@link Either},
 * focusing on the right value.
 */
@ServiceProvider(TraversableGenerator.class)
public class EitherGenerator extends BaseTraversableGenerator {

    /**
     * Creates a new generator for {@link Either} fields.
     */
    public EitherGenerator() {
    }

    private static final String FQN_EITHER = "org.higherkindedj.hkt.either.Either";

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

    private TypeName getRightTypeName(final RecordComponentElement component) {
        if (component.asType() instanceof DeclaredType containerType) {
            if (containerType.getTypeArguments().size() < 2) {
                return ClassName.get(Object.class);
            }
            return TypeName.get(containerType.getTypeArguments().get(1));
        }
        return ClassName.get(Object.class);
    }

    private TypeName getLeftTypeName(final RecordComponentElement component) {
        if (component.asType() instanceof DeclaredType containerType) {
            if (containerType.getTypeArguments().isEmpty()) {
                return ClassName.get(Object.class);
            }
            return TypeName.get(containerType.getTypeArguments().getFirst());
        }
        return ClassName.get(Object.class);
    }
}
