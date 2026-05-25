// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.writer;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.writer.WriterKindHelper.*;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.writer.Writer;
import org.higherkindedj.hkt.writer.WriterKind;
import org.jspecify.annotations.NonNull;

/**
 * see {<a href="https://higher-kinded-j.github.io/writer_monad.html">Writer Monad</a>}
 */
public class WriterExample {

    Monoid<String> stringMonoid = new StringMonoid();

    Monad<WriterKind.Witness<String>> writerMonad = Instances.writer(stringMonoid);

    Kind<WriterKind.Witness<String>, Integer> initialValue = WRITER.value(stringMonoid, 5);

    Kind<WriterKind.Witness<String>, Unit> logStart = WRITER.tell("Starting calculation; ");

    Function<Integer, Kind<WriterKind.Witness<String>, Integer>> addAndLog = x -> {
        int result = x + 10;
        String logMsg = "Added 10 to " + x + " -> " + result + "; ";
        // Assuming direct creation with log and value if Writer.create was meant for that
        return WRITER.widen(new Writer<>(logMsg, result));
    };

    Function<Integer, Kind<WriterKind.Witness<String>, String>> multiplyAndLogToString = x -> {
        int result = x * 2;
        String logMsg = "Multiplied " + x + " by 2 -> " + result + "; ";
        return WRITER.widen(new Writer<>(logMsg, "Final:" + result));
    };

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void runWriterExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

class StringMonoid implements Monoid<String> {

    @Override
    @NonNull
    public String empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @NonNull
    public String combine(@NonNull String x, @NonNull String y) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
