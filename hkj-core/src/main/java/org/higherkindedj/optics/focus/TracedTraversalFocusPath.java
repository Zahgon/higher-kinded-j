// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.optics.focus;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.higherkindedj.optics.Affine;
import org.higherkindedj.optics.Iso;
import org.higherkindedj.optics.Lens;
import org.higherkindedj.optics.Prism;
import org.higherkindedj.optics.Traversal;
import org.jspecify.annotations.NullMarked;

/**
 * A traced implementation of {@link TraversalPath} that invokes an observer during get operations.
 *
 * <p>This class wraps an underlying TraversalPath and adds tracing behavior to the {@link
 * #getAll(Object)} method. The observer is only invoked during get operations, not during modify
 * operations.
 *
 * @param <S> the source type
 * @param <A> the focused type
 */
@NullMarked
record TracedTraversalFocusPath<S, A>(TraversalPath<S, A> underlying, BiConsumer<S, List<A>> observer) implements TraversalPath<S, A> {

    TracedTraversalFocusPath {
        Objects.requireNonNull(underlying, "underlying must not be null");
        Objects.requireNonNull(observer, "observer must not be null");
    }

    @Override
    public List<A> getAll(S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S setAll(A value, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public S modifyAll(Function<A, A> f, S source) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TraversalPath<S, A> filter(Predicate<A> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> TraversalPath<S, B> via(Lens<A, B> lens) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> TraversalPath<S, B> via(Prism<A, B> prism) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> TraversalPath<S, B> via(Affine<A, B> affine) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> TraversalPath<S, B> via(Traversal<A, B> traversal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <B> TraversalPath<S, B> via(Iso<A, B> iso) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Traversal<S, A> toTraversal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
