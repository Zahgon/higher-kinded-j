// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.payment.interpreter;

import static org.higherkindedj.hkt.instances.Witnesses.*;
import java.util.Objects;
import org.higherkindedj.example.payment.effect.NotificationOp;
import org.higherkindedj.example.payment.effect.NotificationOpInterpreter;
import org.higherkindedj.example.payment.model.AuditLog;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monad;
import org.higherkindedj.hkt.Unit;
import org.higherkindedj.hkt.id.IdKind;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.hkt.writer_t.WriterT;
import org.higherkindedj.hkt.writer_t.WriterTKind;
import org.jspecify.annotations.NullMarked;

/**
 * Audit interpreter for notification operations.
 *
 * <p>Targets {@code WriterT<Id, AuditLog, A>}. Logs each notification without performing real side
 * effects.
 */
@NullMarked
public final class AuditNotificationInterpreter extends NotificationOpInterpreter<WriterTKind.Witness<IdKind.Witness, AuditLog>> {

    private static final Monad<IdKind.Witness> ID = Instances.monad(id());

    @Override
    protected <A> Kind<WriterTKind.Witness<IdKind.Witness, AuditLog>, A> handleSendReceipt(NotificationOp.SendReceipt<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <A> Kind<WriterTKind.Witness<IdKind.Witness, AuditLog>, A> handleAlertFraudTeam(NotificationOp.AlertFraudTeam<A> op) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
