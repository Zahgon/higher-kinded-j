// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.eclipse;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.lang.model.element.RecordComponentElement;
import org.higherkindedj.optics.util.Traversals;

/**
 * A base for the Traversable Generation for Sorted Sets from the Eclipse Collections
 */
public abstract class EclipseBaseSortedSetTraversableGenerator extends EclipseBaseSingleIterableTraversableGenerator {

    /**
     * Package name for Eclipse Collections sorted set interfaces.
     */
    public static final String SORTED_SET_PACKAGE = SET_PACKAGE + ".sorted";

    /**
     * Class name for the Eclipse Collections {@code SortedSets} factory.
     */
    public static final ClassName SORTED_SETS_API = ClassName.get(FACTORY_PACKAGE, "SortedSets");

    /**
     * Class name for Eclipse Collections {@code ImmutableSortedSet}.
     */
    public static final ClassName IMMUTABLE_SORTED_SET = ClassName.get(SORTED_SET_PACKAGE, "ImmutableSortedSet");

    /**
     * Class name for Eclipse Collections {@code MutableSortedSet}.
     */
    public static final ClassName MUTABLE_SORTED_SET = ClassName.get(SORTED_SET_PACKAGE, "MutableSortedSet");

    /**
     * Creates a new generator for an Eclipse Collections sorted set type.
     *
     * @param supportedElement the sorted set element type to support
     * @param immutable whether the target sorted set is immutable
     * @param api the factory class used to create sorted set instances
     */
    protected EclipseBaseSortedSetTraversableGenerator(final ClassName supportedElement, final boolean immutable, final ClassName api) {
        super(supportedElement, immutable, api);
    }

    @Override
    public CodeBlock generateModifyF(final RecordComponentElement component, final ClassName recordClassName, final List<? extends RecordComponentElement> allComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
