// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.fetch;

import static java.util.Objects.requireNonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Offline introspection for {@link Fetch} programs.
 *
 * <p>{@link #preflight(Fetch)} folds a program into a {@link Plan} without performing any I/O. Use
 * this for audit logs, dry-run output, or pre-dispatch budgeting in tests.
 *
 * <p><b>Round 1 is always reliable.</b> The first round's keyset comes straight from the program's
 * pending-key tree, so the dispatch you most care about (the headline batched call a traversal
 * collapses to) is observed without running anything.
 *
 * <p><b>Past round 1, it depends.</b> The walk feeds the resume continuations a stub map whose
 * entries are present but {@code null}. A program whose combine logic tolerates {@code null}
 * (string concatenation, an {@code ArrayList::add}, a sealed-record copy that accepts nulls) walks
 * fully; one that rejects {@code null} (anything calling {@code List.of(v)}, {@code Objects.equals}
 * on a primitive, {@code Map.of(k, v)}) trips during the walk. The preflight catches that and
 * reports what it observed with {@link Plan#truncated() truncated = true} to signal that more
 * rounds may exist but cannot be seen offline. A {@code flatMap} value dependency truncates for the
 * same reason: the continuation needs the value to decide what to fetch next.
 *
 * <p>For online enforcement (refuse to dispatch beyond a budget, with the same per-round visibility
 * the runner has) see {@link Guards}.
 */
public final class Plans {

    private Plans() {
    }

    /**
     * Fold a {@link Fetch} program into its {@link Plan} without any backend I/O.
     *
     * @param fetch the program to inspect
     * @return the plan; {@link Plan#empty()} for a {@code Done}, otherwise a list of per-round
     *     keysets and a flag indicating whether a {@code flatMap} stopped further inspection
     */
    public static <K, V, A> Plan<K> preflight(Fetch<K, V, A> fetch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A map whose entries are present (so the substrate's {@code containsKey} round-skipping logic
     * works) but whose values are {@code null}: deliberately useless to anyone who tries to read one,
     * which is how a preflight detects a {@code flatMap} dependency.
     */
    private static <K, V> Map<K, V> stubMap(Set<K> keys) {
        HashMap<K, V> m = HashMap.newHashMap(keys.size());
        for (K k : keys) {
            m.put(k, null);
        }
        return Collections.unmodifiableMap(m);
    }
}
