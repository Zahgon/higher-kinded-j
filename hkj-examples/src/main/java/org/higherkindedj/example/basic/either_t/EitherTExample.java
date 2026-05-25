// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.either_t;

import static org.higherkindedj.hkt.either.EitherKindHelper.EITHER;
import static org.higherkindedj.hkt.future.CompletableFutureKindHelper.FUTURE;
import static org.higherkindedj.hkt.instances.Witnesses.*;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.MonadError;
import org.higherkindedj.hkt.either.Either;
import org.higherkindedj.hkt.either.EitherKind;
import org.higherkindedj.hkt.either_t.EitherT;
import org.higherkindedj.hkt.either_t.EitherTKind;
import org.higherkindedj.hkt.future.CompletableFutureKind;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.optional.OptionalKind;
import org.higherkindedj.hkt.optional.OptionalKindHelper;

public class EitherTExample {

    // --- Setup ---
    record DomainError(String message) {
    }

    record ValidatedData(String data) {
    }

    record ProcessedData(String data) {
    }

    MonadError<CompletableFutureKind.Witness, Throwable> futureMonad = Instances.monadError(completableFuture());

    MonadError<EitherTKind.Witness<CompletableFutureKind.Witness, DomainError>, DomainError> eitherTMonad = Instances.eitherT(futureMonad);

    // --- Workflow Steps (now purer, without logging) ---
    // Simulates a sync validation returning Either
    Kind<EitherKind.Witness<DomainError>, ValidatedData> validateSync(String input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Simulates an async processing step returning Future<Either>
    Kind<CompletableFutureKind.Witness, Either<DomainError, ProcessedData>> processAsync(ValidatedData vd) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Original Workflow ---
    Kind<CompletableFutureKind.Witness, Either<DomainError, ProcessedData>> runWorkflow(String initialInput) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Refactored Workflow using `peek` for logging ---
    Kind<CompletableFutureKind.Witness, Either<DomainError, ProcessedData>> runWorkflowAndLog(String initialInput) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Refactored Workflow using `as` for a final status ---
    Kind<CompletableFutureKind.Witness, Either<DomainError, String>> runWorkflowAndSignalCompletion(String initialInput) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void asyncWorkflowErrorHandlingExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- mapT: Switching the outer monad ---
    //
    // mapT lets you swap the outer monad without touching the inner Either.
    // Here we convert a Future-based EitherT into an Optional-based one —
    // useful when you have already awaited a result and want to continue
    // in a synchronous context.
    public void mapTExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
