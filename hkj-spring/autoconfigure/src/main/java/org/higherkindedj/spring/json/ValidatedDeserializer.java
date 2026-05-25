// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.spring.json;

import org.higherkindedj.hkt.validated.Validated;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

/**
 * Jackson 3.x deserializer for {@link Validated} types.
 *
 * <p>Deserializes JSON objects with the following structure:
 *
 * <pre>
 * // Valid value
 * {
 *   "valid": true,
 *   "value": &lt;value&gt;
 * }
 *
 * // Invalid value
 * {
 *   "valid": false,
 *   "errors": &lt;errors&gt;
 * }
 * </pre>
 *
 * <p>Note: Due to Java's type erasure, the deserializer produces Validated&lt;Object, Object&gt;.
 * For strongly-typed deserialization, use custom DTOs or configure Jackson TypeReferences.
 */
public class ValidatedDeserializer extends StdDeserializer<Validated<?, ?>> {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new ValidatedDeserializer for the Validated type.
     */
    @SuppressWarnings("unchecked")
    public ValidatedDeserializer() {
        super((Class<Validated<?, ?>>) (Class<?>) Validated.class);
    }

    @Override
    public Validated<?, ?> deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
