// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.spring.example.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.higherkindedj.hkt.Applicative;
import org.higherkindedj.hkt.Semigroups;
import org.higherkindedj.hkt.either.Either;
import org.higherkindedj.hkt.validated.Validated;
import org.higherkindedj.hkt.validated.ValidatedKind;
import org.higherkindedj.hkt.validated.ValidatedKindHelper;
import org.higherkindedj.hkt.validated.ValidatedMonad;
import org.higherkindedj.spring.example.domain.DomainError;
import org.higherkindedj.spring.example.domain.User;
import org.higherkindedj.spring.example.domain.UserNotFoundError;
import org.higherkindedj.spring.example.domain.ValidationError;
import org.springframework.stereotype.Service;

/**
 * User service demonstrating Either-based error handling. All methods return {@code
 * Either<DomainError, T>} instead of throwing exceptions.
 */
@Service
public class UserService {

    // In-memory "database" for the example
    private final Map<String, User> users = new ConcurrentHashMap<>();

    /**
     * Creates a new user service with pre-populated test data.
     */
    public UserService() {
        // Pre-populate with some test users
        users.put("1", new User("1", "alice@example.com", "Alice", "Smith"));
        users.put("2", new User("2", "bob@example.com", "Bob", "Johnson"));
        users.put("3", new User("3", "charlie@example.com", "Charlie", "Brown"));
    }

    /**
     * Find a user by ID.
     *
     * @param id the user ID
     * @return Either a UserNotFoundError (Left) or the User (Right)
     */
    public Either<DomainError, User> findById(String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Get all users.
     *
     * @return Either an error or the list of all users
     */
    public Either<DomainError, List<User>> findAll() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Find user by email.
     *
     * @param email the email to search for
     * @return Either a UserNotFoundError (Left) or the User (Right)
     */
    public Either<DomainError, User> findByEmail(String email) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a new user with validation.
     *
     * @param email the email
     * @param firstName the first name
     * @param lastName the last name
     * @return Either a ValidationError (Left) or the created User (Right)
     */
    public Either<DomainError, User> create(String email, String firstName, String lastName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Validate email format.
     *
     * @param email the email to validate
     * @return Valid(email) or Invalid(ValidationError)
     */
    private Validated<List<ValidationError>, String> validateEmail(String email) {
        if (email == null || !email.contains("@")) {
            return Validated.invalid(List.of(new ValidationError("email", "Invalid email format")));
        }
        return Validated.valid(email);
    }

    /**
     * Validate first name is not empty.
     *
     * @param firstName the first name to validate
     * @return Valid(firstName) or Invalid(ValidationError)
     */
    private Validated<List<ValidationError>, String> validateFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            return Validated.invalid(List.of(new ValidationError("firstName", "First name cannot be empty")));
        }
        return Validated.valid(firstName);
    }

    /**
     * Validate last name is not empty.
     *
     * @param lastName the last name to validate
     * @return Valid(lastName) or Invalid(ValidationError)
     */
    private Validated<List<ValidationError>, String> validateLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return Validated.invalid(List.of(new ValidationError("lastName", "Last name cannot be empty")));
        }
        return Validated.valid(lastName);
    }

    /**
     * Create a new user with accumulating validation. Unlike the Either-based create() method which
     * fails fast, this method accumulates ALL validation errors and returns them together.
     *
     * @param email the email
     * @param firstName the first name
     * @param lastName the last name
     * @return Validated with all errors accumulated, or the created User
     */
    public Validated<List<ValidationError>, User> validateAndCreate(String email, String firstName, String lastName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
