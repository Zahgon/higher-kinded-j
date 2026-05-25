// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.effect;

import java.util.concurrent.atomic.AtomicBoolean;
import org.higherkindedj.hkt.effect.IOPath;
import org.higherkindedj.hkt.effect.Path;
import org.higherkindedj.hkt.effect.VTaskPath;
import org.higherkindedj.hkt.effect.capability.Effectful;

/**
 * Examples demonstrating the polymorphic {@link Effectful} capability surface. {@code handleError},
 * {@code handleErrorWith}, and {@code guarantee} are all declared at the interface level, so
 * application code can write helpers against {@code Effectful<A>} and have them work unchanged for
 * both {@link IOPath} and {@link VTaskPath}.
 */
public class EffectfulPolymorphismExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Shared helper: written against the abstract {@code Effectful<A>} type, not any specific
     * implementation. Reused across both IOPath and VTaskPath call sites.
     */
    private static <A> Effectful<A> safeOrDefault(Effectful<A> effect, A fallback) {
        return effect.handleError(t -> fallback);
    }

    public void polymorphicHelperWorksForBothImplementations() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@code handleErrorWith} takes {@code Function<? super Throwable, ? extends Effectful<A>>}, so
     * the recovery function can return either an IOPath or a VTaskPath even when the receiver is the
     * other kind. The receiver's concrete type is preserved.
     */
    public void handleErrorWithAcceptsCrossImplementationRecovery() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@code guarantee} runs the finalizer whether the effect succeeds or fails.
     */
    public void guaranteeRunsFinalizerWhetherEffectSucceedsOrFails() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void require(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
