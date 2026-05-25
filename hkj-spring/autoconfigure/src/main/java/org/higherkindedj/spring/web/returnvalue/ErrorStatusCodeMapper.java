// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.spring.web.returnvalue;

import java.util.Map;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;

/**
 * Utility for mapping error types to HTTP status codes.
 *
 * <p>Resolution order applied by {@link #determineStatusCode(Object, int, Map)}:
 *
 * <ol>
 *   <li>Explicit override from {@code errorStatusMappings} keyed by the error's simple class name
 *       (preferred, stable across refactors of the package layout).
 *   <li>Explicit override keyed by the error's fully-qualified class name (useful when two classes
 *       share a simple name across packages).
 *   <li>Built-in token-aware heuristics on the simple class name.
 * </ol>
 *
 * <p>The heuristics are applied to a tokenised form of the simple class name (CamelCase split on
 * upper-case boundaries, then lower-cased and bracketed with separators). This means {@code
 * RevalidationError} no longer matches the {@code validation} rule, while {@code MfaNotFoundError}
 * still matches {@code NotFound}. Adopters who need anything beyond this should configure {@link
 * ErrorStatusCodeStrategy} as a Spring bean.
 *
 * @see ErrorStatusCodeStrategy
 * @see DefaultErrorStatusCodeStrategy
 */
public final class ErrorStatusCodeMapper {

    private ErrorStatusCodeMapper() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Backward-compatible overload. Equivalent to {@link #determineStatusCode(Object, int, Map)} with
     * an empty mapping table.
     *
     * @param error the error object
     * @param defaultStatus the default status code if no rule matches
     * @return the resolved HTTP status code
     */
    public static int determineStatusCode(Object error, int defaultStatus) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Resolves the HTTP status code for an error value.
     *
     * @param error the error object (must not be {@code null})
     * @param defaultStatus the default status code if no rule matches
     * @param errorStatusMappings explicit overrides keyed by simple or fully-qualified class name;
     *     {@code null} is treated as an empty map
     * @return the resolved HTTP status code
     */
    public static int determineStatusCode(Object error, int defaultStatus, @Nullable Map<String, Integer> errorStatusMappings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns the status code suggested by the built-in heuristics for the given simple class name,
     * or {@code defaultStatus} if no rule matches. Exposed as a static helper so custom {@link
     * ErrorStatusCodeStrategy} implementations can delegate to the same logic.
     *
     * @param simpleName the simple class name of the error
     * @param defaultStatus the default status code if no rule matches
     * @return the resolved HTTP status code
     */
    public static int heuristicStatus(String simpleName, int defaultStatus) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tokenises a CamelCase name into {@code -lower-case-token-} form so that callers can perform
     * word-boundary substring matches without having to roll their own scanner.
     *
     * <p>Examples:
     *
     * <ul>
     *   <li>{@code "MfaNotFoundError"} → {@code "-mfa-not-found-error-"}
     *   <li>{@code "RevalidationError"} → {@code "-revalidation-error-"}
     *   <li>{@code ""} → {@code "-"}
     * </ul>
     *
     * @param simpleName the CamelCase name to tokenise
     * @return the tokenised form bracketed with separators
     */
    static String tokenize(String simpleName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
