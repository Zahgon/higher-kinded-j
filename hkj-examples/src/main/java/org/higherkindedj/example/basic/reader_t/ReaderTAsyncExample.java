// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.reader_t;

import static org.higherkindedj.hkt.future.CompletableFutureKindHelper.FUTURE;
import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.reader_t.ReaderTKindHelper.READER_T;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.future.CompletableFutureKind;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.reader_t.ReaderT;
import org.higherkindedj.hkt.reader_t.ReaderTKind;

/**
 * see {<a href="https://higher-kinded-j.github.io/readert_transformer.html">ReaderT
 * Transformer</a>}
 */
public class ReaderTAsyncExample {

    // --- Monad Setup ---
    // Outer Monad F = CompletableFutureKind.Witness
    static final Monad<CompletableFutureKind.Witness> futureMonad = Instances.monadError(completableFuture());

    // ReaderTMonad for AppConfig and CompletableFutureKind
    static final Monad<ReaderTKind.Witness<CompletableFutureKind.Witness, AppConfig>> cfReaderTMonad = Instances.readerT(futureMonad);

    // Simulates an async call to an external service
    public static Kind<CompletableFutureKind.Witness, ServiceData> fetchExternalData(AppConfig config, String itemId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Operation 1: Fetch data, wrapped in ReaderT
    // This is R -> F<A> which is the core of ReaderT
    public static ReaderT<CompletableFutureKind.Witness, AppConfig, ServiceData> fetchServiceDataRT(String itemId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Operation 2: Process data (sync part, depends on AppConfig, then lifts to ReaderT)
    // This uses ReaderT.reader: R -> A, then A is lifted to F<A>
    public static ReaderT<CompletableFutureKind.Witness, AppConfig, ProcessedData> processDataRT(ServiceData sData) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Service Logic (depends on AppConfig, returns Future<ServiceData>) ---
    public static void main(String[] args) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- Environment ---
    record AppConfig(String apiKey, String serviceUrl, ExecutorService executor) {
    }

    // --- Service Response ---
    record ServiceData(String rawData) {
    }

    record ProcessedData(String info) {
    }
}
