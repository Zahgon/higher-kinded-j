// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.effect;

import java.util.function.Function;
import org.higherkindedj.hkt.effect.EitherPath;
import org.higherkindedj.hkt.effect.Path;
import org.higherkindedj.hkt.either.Either;

/**
 * Examples demonstrating {@link EitherPath#bimap} for simultaneously transforming both the error
 * and the success tracks of an {@code EitherPath}.
 *
 * <p>{@code bimap(errorFn, successFn)} is equivalent to {@code .mapError(errorFn).map(successFn)}
 * but expressed in one call. It is useful when an operation's error and success types both need to
 * change at the same boundary, for example when adapting between an internal representation and a
 * public API response.
 *
 * <p>Run from an IDE or via {@code gradle :hkj-examples:run --args="EitherPathBimapExample"} or
 * invoking {@link #main(String[])} directly.
 */
public class EitherPathBimapExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Basic demonstration: transform both error and success types at once.
     */
    public void transformBothSides() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@code bimap(f, g)} is identical to {@code mapError(f).map(g)}.
     */
    public void equivalenceWithMapErrorThenMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Realistic example: converting an internal validation result into a public API response at a
     * service boundary. Both sides change type simultaneously.
     */
    public void realisticBoundaryTransform() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Supporting records for the realistic example =====
    record RawUser(String name, int age) {
    }

    record UserDto(String name, int age) {
    }

    record ApiError(String code, String message) {
    }

    private static <T> void assertEquals(T expected, T actual) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError("expected=" + expected + ", actual=" + actual);
        }
    }
}
