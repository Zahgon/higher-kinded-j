// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.traversal.map;

import static org.higherkindedj.hkt.id.IdKindHelper.ID;
import static org.higherkindedj.hkt.instances.Witnesses.*;
import java.util.Map;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.instances.Instances;
import org.higherkindedj.optics.annotations.GenerateTraversals;

/**
 * A runnable example demonstrating how to traverse the values of a {@link Map}.
 */
public class MapValueTraversalExample {

    /**
     * A record holding a map of feature toggles. {@code @GenerateTraversals} will generate a
     * Traversal over the map's values.
     */
    @GenerateTraversals
    public record FeatureToggles(String environment, Map<String, Boolean> flags) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
