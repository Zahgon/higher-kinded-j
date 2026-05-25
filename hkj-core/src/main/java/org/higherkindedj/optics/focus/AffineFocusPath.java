// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.focus;

import java.util.Objects;
import java.util.Optional;
import org.higherkindedj.optics.Affine;
import org.higherkindedj.optics.Iso;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.Prism;
import org.higherkindedj.optics.Traversal;
import org.jspecify.annotations.NullMarked;

/**
 * Implementation of {@link AffinePath} backed by an {@link Affine}.
 *
 * <p>This class is package-private and should be created via {@link AffinePath#of(Affine)}.
 *
 * @param <S> the source type
 * @param <A> the focused type
 */
@NullMarked
record AffineFocusPath<S, A>(Affine<S, A> affine) implements AffinePath<S, A> {

    AffineFocusPath {
        Objects.requireNonNull(affine, "affine must not be null");
    }

    @Override
    public Optional<A> getOptional(S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S set(A value, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Composition Methods =====
    @Override
    public <B> AffinePath<S, B> via(Lens<A, B> lens) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> AffinePath<S, B> via(Prism<A, B> prism) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> AffinePath<S, B> via(Affine<A, B> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> AffinePath<S, B> via(Iso<A, B> iso) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> TraversalPath<S, B> via(Traversal<A, B> traversal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ===== Conversion =====
    @Override
    public Affine<S, A> toAffine() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
