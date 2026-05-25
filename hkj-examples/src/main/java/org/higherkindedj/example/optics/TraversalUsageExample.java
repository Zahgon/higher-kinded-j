// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics;

import static org.higherkindedj.hkt.id.IdKindHelper.ID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.Monoids;
import org.higherkindedj.hkt.id.Id;
import org.higherkindedj.hkt.id.IdKind;
import org.higherkindedj.hkt.id.IdSelective;
import org.higherkindedj.optics.Fold;
import org.higherkindedj.optics.Traversal;
import org.higherkindedj.optics.annotations.GenerateLenses;
import org.higherkindedj.optics.annotations.GenerateTraversals;
import org.higherkindedj.optics.util.Traversals;

/**
 * A runnable example demonstrating how to use and compose Traversals to perform bulk updates on
 * items within nested collections.
 */
public class TraversalUsageExample {

    @GenerateLenses
    public record Player(String name, int score) {
    }

    @GenerateLenses
    @GenerateTraversals
    public record Team(String name, List<Player> players) {
    }

    @GenerateLenses
    @GenerateTraversals
    public record League(String name, List<Team> teams) {
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --- SCENARIO: Converting Traversal to Fold for Read-Only Queries ---
    private static void asFoldAggregation() {
        System.out.println("--- Scenario 7: Traversal.asFold() for Aggregation ---");
        var team1 = new Team("Team Alpha", List.of(new Player("Alice", 100), new Player("Bob", 90)));
        var team2 = new Team("Team Bravo", List.of(new Player("Charlie", 110), new Player("Diana", 120)));
        var league = new League("Pro League", List.of(team1, team2));
        // Build a traversal for all player scores
        Traversal<League, Integer> scoreTraversal = LeagueTraversals.teams().andThen(TeamTraversals.players()).andThen(PlayerLenses.score().asTraversal());
        // Convert to Fold when you only need read-only queries
        Fold<League, Integer> scoreFold = scoreTraversal.asFold();
        // Now use the full Fold API for aggregation and queries
        int totalScore = scoreFold.foldMap(Monoids.integerAddition(), s -> s, league);
        System.out.println("Total score across all players: " + totalScore);
        int playerCount = scoreFold.length(league);
        System.out.println("Number of players: " + playerCount);
        Optional<Integer> topScore = scoreFold.preview(league);
        System.out.println("First score: " + topScore.orElse(0));
        boolean allAbove50 = scoreFold.all(s -> s > 50, league);
        System.out.println("All scores above 50: " + allAbove50);
        boolean anyAbove115 = scoreFold.exists(s -> s > 115, league);
        System.out.println("Any score above 115: " + anyAbove115);
        // Compose further: asFold() on a filtered traversal
        Fold<League, Integer> highScoreFold = scoreTraversal.filtered(s -> s >= 110).asFold();
        List<Integer> highScores = highScoreFold.getAll(league);
        System.out.println("High scores (>= 110): " + highScores);
        System.out.println();
    }

    // --- SCENARIO: Selective Conditional Updates ---
    private static void selectiveConditionalUpdate() {
        System.out.println("--- Scenario 8: Selective Conditional Updates ---");
        var team1 = new Team("Team Alpha", List.of(new Player("Alice", 150), new Player("Bob", 90), new Player("Charlie", 110)));
        var team2 = new Team("Team Bravo", List.of(new Player("Diana", 200), new Player("Eve", 80)));
        var league = new League("Pro League", List.of(team1, team2));
        Traversal<League, Integer> leagueToAllPlayerScores = LeagueTraversals.teams().andThen(TeamTraversals.players()).andThen(PlayerLenses.score().asTraversal());
        // Only give bonus to high scorers (>= 100)
        Predicate<Integer> isHighScorer = score -> score >= 100;
        Kind<IdKind.Witness, League> updated = leagueToAllPlayerScores.modifyWhen(isHighScorer, // 50 point bonus
        score -> Id.of(score + 50), league, IdSelective.instance());
        System.out.println("Original league:");
        printLeagueScores(league);
        System.out.println("\nAfter selective bonus (only >= 100):");
        printLeagueScores(ID.narrow(updated).value());
        System.out.println();
    }

    // --- SCENARIO: Selective Branching ---
    private static void selectiveBranchingUpdate() {
        System.out.println("--- Scenario 9: Selective Branching Updates ---");
        var team = new Team("Mixed Team", List.of(new Player("Veteran", 180), new Player("Rookie", 50), new Player("MidLevel", 100), new Player("Expert", 250)));
        var league = new League("Diverse League", List.of(team));
        Traversal<League, Integer> scoreTraversal = LeagueTraversals.teams().andThen(TeamTraversals.players()).andThen(PlayerLenses.score().asTraversal());
        // Different bonuses for different score ranges
        Predicate<Integer> isExpert = score -> score >= 200;
        Kind<IdKind.Witness, League> updated = scoreTraversal.branch(isExpert, // Expert bonus: +100
        score -> Id.of(score + 100), // Regular bonus: +20
        score -> Id.of(score + 20), league, IdSelective.instance());
        System.out.println("Original scores:");
        printLeagueScores(league);
        System.out.println("\nAfter branching bonuses (experts +100, others +20):");
        printLeagueScores(ID.narrow(updated).value());
        System.out.println();
    }

    private static void printLeagueScores(League league) {
        league.teams().forEach(team -> {
            System.out.println("  " + team.name() + ":");
            team.players().forEach(player -> System.out.println("    " + player.name() + ": " + player.score()));
        });
    }
}
