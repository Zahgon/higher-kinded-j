// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.processing;

import com.google.auto.service.AutoService;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import org.higherkindedj.optics.annotations.GenerateForComprehensions;
import org.higherkindedj.optics.processing.util.ExcludeFromJacocoGeneratedReport;

/**
 * Annotation processor that generates extended-arity for-comprehension support classes.
 *
 * <p>When applied to a {@code package-info.java} annotated with {@link GenerateForComprehensions},
 * this processor generates:
 *
 * <ul>
 *   <li>{@code TupleN} records for the requested arity range
 *   <li>{@code MonadicStepsN} and {@code FilterableStepsN} classes for the {@code For}
 *       comprehension builder
 *   <li>{@code *PathStepsN} classes for each ForPath effect type
 * </ul>
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes("org.higherkindedj.optics.annotations.GenerateForComprehensions")
@SupportedSourceVersion(SourceVersion.RELEASE_25)
public class ForComprehensionProcessor extends AbstractProcessor {

    /**
     * Creates a new ForComprehensionProcessor.
     */
    public ForComprehensionProcessor() {
    }

    private final Set<String> processedPackages = new HashSet<>();

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @ExcludeFromJacocoGeneratedReport
    private void runTupleGenerator(int minArity, int maxArity, Element element) {
        try {
            TupleGenerator.generate(minArity, maxArity, processingEnv);
        } catch (Exception e) {
            error("Could not generate Tuple classes: " + e.getMessage(), element);
        }
    }

    @ExcludeFromJacocoGeneratedReport
    private void runForStepGenerator(int minArity, int maxArity, Element element) {
        try {
            ForStepGenerator.generate(minArity, maxArity, processingEnv);
        } catch (Exception e) {
            error("Could not generate For step classes: " + e.getMessage(), element);
        }
    }

    @ExcludeFromJacocoGeneratedReport
    private void runForPathStepGenerator(int minArity, int maxArity, Element element) {
        try {
            ForPathStepGenerator.generate(minArity, maxArity, processingEnv);
        } catch (Exception e) {
            error("Could not generate ForPath step classes: " + e.getMessage(), element);
        }
    }

    private void error(String msg, Element e) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg, e);
    }
}
