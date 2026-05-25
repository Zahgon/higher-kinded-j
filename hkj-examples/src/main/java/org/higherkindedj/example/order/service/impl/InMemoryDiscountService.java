// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.higherkindedj.example.order.error.OrderError;
import org.higherkindedj.example.order.model.Customer;
import org.higherkindedj.example.order.model.DiscountResult;
import org.higherkindedj.example.order.model.value.Money;
import org.higherkindedj.example.order.model.value.Percentage;
import org.higherkindedj.example.order.model.value.PromoCode;
import org.higherkindedj.example.order.service.DiscountService;
import org.higherkindedj.hkt.either.Either;

/**
 * In-memory implementation of DiscountService for testing and examples.
 */
public class InMemoryDiscountService implements DiscountService {

    private final Map<String, PromoCode> validCodes = new ConcurrentHashMap<>();

    public InMemoryDiscountService() {
        // Pre-populate with sample promo codes
        validCodes.put("SAVE10", new PromoCode("SAVE10", Percentage.of(10)));
        validCodes.put("SAVE20", new PromoCode("SAVE20", Percentage.of(20)));
        validCodes.put("HALFPRICE", new PromoCode("HALFPRICE", Percentage.of(50)));
    }

    public void addPromoCode(PromoCode code) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, PromoCode> validatePromoCode(String code) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, DiscountResult> calculateLoyaltyDiscount(Customer customer, Money subtotal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, DiscountResult> applyPromoCode(PromoCode promoCode, Money subtotal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, DiscountResult> selectBestDiscount(DiscountResult... discounts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
