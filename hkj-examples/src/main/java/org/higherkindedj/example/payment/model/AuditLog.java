// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.payment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;

/**
 * Immutable audit log that accumulates operation records.
 *
 * <p>Used by the audit interpreter to record every effect operation. Implements a monoid (empty +
 * append) for use with {@code WriterT}.
 *
 * @param entries the list of audit entries
 */
@NullMarked
public record AuditLog(List<String> entries) {

    public AuditLog {
        Objects.requireNonNull(entries, "entries cannot be null");
        entries = List.copyOf(entries);
    }

    /**
     * An empty audit log (monoid identity).
     */
    public static final AuditLog EMPTY = new AuditLog(List.of());

    /**
     * Creates a single-entry audit log.
     *
     * @param operation the operation name
     * @param details operation details
     * @return a new AuditLog with one entry
     */
    public static AuditLog of(String operation, String details) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Appends another audit log to this one (monoid combine).
     *
     * @param other the log to append
     * @return a new AuditLog with entries from both
     */
    public AuditLog append(AuditLog other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The number of entries in this log.
     *
     * @return the entry count
     */
    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
