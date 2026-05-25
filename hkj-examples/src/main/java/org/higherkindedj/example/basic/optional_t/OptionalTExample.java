// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.optional_t;

import static org.higherkindedj.hkt.future.CompletableFutureKindHelper.FUTURE;
import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.optional.OptionalKindHelper.OPTIONAL;
import static org.higherkindedj.hkt.optional_t.OptionalTKindHelper.OPTIONAL_T;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.future.CompletableFutureKind;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.optional.OptionalKind;
import org.higherkindedj.hkt.optional_t.OptionalT;
import org.higherkindedj.hkt.optional_t.OptionalTKind;
import org.higherkindedj.hkt.optional_t.OptionalTMonad;

/**
 * see {<a href="https://higher-kinded-j.github.io/optionalt_transformer.html">OptionalT
 * Transformer</a>}
 */
public class OptionalTExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void createExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class OptionalTAsyncExample {

        static final Monad<CompletableFutureKind.Witness> futureMonad = Instances.monadError(completableFuture());

        // OptionalTMonad now uses Unit as its error type
        static final OptionalTMonad<CompletableFutureKind.Witness> optionalTFutureMonad = new OptionalTMonad<>(futureMonad);

        static final ExecutorService executor = Executors.newFixedThreadPool(2);

        public static Kind<CompletableFutureKind.Witness, Optional<User>> fetchUserAsync(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static Kind<CompletableFutureKind.Witness, Optional<UserProfile>> fetchProfileAsync(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static Kind<CompletableFutureKind.Witness, Optional<UserPreferences>> fetchPrefsAsync(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static OptionalT<CompletableFutureKind.Witness, UserPreferences> getFullUserPreferences(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static OptionalT<CompletableFutureKind.Witness, UserPreferences> getPrefsWithDefault(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public static void main(String[] args) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public record User(String id, String name) {
        }

        public record UserProfile(String userId, String bio) {
        }

        public record UserPreferences(String userId, String theme) {
        }
    }
}
