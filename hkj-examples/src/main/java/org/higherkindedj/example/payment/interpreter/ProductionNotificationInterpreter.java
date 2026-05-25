// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.payment.interpreter;

import java.util.Objects;
import org.higherkindedj.example.payment.effect.NotificationOp;
import org.higherkindedj.example.payment.effect.NotificationOpInterpreter;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.io.IO;
import org.higherkindedj.hkt.io.IOKind;
import org.higherkindedj.hkt.io.IOKindHelper;
import org.jspecify.annotations.NullMarked;

/**
 * Production interpreter for notification operations.
 *
 * <p>Targets the {@code IO} monad. In a real system, this would send emails or push notifications.
 * This example simulates by printing to the console.
 */
@NullMarked
public final class ProductionNotificationInterpreter extends NotificationOpInterpreter<IOKind.Witness> {

    @Override
    protected <A> Kind<IOKind.Witness, A> handleSendReceipt(NotificationOp.SendReceipt<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <A> Kind<IOKind.Witness, A> handleAlertFraudTeam(NotificationOp.AlertFraudTeam<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
