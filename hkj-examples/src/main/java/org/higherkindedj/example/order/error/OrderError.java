// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.error;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.higherkindedj.optics.annotations.GeneratePrisms;
import org.jspecify.annotations.Nullable;

/**
 * Sealed error hierarchy for the order workflow.
 *
 * <p>Using a sealed interface enables exhaustive pattern matching and generates prisms for
 * type-safe error handling.
 */
@GeneratePrisms
public sealed interface OrderError permits OrderError.ValidationError, OrderError.CustomerError, OrderError.InventoryError, OrderError.DiscountError, OrderError.PaymentError, OrderError.ShippingError, OrderError.NotificationError, OrderError.SystemError {

    /**
     * Error code for categorisation.
     *
     * @return the error code
     */
    String code();

    /**
     * Human-readable error message.
     *
     * @return the message
     */
    String message();

    /**
     * When the error occurred.
     *
     * @return the timestamp
     */
    Instant timestamp();

    /**
     * Additional context for debugging and logging.
     *
     * @return the context map
     */
    Map<String, Object> context();

    // -------------------------------------------------------------------------
    // Validation Errors
    // -------------------------------------------------------------------------
    /**
     * Validation errors from input data issues.
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param fieldErrors the individual field validation failures
     */
    record ValidationError(String code, String message, Instant timestamp, Map<String, Object> context, List<FieldError> fieldErrors) implements OrderError {

        /**
         * Creates a validation error with field errors.
         *
         * @param message the overall message
         * @param fieldErrors the field-level errors
         */
        public ValidationError(String message, List<FieldError> fieldErrors) {
            this("VALIDATION_ERROR", message, Instant.now(), Map.of(), fieldErrors);
        }

        /**
         * Creates a validation error for a single field.
         *
         * @param field the field name
         * @param message the error message
         * @return a ValidationError
         */
        public static ValidationError forField(String field, String message) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A single field validation error.
     *
     * @param field the field that failed validation
     * @param message the error message
     * @param rejectedValue the value that was rejected (may be null)
     */
    record FieldError(String field, String message, @Nullable Object rejectedValue) {
    }

    // -------------------------------------------------------------------------
    // Customer Errors
    // -------------------------------------------------------------------------
    /**
     * Customer lookup or validation errors.
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param customerId the customer ID involved
     */
    record CustomerError(String code, String message, Instant timestamp, Map<String, Object> context, String customerId) implements OrderError {

        /**
         * Creates an error for a customer not found.
         *
         * @param customerId the missing customer ID
         * @return a CustomerError
         */
        public static CustomerError notFound(String customerId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for a suspended customer.
         *
         * @param customerId the customer ID
         * @param reason the suspension reason
         * @return a CustomerError
         */
        public static CustomerError suspended(String customerId, String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // -------------------------------------------------------------------------
    // Inventory Errors
    // -------------------------------------------------------------------------
    /**
     * Inventory or stock errors.
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param unavailableProducts products that are unavailable
     */
    record InventoryError(String code, String message, Instant timestamp, Map<String, Object> context, List<String> unavailableProducts) implements OrderError {

        /**
         * Creates an error for out of stock products.
         *
         * @param productIds the unavailable product IDs
         * @return an InventoryError
         */
        public static InventoryError outOfStock(List<String> productIds) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for a failed reservation.
         *
         * @param reason the failure reason
         * @return an InventoryError
         */
        public static InventoryError reservationFailed(String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for partial stock availability.
         *
         * @param available the available quantity
         * @param requested the requested quantity
         * @param productId the product ID
         * @return an InventoryError
         */
        public static InventoryError partialStock(int available, int requested, String productId) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // -------------------------------------------------------------------------
    // Discount Errors
    // -------------------------------------------------------------------------
    /**
     * Discount or promo code errors.
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param promoCode the promo code involved, if any
     */
    record DiscountError(String code, String message, Instant timestamp, Map<String, Object> context, Optional<String> promoCode) implements OrderError {

        /**
         * Creates an error for an invalid promo code.
         *
         * @param code the invalid code
         * @return a DiscountError
         */
        public static DiscountError invalidCode(String code) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for an expired promo code.
         *
         * @param code the expired code
         * @return a DiscountError
         */
        public static DiscountError expired(String code) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // -------------------------------------------------------------------------
    // Payment Errors
    // -------------------------------------------------------------------------
    /**
     * Payment processing errors.
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param transactionId the transaction ID, if available
     */
    record PaymentError(String code, String message, Instant timestamp, Map<String, Object> context, Optional<String> transactionId) implements OrderError {

        /**
         * Creates an error for a declined payment.
         *
         * @param reason the decline reason
         * @return a PaymentError
         */
        public static PaymentError declined(String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for insufficient funds.
         *
         * @return a PaymentError
         */
        public static PaymentError insufficientFunds() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for a processing failure.
         *
         * @param transactionId the transaction ID, if available
         * @param cause the underlying cause
         * @return a PaymentError
         */
        public static PaymentError processingFailed(String transactionId, Throwable cause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // -------------------------------------------------------------------------
    // Shipping Errors
    // -------------------------------------------------------------------------
    /**
     * Shipping errors.
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param recoverable whether this error can be retried
     */
    record ShippingError(String code, String message, Instant timestamp, Map<String, Object> context, boolean recoverable) implements OrderError {

        /**
         * Creates an error for an invalid address.
         *
         * @param reason the validation failure reason
         * @return a ShippingError
         */
        public static ShippingError invalidAddress(String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for a temporary failure (can retry).
         *
         * @param reason the failure reason
         * @return a ShippingError
         */
        public static ShippingError temporaryFailure(String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error when no carrier is available.
         *
         * @return a ShippingError
         */
        public static ShippingError noCarrierAvailable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // -------------------------------------------------------------------------
    // Notification Errors
    // -------------------------------------------------------------------------
    /**
     * Notification errors (non-critical).
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     */
    record NotificationError(String code, String message, Instant timestamp, Map<String, Object> context) implements OrderError {

        /**
         * Creates an error for an email send failure.
         *
         * @param reason the failure reason
         * @return a NotificationError
         */
        public static NotificationError emailFailed(String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an error for an SMS send failure.
         *
         * @param reason the failure reason
         * @return a NotificationError
         */
        public static NotificationError smsFailed(String reason) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    // -------------------------------------------------------------------------
    // System Errors
    // -------------------------------------------------------------------------
    /**
     * System-level errors (infrastructure, configuration, etc.).
     *
     * @param code the error code
     * @param message the error message
     * @param timestamp when the error occurred
     * @param context additional context
     * @param cause the underlying exception, if any
     */
    record SystemError(String code, String message, Instant timestamp, Map<String, Object> context, Optional<Throwable> cause) implements OrderError {

        /**
         * Creates a system error from an exception.
         *
         * @param message the error message
         * @param cause the underlying cause
         * @return a SystemError
         */
        public static SystemError fromException(String message, Throwable cause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a timeout error.
         *
         * @param operation the operation that timed out
         * @return a SystemError
         */
        public static SystemError timeout(String operation) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a timeout error with duration.
         *
         * @param operation the operation that timed out
         * @param timeout the timeout duration
         * @return a SystemError
         */
        public static SystemError timeout(String operation, Duration timeout) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an unexpected error.
         *
         * @param message the error message
         * @param cause the underlying cause
         * @return a SystemError
         */
        public static SystemError unexpected(String message, Throwable cause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates a circuit breaker open error.
         *
         * @param service the service that is unavailable
         * @return a SystemError
         */
        public static SystemError circuitBreakerOpen(String service) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
