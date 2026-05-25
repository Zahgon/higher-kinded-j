// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.generator.pcollections;

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

/**
 * Base class for {@link org.higherkindedj.optics.processing.spi.TraversableGenerator}s that target
 * single-element PCollections persistent collection types ({@code PVector}, {@code PStack}, {@code
 * PSet}, {@code PSortedSet}, {@code PBag}).
 *
 * <p>Each PCollections type implements {@link java.util.Collection}, so the source field can be
 * copied directly into a {@link ArrayList} without any library-specific iteration helper. The
 * traversal is performed against that JDK list and the resulting list is fed back through the
 * concrete factory's {@code from(Collection)} method to reconstruct the persistent type.
 */
public abstract class PCollectionsBaseSingleIterableTraversableGenerator extends BaseTraversableGenerator {

    /**
     * Root package for the PCollections public API.
     */
    protected static final String PCOLLECTIONS_PACKAGE = "org.pcollections";

    /**
     * {@code org.pcollections.PVector} interface.
     */
    public static final ClassName PVECTOR = ClassName.get(PCOLLECTIONS_PACKAGE, "PVector");

    /**
     * {@code org.pcollections.PStack} interface.
     */
    public static final ClassName PSTACK = ClassName.get(PCOLLECTIONS_PACKAGE, "PStack");

    /**
     * {@code org.pcollections.PSet} interface.
     */
    public static final ClassName PSET = ClassName.get(PCOLLECTIONS_PACKAGE, "PSet");

    /**
     * {@code org.pcollections.PSortedSet} interface.
     */
    public static final ClassName PSORTED_SET = ClassName.get(PCOLLECTIONS_PACKAGE, "PSortedSet");

    /**
     * {@code org.pcollections.PBag} interface.
     */
    public static final ClassName PBAG = ClassName.get(PCOLLECTIONS_PACKAGE, "PBag");

    /**
     * {@code org.pcollections.TreePVector} concrete factory.
     */
    public static final ClassName TREE_PVECTOR = ClassName.get(PCOLLECTIONS_PACKAGE, "TreePVector");

    /**
     * {@code org.pcollections.ConsPStack} concrete factory.
     */
    public static final ClassName CONS_PSTACK = ClassName.get(PCOLLECTIONS_PACKAGE, "ConsPStack");

    /**
     * {@code org.pcollections.HashTreePSet} concrete factory.
     */
    public static final ClassName HASH_TREE_PSET = ClassName.get(PCOLLECTIONS_PACKAGE, "HashTreePSet");

    /**
     * {@code org.pcollections.TreePSet} concrete factory (sorted set).
     */
    public static final ClassName TREE_PSET = ClassName.get(PCOLLECTIONS_PACKAGE, "TreePSet");

    /**
     * {@code org.pcollections.HashTreePBag} concrete factory.
     */
    public static final ClassName HASH_TREE_PBAG = ClassName.get(PCOLLECTIONS_PACKAGE, "HashTreePBag");

    /**
     * The PCollections interface this generator matches against (e.g. {@code PVector}).
     */
    protected final ClassName supportedType;

    /**
     * The concrete factory class used to reconstruct instances (e.g. {@code TreePVector}).
     */
    protected final ClassName constructedType;

    /**
     * @param supportedType the persistent collection interface this generator recognises
     * @param constructedType the concrete factory class whose {@code from(Collection)} reconstructs
     *     instances of {@code supportedType}
     */
    protected PCollectionsBaseSingleIterableTraversableGenerator(final ClassName supportedType, final ClassName constructedType) {
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
    public final boolean supports(final TypeMirror type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CodeBlock generateModifyF(final RecordComponentElement component, final ClassName recordClassName, final List<? extends RecordComponentElement> allComponents) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
