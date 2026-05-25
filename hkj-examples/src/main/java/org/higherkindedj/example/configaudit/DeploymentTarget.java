// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.configaudit;

import org.higherkindedj.optics.Iso;

/**
 * A container for a structured deployment target. This is isomorphic to a raw string like
 * "gcp|live", and we provide an Iso to perform this conversion.
 */
public record DeploymentTarget(String platform, String environment) {

    /**
     * Defines a lossless, two-way conversion between this structured record and a simple raw string
     * representation. This is a classic use case for an Iso.
     */
    public static Iso<DeploymentTarget, String> toRawString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
