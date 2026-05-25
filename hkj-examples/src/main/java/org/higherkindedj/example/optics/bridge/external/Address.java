// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.bridge.external;

import java.util.Objects;

/**
 * An immutable Address value object following the Immutables library style.
 *
 * <p>This class simulates what the Immutables annotation processor generates from:
 *
 * <pre>{@code
 * @Value.Immutable
 * public interface Address {
 *     String street();
 *     String city();
 *     String postcode();
 *     String country();
 * }
 * }</pre>
 *
 * <p>Key patterns:
 *
 * <ul>
 *   <li>Accessor methods (no "get" prefix)
 *   <li>Wither methods for creating modified copies
 *   <li>Builder for construction
 * </ul>
 */
public final class Address {

    private final String street;

    private final String city;

    private final String postcode;

    private final String country;

    private Address(String street, String city, String postcode, String country) {
        this.street = Objects.requireNonNull(street, "street");
        this.city = Objects.requireNonNull(city, "city");
        this.postcode = Objects.requireNonNull(postcode, "postcode");
        this.country = Objects.requireNonNull(country, "country");
    }

    // Accessor methods (Immutables style - no "get" prefix)
    public String street() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String city() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String postcode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String country() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Wither methods - return new instance with one field changed
    public Address withStreet(String street) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Address withCity(String city) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Address withPostcode(String postcode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Address withCountry(String country) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Builder pattern
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

        private String street;

        private String city;

        private String postcode;

        private String country;

        public Builder street(String street) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder city(String city) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder postcode(String postcode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder country(String country) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Address build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
