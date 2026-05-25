// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.basic.reader;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import static org.higherkindedj.hkt.reader.ReaderKindHelper.READER;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.reader.ReaderKind;

/**
 * see {<a href="https://higher-kinded-j.github.io/reader_monad.html">Reader Monad</a>}
 */
public class ReaderExample {

    // Reader that retrieves the database URL from the config
    Kind<ReaderKind.Witness<AppConfig>, String> getDbUrl = READER.reader(AppConfig::databaseUrl);

    // Reader that retrieves the timeout
    Kind<ReaderKind.Witness<AppConfig>, Integer> getTimeout = READER.reader(AppConfig::timeoutMillis);

    // Reader that returns a constant value, ignoring the environment
    Kind<ReaderKind.Witness<AppConfig>, String> getDefaultUser = READER.constant("guest");

    // Reader that returns the entire configuration environment
    Kind<ReaderKind.Witness<AppConfig>, AppConfig> getConfig = READER.ask();

    // Monad instance for computations depending on AppConfig
    Monad<ReaderKind.Witness<AppConfig>> readerMonad = Instances.monad(reader());

    // Example 1: Map the timeout value
    Kind<ReaderKind.Witness<AppConfig>, String> timeoutMessage = readerMonad.map(timeout -> "Timeout is: " + timeout + "ms", // Input: Kind<ReaderKind.Witness<AppConfig>, Integer>
    getTimeout);

    // Example 2: Use flatMap to get DB URL and then construct a connection string (depends on URL)
    Function<String, Kind<ReaderKind.Witness<AppConfig>, String>> buildConnectionString = dbUrl -> // <- We return a new Reader computation
    READER.// <- We return a new Reader computation
    reader(// Access apiKey via the 'config' env
    config -> dbUrl + "?apiKey=" + config.apiKey());

    Kind<ReaderKind.Witness<AppConfig>, String> connectionStringReader = readerMonad.flatMap(// Function: String -> Kind<ReaderKind.Witness<AppConfig>, String>
    buildConnectionString, // Input: Kind<ReaderKind.Witness<AppConfig>, String>
    getDbUrl);

    // Example 3: Combine multiple values using mapN (from Applicative)
    Kind<ReaderKind.Witness<AppConfig>, String> dbInfo = readerMonad.map2(getDbUrl, getTimeout, (url, timeout) -> "DB: " + url + " (Timeout: " + timeout + ")");

    public static void main(String... args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void runExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Define Environment
    record AppConfig(String databaseUrl, int timeoutMillis, String apiKey) {
    }
}
