// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.external;

import java.util.List;
import javax.lang.model.element.TypeElement;

/**
 * Result of analysing an external type to determine what optics to generate.
 *
 * <p>The analysis captures the kind of type (record, sealed interface, enum, or wither-based class)
 * along with the relevant information needed for optics generation.
 *
 * @param typeElement the analysed type element
 * @param typeKind the determined kind of the type
 * @param fields field information for lens generation (records and wither classes)
 * @param witherMethods wither method information for wither-based classes
 * @param permittedSubtypes permitted subtypes for sealed interfaces
 * @param enumConstants enum constants for enum types
 * @param hasMutableFields whether the type has mutable fields (setters)
 */
public record TypeAnalysis(TypeElement typeElement, TypeKind typeKind, List<FieldInfo> fields, List<WitherInfo> witherMethods, List<TypeElement> permittedSubtypes, List<String> enumConstants, boolean hasMutableFields) {

    /**
     * The kind of type that was analysed.
     */
    public enum TypeKind {

        /**
         * A Java record type. Lenses are generated via canonical constructor.
         */
        RECORD,
        /**
         * A sealed interface. Prisms are generated for each permitted subtype.
         */
        SEALED_INTERFACE,
        /**
         * An enum type. Prisms are generated for each constant.
         */
        ENUM,
        /**
         * A class with wither methods. Lenses are generated via withX() methods.
         */
        WITHER_CLASS,
        /**
         * A type that cannot have optics generated (e.g., mutable class without withers).
         */
        UNSUPPORTED
    }

    /**
     * Creates an analysis result for a record type.
     *
     * @param typeElement the record type element
     * @param fields the record components as field info
     * @return a new TypeAnalysis for the record
     */
    public static TypeAnalysis forRecord(TypeElement typeElement, List<FieldInfo> fields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an analysis result for a sealed interface.
     *
     * @param typeElement the sealed interface element
     * @param permittedSubtypes the permitted subtypes
     * @return a new TypeAnalysis for the sealed interface
     */
    public static TypeAnalysis forSealedInterface(TypeElement typeElement, List<TypeElement> permittedSubtypes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an analysis result for an enum type.
     *
     * @param typeElement the enum type element
     * @param enumConstants the enum constant names
     * @return a new TypeAnalysis for the enum
     */
    public static TypeAnalysis forEnum(TypeElement typeElement, List<String> enumConstants) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an analysis result for a class with wither methods.
     *
     * @param typeElement the class type element
     * @param fields the fields derived from wither methods
     * @param witherMethods the detected wither methods
     * @param hasMutableFields whether the class also has setter methods
     * @return a new TypeAnalysis for the wither class
     */
    public static TypeAnalysis forWitherClass(TypeElement typeElement, List<FieldInfo> fields, List<WitherInfo> witherMethods, boolean hasMutableFields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates an analysis result for an unsupported type.
     *
     * @param typeElement the unsupported type element
     * @param hasMutableFields whether the type has mutable fields
     * @return a new TypeAnalysis indicating the type is unsupported
     */
    public static TypeAnalysis unsupported(TypeElement typeElement, boolean hasMutableFields) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns whether this type supports lens generation.
     *
     * @return true if lenses can be generated for this type
     */
    public boolean supportsLenses() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns whether this type supports prism generation.
     *
     * @return true if prisms can be generated for this type
     */
    public boolean supportsPrisms() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
