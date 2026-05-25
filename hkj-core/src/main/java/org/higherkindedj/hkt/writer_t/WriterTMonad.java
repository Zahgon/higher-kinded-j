// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.hkt.writer_t;

import static org.higherkindedj.hkt.util.validation.Operation.*;
import static org.higherkindedj.hkt.writer_t.WriterTKindHelper.WRITER_T;
import java.util.function.Function;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.MonadWriter;
import org.higherkindedj.hkt.Monoid;
import org.higherkindedj.hkt.Pair;
import org.higherkindedj.hkt.TypeArity;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.WitnessArity;
import org.higherkindedj.hkt.util.validation.Validation;
import org.jspecify.annotations.Nullable;

/**
 * Implements {@link Monad} and {@link MonadWriter} for the {@link WriterT} monad transformer.
 *
 * <p>This class provides the full monadic and writer capabilities for {@code WriterT}, including
 * {@code flatMap}, {@code tell}, {@code listen}, and {@code pass}. Output accumulation is performed
 * using the provided {@link Monoid} for type {@code W}.
 *
 * @param <F> The witness type of the outer monad.
 * @param <W> The type of the accumulated output (must form a {@link Monoid}).
 * @see WriterT
 * @see WriterTKind
 * @see MonadWriter
 * @see Monad
 * @see Monoid
 */
public class WriterTMonad<F extends WitnessArity<TypeArity.Unary>, W> implements MonadWriter<WriterTKind.Witness<F, W>, W> {

    private static final Class<WriterTMonad> WRITER_T_MONAD_CLASS = WriterTMonad.class;

    private final Monad<F> outerMonad;

    private final Monoid<W> monoid;

    /**
     * Constructs a {@link WriterTMonad} instance.
     *
     * @param outerMonad The {@link Monad} instance for the outer type constructor {@code F}. Must not
     *     be null.
     * @param monoid The {@link Monoid} instance for the output type {@code W}. Must not be null.
     * @throws NullPointerException if {@code outerMonad} or {@code monoid} is null.
     */
    public WriterTMonad(Monad<F> outerMonad, Monoid<W> monoid) {
        this.outerMonad = Validation.transformer().requireOuterMonad(outerMonad, WRITER_T_MONAD_CLASS, CONSTRUCTION);
        this.monoid = Validation.function().require(monoid, "monoid", CONSTRUCTION);
    }

    /**
     * Lifts a pure value into the {@code WriterT} context with empty output.
     *
     * @param value The value to lift.
     * @param <A> The type of the value.
     * @return A {@code Kind} representing a {@code WriterT} with the given value and empty output.
     */
    @Override
    public <A> Kind<WriterTKind.Witness<F, W>, A> of(@Nullable A value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Maps a function over the value in a {@code WriterT}, preserving the output.
     *
     * @param f The function to apply to the value. Must not be null.
     * @param fa The {@code WriterT} to map over. Must not be null.
     * @param <A> The original value type.
     * @param <B> The new value type.
     * @return A new {@code WriterT} with the transformed value.
     */
    @Override
    public <A, B> Kind<WriterTKind.Witness<F, W>, B> map(Function<? super A, ? extends B> f, Kind<WriterTKind.Witness<F, W>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies a function wrapped in a {@code WriterT} to a value wrapped in a {@code WriterT},
     * combining their outputs.
     *
     * @param ff The {@code WriterT} containing the function. Must not be null.
     * @param fa The {@code WriterT} containing the argument. Must not be null.
     * @param <A> The input type of the function.
     * @param <B> The output type of the function.
     * @return A new {@code WriterT} with the applied result and combined output.
     */
    @Override
    public <A, B> Kind<WriterTKind.Witness<F, W>, B> ap(Kind<WriterTKind.Witness<F, W>, ? extends Function<A, B>> ff, Kind<WriterTKind.Witness<F, W>, A> fa) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sequentially composes two {@code WriterT} computations, combining their outputs using the
     * {@link Monoid}.
     *
     * @param f The function to apply to the value of the first computation. Must not be null.
     * @param ma The first {@code WriterT} computation. Must not be null.
     * @param <A> The value type of the first computation.
     * @param <B> The value type of the second computation.
     * @return A new {@code WriterT} representing the composed computation.
     */
    @Override
    public <A, B> Kind<WriterTKind.Witness<F, W>, B> flatMap(Function<? super A, ? extends Kind<WriterTKind.Witness<F, W>, B>> f, Kind<WriterTKind.Witness<F, W>, A> ma) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- MonadWriter operations ---
    /**
     * Appends the given value to the accumulated output.
     *
     * @param w The output value to append. Must not be null.
     * @return A {@code Kind} containing {@link Unit#INSTANCE}.
     */
    @Override
    public Kind<WriterTKind.Witness<F, W>, Unit> tell(W w) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs a computation and returns its result paired with the accumulated output.
     *
     * @param ma The computation to listen to. Must not be null.
     * @param <A> The result type of the computation.
     * @return A {@code Kind} containing a {@link Pair} of the result and the accumulated output.
     */
    @Override
    public <A> Kind<WriterTKind.Witness<F, W>, Pair<A, W>> listen(Kind<WriterTKind.Witness<F, W>, A> ma) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Runs a computation that returns a pair of (value, output-transformer), and applies the function
     * to the accumulated output.
     *
     * @param ma The computation returning a pair of (value, output-transformer). Must not be null.
     * @param <A> The result type.
     * @return A {@code Kind} with the result value and the transformed output.
     */
    @Override
    public <A> Kind<WriterTKind.Witness<F, W>, A> pass(Kind<WriterTKind.Witness<F, W>, Pair<A, Function<W, W>>> ma) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
