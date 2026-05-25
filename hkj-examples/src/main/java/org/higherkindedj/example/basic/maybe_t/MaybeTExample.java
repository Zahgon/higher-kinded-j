// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.maybe_t;

import static org.higherkindedj.hkt.future.CompletableFutureKindHelper.FUTURE;
import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.maybe_t.MaybeTKindHelper.MAYBE_T;
import static org.higherkindedj.hkt.optional.OptionalKindHelper.OPTIONAL;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.MonadError;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.future.CompletableFutureKind;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.id.IdKind;
import org.higherkindedj.hkt.id.IdKindHelper;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.maybe.Maybe;
import org.higherkindedj.hkt.maybe_t.MaybeT;
import org.higherkindedj.hkt.maybe_t.MaybeTKind;
import org.higherkindedj.hkt.optional.OptionalKind;

/**
 * see {<a href="https://higher-kinded-j.github.io/maybet_transformer.html">MaybeT Transformer</a>}
 */
public class MaybeTExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- mapT: Switching the outer monad ---
    //
    // mapT lets you swap the outer monad without unwrapping the inner Maybe.
    // Here we convert an Optional-based MaybeT into an Id-based one —
    // collapsing the two layers of optionality into a single Maybe.
    public void mapTExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void createExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class MaybeTAsyncExample {

        Monad<CompletableFutureKind.Witness> futureMonad = Instances.monadError(completableFuture());

        MonadError<MaybeTKind.Witness<CompletableFutureKind.Witness>, Unit> maybeTMonad = Instances.maybeT(futureMonad);

        Kind<CompletableFutureKind.Witness, Maybe<User>> fetchUserAsync(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        Kind<CompletableFutureKind.Witness, Maybe<UserPreferences>> fetchPreferencesAsync(String userId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        Kind<CompletableFutureKind.Witness, Maybe<UserPreferences>> getUserPreferencesWorkflow(String userIdToFetch) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void asyncExample() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        record User(String id, String name) {
        }

        record UserPreferences(String userId, String theme) {
        }
    }
}
