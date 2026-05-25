// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.effect;

import java.util.List;
import org.higherkindedj.hkt.effect.ReaderPath;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.annotations.GenerateFocus;
import org.higherkindedj.optics.focus.FocusPath;

/**
 * Demonstrates {@code ReaderPath.magnify(FocusPath)} in a service-layer shape close to a Spring
 * application.
 *
 * <p>The pattern: each sub-service is written against a typed sub-environment ({@code DbConfig},
 * {@code AuthConfig}). The application bundles those into a larger {@code AppEnv}, and the
 * controller-level code lifts the sub-services into {@code AppEnv}-shaped requests using {@code
 * magnify(FocusPath)}, where the {@link FocusPath} comes from {@code @GenerateFocus} without any
 * boilerplate.
 *
 * <p>This is the same shape a Spring service layer takes when typed dependencies are injected via
 * {@link ReaderPath} rather than constructor parameters. The win is that each sub-service stays
 * narrowly typed against its dependency, and the wider environment shape is composed at the call
 * site.
 *
 * <p>Run with:
 *
 * <pre>{@code
 * ./gradlew :hkj-examples:run -PmainClass=org.higherkindedj.example.effect.MagnifyServiceLayerExample
 * }</pre>
 */
public class MagnifyServiceLayerExample {

    // ============= Domain Model =============
    @GenerateFocus
    public record DbConfig(String url, int maxConnections) {
    }

    @GenerateFocus
    public record AuthConfig(String issuer, int tokenTtlSeconds) {
    }

    /**
     * The bundled application environment exposed to controller-level code.
     */
    @GenerateFocus
    public record AppEnv(DbConfig db, AuthConfig auth, String tenant) {
    }

    public record User(String id, String name, String tenant) {
    }

    // ============= Sub-services (narrow typing) =============
    /**
     * Loads a user. Knows only about {@link DbConfig}.
     */
    static ReaderPath<DbConfig, User> loadUser(String userId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Issues a token. Knows only about {@link AuthConfig}.
     */
    static ReaderPath<AuthConfig, String> issueToken(String userId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ============= Controller-level composition =============
    /**
     * Builds a controller-level computation: load the user, then issue a token, both lifted into the
     * larger {@link AppEnv} via {@code magnify(FocusPath)}.
     *
     * <p>This is what an HTTP handler would look like when its dependencies are read from the
     * environment rather than injected by name.
     */
    static ReaderPath<AppEnv, String> handleLogin(String userId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ============= Demonstration =============
    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
