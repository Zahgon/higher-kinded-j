// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.payment.interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.higherkindedj.example.payment.effect.PaymentGatewayOp;
import org.higherkindedj.example.payment.effect.PaymentGatewayOpInterpreter;
import org.higherkindedj.example.payment.model.AuthorisationToken;
import org.higherkindedj.example.payment.model.ChargeResult;
import org.higherkindedj.example.payment.model.TransactionId;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.id.IdKind;
import org.jspecify.annotations.NullMarked;

/**
 * Test interpreter that records all gateway operations and returns deterministic results.
 *
 * <p>Targets the {@code Id} monad for pure, synchronous testing. All operations are recorded and
 * can be inspected after interpretation to verify program behaviour.
 *
 * <p><b>Not thread-safe.</b> Create a fresh instance per program invocation. Do not share across
 * concurrent interpretations.
 */
@NullMarked
public final class RecordingGatewayInterpreter extends PaymentGatewayOpInterpreter<IdKind.Witness> {

    private final List<String> calls = new ArrayList<>();

    /**
     * Returns an unmodifiable view of the recorded operation names.
     *
     * @return the list of recorded calls
     */
    public List<String> calls() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <A> Kind<IdKind.Witness, A> handleAuthorise(PaymentGatewayOp.Authorise<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <A> Kind<IdKind.Witness, A> handleCharge(PaymentGatewayOp.Charge<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <A> Kind<IdKind.Witness, A> handleRefund(PaymentGatewayOp.Refund<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
