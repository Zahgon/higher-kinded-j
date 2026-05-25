// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.market.feed;

import java.util.List;
import java.util.Objects;
import org.higherkindedj.example.market.model.PriceTick;
import org.higherkindedj.hkt.vstream.VStream;
import org.higherkindedj.hkt.vstream.VStreamPar;

/**
 * Merges price tick streams from multiple exchanges into a single unified stream.
 *
 * <p><b>HKJ features demonstrated:</b>
 *
 * <ul>
 *   <li>{@link VStreamPar#merge(List)} - Concurrent stream merging with virtual threads
 * </ul>
 *
 * <p>Each exchange feed runs on its own virtual thread. Elements are emitted as soon as any
 * exchange produces a tick, providing true real-time interleaving.
 */
public interface FeedMerger {

    /**
     * Merges multiple exchange feeds into a single stream.
     *
     * @param feeds the exchange feeds to merge
     * @return a single VStream containing ticks from all feeds, interleaved by arrival order
     */
    static VStream<PriceTick> merge(List<ExchangeFeed> feeds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Merges two exchange feeds.
     *
     * @param first the first feed
     * @param second the second feed
     * @return a merged stream
     */
    static VStream<PriceTick> merge(ExchangeFeed first, ExchangeFeed second) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
