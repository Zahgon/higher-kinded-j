// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.importoptics;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.higherkindedj.example.optics.importoptics.external.BankTransfer;
import org.higherkindedj.example.optics.importoptics.external.CreditCard;
import org.higherkindedj.example.optics.importoptics.external.DigitalWallet;
import org.higherkindedj.example.optics.importoptics.external.OrderStatus;
import org.higherkindedj.example.optics.importoptics.external.PaymentMethod;
import org.higherkindedj.optics.Prism;

/**
 * A runnable example demonstrating how to use {@code @ImportOptics} to generate prisms for external
 * sealed interfaces and enums.
 *
 * <p>This example shows that sealed interfaces and enums from external libraries can have prisms
 * generated via the {@code @ImportOptics} annotation. It demonstrates:
 *
 * <ul>
 *   <li>JDK enums: {@link DayOfWeek}, {@link Month}, {@link TimeUnit}
 *   <li>Custom sealed interfaces: PaymentMethod
 *   <li>Custom enums: OrderStatus
 * </ul>
 */
public class ImportOpticsSealedExample {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates using prisms generated for JDK enums.
     *
     * <p>This shows that @ImportOptics works with real external types from the Java standard library,
     * not just custom types.
     */
    private static void demonstrateJdkEnums() {
        System.out.println("--- JDK Enum Prisms (Real External Types) ---\n");
        // 1. DayOfWeek prisms - useful for scheduling logic
        Prism<DayOfWeek, DayOfWeek> mondayPrism = DayOfWeekPrisms.monday();
        Prism<DayOfWeek, DayOfWeek> saturdayPrism = DayOfWeekPrisms.saturday();
        Prism<DayOfWeek, DayOfWeek> sundayPrism = DayOfWeekPrisms.sunday();
        DayOfWeek today = DayOfWeek.SATURDAY;
        boolean isWeekend = saturdayPrism.getOptional(today).isPresent() || sundayPrism.getOptional(today).isPresent();
        System.out.println("Is " + today + " a weekend? " + isWeekend);
        // Count weekdays in a schedule
        DayOfWeek[] schedule = { DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY };
        long mondayCount = Arrays.stream(schedule).filter(d -> mondayPrism.getOptional(d).isPresent()).count();
        System.out.println("Mondays in schedule: " + mondayCount);
        System.out.println();
        // 2. Month prisms - useful for seasonal logic
        Prism<Month, Month> januaryPrism = MonthPrisms.january();
        Prism<Month, Month> decemberPrism = MonthPrisms.december();
        Prism<Month, Month> julyPrism = MonthPrisms.july();
        Month currentMonth = Month.DECEMBER;
        boolean isYearEnd = decemberPrism.getOptional(currentMonth).isPresent();
        boolean isYearStart = januaryPrism.getOptional(currentMonth).isPresent();
        System.out.println("Is " + currentMonth + " year-end? " + isYearEnd);
        System.out.println("Is " + currentMonth + " year-start? " + isYearStart);
        // Find summer months
        Month[] fiscalYear = { Month.APRIL, Month.MAY, Month.JUNE, Month.JULY, Month.AUGUST };
        boolean hasSummerPeak = Arrays.stream(fiscalYear).anyMatch(m -> julyPrism.getOptional(m).isPresent());
        System.out.println("Fiscal year includes July (summer peak)? " + hasSummerPeak);
        System.out.println();
        // 3. TimeUnit prisms - useful for duration handling
        Prism<TimeUnit, TimeUnit> millisPrism = TimeUnitPrisms.milliseconds();
        Prism<TimeUnit, TimeUnit> secondsPrism = TimeUnitPrisms.seconds();
        Prism<TimeUnit, TimeUnit> daysPrism = TimeUnitPrisms.days();
        TimeUnit unit = TimeUnit.SECONDS;
        boolean isSmallUnit = millisPrism.getOptional(unit).isPresent() || secondsPrism.getOptional(unit).isPresent();
        System.out.println("Is " + unit + " a small time unit? " + isSmallUnit);
        // Check if a timeout unit is appropriate for human interaction
        TimeUnit[] timeoutUnits = { TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES };
        boolean hasDayTimeout = Arrays.stream(timeoutUnits).anyMatch(u -> daysPrism.getOptional(u).isPresent());
        System.out.println("Any day-level timeouts? " + hasDayTimeout + " (good for UX!)");
        System.out.println();
    }

    /**
     * Describes a payment method using prisms for type-safe pattern matching.
     *
     * @param payment the payment method to describe
     * @return a description of the payment method
     */
    private static String describePayment(PaymentMethod payment) {
        Prism<PaymentMethod, CreditCard> ccPrism = PaymentMethodPrisms.creditCard();
        Prism<PaymentMethod, BankTransfer> btPrism = PaymentMethodPrisms.bankTransfer();
        Prism<PaymentMethod, DigitalWallet> dwPrism = PaymentMethodPrisms.digitalWallet();
        return ccPrism.getOptional(payment).map(cc -> "Credit Card ending in " + cc.cardNumber().substring(cc.cardNumber().length() - 4)).or(() -> btPrism.getOptional(payment).map(bt -> "Bank Transfer to account " + bt.accountNumber())).or(() -> dwPrism.getOptional(payment).map(dw -> dw.provider() + " wallet (" + dw.accountEmail() + ")")).orElse("Unknown payment method");
    }
}
