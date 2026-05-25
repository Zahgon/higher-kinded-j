// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.basejdk;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.TypeName;
import io.avaje.spi.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.lang.model.element.Element;
import javax.lang.model.element.RecordComponentElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.optics.processing.generator.BaseTraversableGenerator;
import org.higherkindedj.optics.processing.spi.TraversableGenerator;
import org.higherkindedj.optics.util.Traversals;

/**
 * A {@link org.higherkindedj.optics.processing.spi.TraversableGenerator} that adds support for
 * traversing the **values** of a field of type {@link java.util.Map}.
 */
@ServiceProvider(TraversableGenerator.class)
public class MapValueGenerator extends BaseTraversableGenerator {

    /**
     * Creates a new generator for {@link java.util.Map} value traversal.
     */
    public MapValueGenerator() {
    }

    private static final String FQN_MAP = "java.util.Map";

    @Override
    public boolean supports(final TypeMirror type) {
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
     * Gets the 'Value' type from a {@code Map<K, V>} component.
     */
    private TypeName getValueTypeName(final RecordComponentElement component) {
        if (component.asType() instanceof DeclaredType containerType) {
            if (containerType.getTypeArguments().size() < 2) {
                return ClassName.get(Object.class);
            }
            return TypeName.get(containerType.getTypeArguments().get(1)).box();
        }
        return ClassName.get(Object.class);
    }

    /**
     * Gets the 'Key' type from a {@code Map<K, V>} component.
     */
    private TypeName getKeyTypeName(final RecordComponentElement component) {
        if (component.asType() instanceof DeclaredType containerType) {
            if (containerType.getTypeArguments().isEmpty()) {
                return ClassName.get(Object.class);
            }
            return TypeName.get(containerType.getTypeArguments().getFirst()).box();
        }
        return ClassName.get(Object.class);
    }
}
