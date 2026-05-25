// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.order.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.higherkindedj.example.order.error.OrderError;
import org.higherkindedj.example.order.model.Customer;
import org.higherkindedj.example.order.model.Customer.CustomerStatus;
import org.higherkindedj.example.order.model.Customer.LoyaltyTier;
import org.higherkindedj.example.order.model.value.CustomerId;
import org.higherkindedj.example.order.service.CustomerService;
import org.higherkindedj.hkt.either.Either;

/**
 * In-memory implementation of CustomerService for testing and examples.
 */
public class InMemoryCustomerService implements CustomerService {

    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    public InMemoryCustomerService() {
        // Pre-populate with sample customers
        addCustomer(new Customer(new CustomerId("CUST-001"), "Alice Smith", "alice@example.com", "+44 7700 900123", CustomerStatus.ACTIVE, LoyaltyTier.GOLD));
        addCustomer(new Customer(new CustomerId("CUST-002"), "Bob Jones", "bob@example.com", "+44 7700 900456", CustomerStatus.ACTIVE, LoyaltyTier.SILVER));
        addCustomer(new Customer(new CustomerId("CUST-003"), "Carol Williams", "carol@example.com", "+44 7700 900789", CustomerStatus.SUSPENDED, LoyaltyTier.BRONZE));
    }

    public void addCustomer(Customer customer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, Customer> findById(CustomerId customerId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Either<OrderError, Customer> validateEligibility(Customer customer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
