// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing.external;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.RecordComponentElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * Analyses external types to determine what kind of optics can be generated.
 *
 * <p>This class examines a {@link TypeElement} and produces a {@link TypeAnalysis} that describes:
 *
 * <ul>
 *   <li>The kind of type (record, sealed interface, enum, wither class)
 *   <li>Fields and their accessors
 *   <li>Wither methods for immutable update
 *   <li>Container fields that need traversals
 *   <li>Whether the type has mutable fields
 * </ul>
 */
public class TypeKindAnalyser {

    private final Types typeUtils;

    /**
     * Creates a new TypeKindAnalyser.
     *
     * @param typeUtils the type utilities from the processing environment
     */
    public TypeKindAnalyser(Types typeUtils) {
        this.typeUtils = typeUtils;
    }

    /**
     * Analyses a type element to determine what optics can be generated.
     *
     * @param typeElement the type to analyse
     * @return the analysis result
     */
    public TypeAnalysis analyseType(TypeElement typeElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private TypeAnalysis analyseRecord(TypeElement recordElement) {
        List<FieldInfo> fields = new ArrayList<>();
        for (RecordComponentElement component : recordElement.getRecordComponents()) {
            String name = component.getSimpleName().toString();
            TypeMirror type = component.asType();
            Optional<ContainerType> containerType = detectContainerType(type);
            if (containerType.isPresent()) {
                fields.add(FieldInfo.forRecordComponent(name, type, containerType.get()));
            } else {
                fields.add(FieldInfo.forRecordComponent(name, type));
            }
        }
        return TypeAnalysis.forRecord(recordElement, fields);
    }

    private TypeAnalysis analyseSealedInterface(TypeElement sealedInterface) {
        List<TypeElement> permittedSubtypes = new ArrayList<>();
        for (TypeMirror permittedType : sealedInterface.getPermittedSubclasses()) {
            TypeElement subtypeElement = (TypeElement) typeUtils.asElement(permittedType);
            permittedSubtypes.add(subtypeElement);
        }
        return TypeAnalysis.forSealedInterface(sealedInterface, permittedSubtypes);
    }

    private TypeAnalysis analyseEnum(TypeElement enumElement) {
        List<String> constants = new ArrayList<>();
        for (var enclosed : enumElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.ENUM_CONSTANT) {
                constants.add(enclosed.getSimpleName().toString());
            }
        }
        return TypeAnalysis.forEnum(enumElement, constants);
    }

    private TypeAnalysis analyseClass(TypeElement classElement) {
        List<WitherInfo> witherMethods = detectWitherMethods(classElement);
        boolean hasMutableFields = detectMutableFields(classElement);
        if (witherMethods.isEmpty()) {
            // No withers found - this is an unsupported class
            return TypeAnalysis.unsupported(classElement, hasMutableFields);
        }
        // Convert wither methods to field info
        List<FieldInfo> fields = new ArrayList<>();
        for (WitherInfo wither : witherMethods) {
            Optional<ContainerType> containerType = detectContainerType(wither.parameterType());
            if (containerType.isPresent()) {
                fields.add(FieldInfo.forGetter(wither.fieldName(), wither.parameterType(), wither.getterMethodName(), CopyStrategy.WITHER, containerType.get()));
            } else {
                fields.add(FieldInfo.forGetter(wither.fieldName(), wither.parameterType(), wither.getterMethodName(), CopyStrategy.WITHER));
            }
        }
        return TypeAnalysis.forWitherClass(classElement, fields, witherMethods, hasMutableFields);
    }

    /**
     * Detects wither methods on a class.
     *
     * <p>A wither method must:
     *
     * <ul>
     *   <li>Be named {@code withXxx} where {@code xxx} is the field name
     *   <li>Take exactly one parameter
     *   <li>Return the same type as the declaring class
     *   <li>Be public and non-static
     * </ul>
     *
     * @param classElement the class to analyse
     * @return list of detected wither methods
     */
    public List<WitherInfo> detectWitherMethods(TypeElement classElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String extractFieldName(String witherMethodName) {
        // withYear -> year, withDayOfMonth -> dayOfMonth
        String afterWith = witherMethodName.substring(4);
        return afterWith.substring(0, 1).toLowerCase(Locale.ROOT) + afterWith.substring(1);
    }

    private String findGetterMethod(TypeElement classElement, String fieldName, VariableElement witherParam) {
        TypeMirror expectedType = witherParam.asType();
        // Try various getter naming conventions
        String[] getterCandidates = { // record-style: year()
        fieldName, // JavaBean: getYear()
        "get" + capitalise(fieldName), // boolean: isActive()
        "is" + capitalise(fieldName) };
        for (var enclosed : classElement.getEnclosedElements()) {
            if (enclosed.getKind() != ElementKind.METHOD) {
                continue;
            }
            ExecutableElement method = (ExecutableElement) enclosed;
            String methodName = method.getSimpleName().toString();
            // Check if method name matches any getter pattern
            for (String candidate : getterCandidates) {
                if (methodName.equals(candidate)) {
                    // Must be public, non-static, take no parameters
                    if (!method.getModifiers().contains(Modifier.PUBLIC) || method.getModifiers().contains(Modifier.STATIC) || !method.getParameters().isEmpty()) {
                        continue;
                    }
                    // Return type must match wither parameter type
                    if (typeUtils.isSameType(method.getReturnType(), expectedType)) {
                        return methodName;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Detects whether a class has mutable fields (setters).
     *
     * @param classElement the class to analyse
     * @return true if the class has setter methods
     */
    public boolean detectMutableFields(TypeElement classElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Detects if a type is a container type that can have a traversal generated.
     *
     * <p>This method uses exact type matching (e.g., only {@code java.util.List}, not subtypes like
     * {@code ArrayList}). For subtype-aware detection, use {@link
     * #detectContainerTypeWithSubtypes(TypeMirror, javax.lang.model.util.Elements)}.
     *
     * @param type the type to check
     * @return the container type info if detected, empty otherwise
     */
    public Optional<ContainerType> detectContainerType(TypeMirror type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Detects if a type is a container type, including subtypes like {@code ArrayList} for {@code
     * List}.
     *
     * <p>This method checks the type hierarchy to determine if a type implements or extends a known
     * container type. For example, {@code ArrayList<String>} is detected as {@code List<String>}.
     *
     * <p>Supported container types:
     *
     * <ul>
     *   <li>{@code List<A>} and subtypes (ArrayList, LinkedList, etc.)
     *   <li>{@code Set<A>} and subtypes (HashSet, TreeSet, LinkedHashSet, etc.)
     *   <li>{@code Optional<A>} (exact match only, as Optional is final)
     *   <li>{@code Map<K, V>} and subtypes (HashMap, TreeMap, etc.)
     *   <li>{@code A[]} arrays
     * </ul>
     *
     * @param type the type to check
     * @param elementUtils the element utilities for looking up type elements
     * @return the container type info if detected, empty otherwise
     */
    public Optional<ContainerType> detectContainerTypeWithSubtypes(TypeMirror type, Elements elementUtils) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String capitalise(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        return s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1);
    }
}
