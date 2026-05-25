// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.payment.interpreter;

import java.math.BigDecimal;
import java.util.Objects;
import org.higherkindedj.example.payment.effect.PaymentGatewayOp;
import org.higherkindedj.example.payment.effect.PaymentGatewayOpInterpreter;
import org.higherkindedj.example.payment.model.AuthorisationToken;
import org.higherkindedj.example.payment.model.ChargeResult;
import org.higherkindedj.example.payment.model.Money;
import org.higherkindedj.example.payment.model.TransactionId;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.id.IdKind;
import org.jspecify.annotations.NullMarked;

/**
 * Quote interpreter that estimates fees without actually charging.
 *
 * <p>Targets the {@code Id} monad. This interpreter calculates what a payment would cost (including
 * processing fees) without contacting any payment gateway or performing any side effects.
 */
@NullMarked
public final class QuoteGatewayInterpreter extends PaymentGatewayOpInterpreter<IdKind.Witness> {

    private static final BigDecimal FEE_RATE = new BigDecimal("0.029");

    private static final BigDecimal FIXED_FEE = new BigDecimal("0.30");

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
