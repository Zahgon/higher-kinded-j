// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.spring.autoconfigure.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.higherkindedj.hkt.Natural;
import org.higherkindedj.hkt.effect.boundary.EffectBoundary;
import org.higherkindedj.hkt.eitherf.Interpreters;
import org.higherkindedj.hkt.io.IOKind;
import org.higherkindedj.spring.autoconfigure.effect.Interpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Registers an {@link EffectBoundary} bean for test contexts by discovering {@link
 * Interpreter @Interpreter}-annotated beans and combining them.
 *
 * <p>This registrar is imported by {@link EffectTest} and only activates when the {@code effects}
 * parameter is non-empty. It mirrors the production {@link
 * org.higherkindedj.spring.autoconfigure.effect.EffectBoundaryRegistrar} but is designed for test
 * contexts where the web layer may not be present.
 *
 * @see EffectTest
 */
public class EffectTestRegistrar implements ImportBeanDefinitionRegistrar {

    private static final Logger log = LoggerFactory.getLogger(EffectTestRegistrar.class);

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Factory bean that creates an {@link EffectBoundary} for test contexts by discovering {@link
     * Interpreter} beans.
     */
    public static class EffectTestBoundaryFactoryBean implements FactoryBean<EffectBoundary<?>> {

        private final Class<?>[] effects;

        private ApplicationContext applicationContext;

        public EffectTestBoundaryFactoryBean(Class<?>[] effects) {
            this.effects = effects;
        }

        @Autowired
        public void setApplicationContext(ApplicationContext applicationContext) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public EffectBoundary<?> getObject() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
        private Natural combineInterpreters(List<Natural<?, IOKind.Witness>> interpreters) {
            return switch(interpreters.size()) {
                case 1 ->
                    interpreters.getFirst();
                case 2 ->
                    Interpreters.combine((Natural) interpreters.get(0), (Natural) interpreters.get(1));
                case 3 ->
                    Interpreters.combine((Natural) interpreters.get(0), (Natural) interpreters.get(1), (Natural) interpreters.get(2));
                case 4 ->
                    Interpreters.combine((Natural) interpreters.get(0), (Natural) interpreters.get(1), (Natural) interpreters.get(2), (Natural) interpreters.get(3));
                default ->
                    throw new BeanCreationException("effectBoundary", "Interpreters.combine() supports up to 4 effect algebras. Found " + interpreters.size() + ".");
            };
        }

        @Override
        public Class<?> getObjectType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isSingleton() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
