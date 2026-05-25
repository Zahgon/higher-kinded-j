// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.bridge.external;

import java.util.Objects;
import java.util.Optional;

/**
 * An immutable ContactInfo value object following the Immutables library style.
 *
 * <p>This class simulates what the Immutables annotation processor generates from:
 *
 * <pre>{@code
 * @Value.Immutable
 * public interface ContactInfo {
 *     String email();
 *     String phone();
 *     Optional<String> fax();
 * }
 * }</pre>
 */
public final class ContactInfo {

    private final String email;

    private final String phone;

    private final Optional<String> fax;

    private ContactInfo(String email, String phone, Optional<String> fax) {
        this.email = Objects.requireNonNull(email, "email");
        this.phone = Objects.requireNonNull(phone, "phone");
        this.fax = Objects.requireNonNull(fax, "fax");
    }

    public String email() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String phone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> fax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ContactInfo withEmail(String email) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ContactInfo withPhone(String phone) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ContactInfo withFax(Optional<String> fax) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ContactInfo withFax(String fax) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder {

        private String email;

        private String phone;

        private Optional<String> fax = Optional.empty();

        public Builder email(String email) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder phone(String phone) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder fax(String fax) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder fax(Optional<String> fax) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ContactInfo build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
