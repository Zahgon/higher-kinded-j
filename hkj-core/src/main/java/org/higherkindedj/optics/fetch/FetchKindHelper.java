// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.fetch;

import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.exception.KindUnwrapException;
import org.jspecify.annotations.Nullable;

/**
 * {@code widen}/{@code narrow} between {@link Fetch} and its {@link FetchKind} representation.
 */
public enum FetchKindHelper {

    FETCH;

    record FetchHolder<K, V, A>(Fetch<K, V, A> fetch) implements FetchKind<K, V, A> {

        FetchHolder {
            if (fetch == null) {
                throw new KindUnwrapException("Cannot widen a null Fetch");
            }
        }
    }

    /**
     * Widens a concrete {@link Fetch} into its {@link Kind} representation.
     */
    public <K, V, A> Kind<FetchKind.Witness<K, V>, A> widen(Fetch<K, V, A> fetch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Narrows a {@link Kind} back to its concrete {@link Fetch}.
     */
    @SuppressWarnings("unchecked")
    public <K, V, A> Fetch<K, V, A> narrow(@Nullable Kind<FetchKind.Witness<K, V>, A> kind) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
