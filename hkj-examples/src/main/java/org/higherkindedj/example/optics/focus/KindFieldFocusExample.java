// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.focus;

import java.util.List;
import org.higherkindedj.hkt.Kind;
import org.higherkindedj.hkt.list.ListKind;
import org.higherkindedj.hkt.list.ListKindHelper;
import org.higherkindedj.hkt.maybe.Maybe;
import org.higherkindedj.hkt.maybe.MaybeKind;
import org.higherkindedj.hkt.maybe.MaybeKindHelper;
import org.higherkindedj.optics.annotations.GenerateFocus;

/**
 * Demonstrates automatic Kind field support in the Focus DSL annotation processor.
 *
 * <p>This example shows how the {@code @GenerateFocus} annotation automatically generates
 * appropriate traversal code for {@code Kind<F, A>} fields, eliminating the need for manual {@code
 * traverseOver()} calls.
 *
 * <h2>Key Concepts</h2>
 *
 * <ul>
 *   <li>Automatic detection of {@code Kind<ListKind.Witness, A>} → {@code TraversalPath}
 *   <li>Automatic detection of {@code Kind<MaybeKind.Witness, A>} → {@code AffinePath}
 *   <li>Seamless composition with other fields via the Focus DSL
 *   <li>Type-safe navigation through HKT-wrapped collections
 * </ul>
 *
 * <h2>Generated Code</h2>
 *
 * <p>For the {@code Team} record below, the processor generates:
 *
 * <pre>{@code
 * public final class TeamFocus {
 *     public static FocusPath<Team, String> name() { ... }
 *
 *     public static TraversalPath<Team, Member> members() {
 *         return FocusPath.of(...)
 *             .<ListKind.Witness, Member>traverseOver(ListTraverse.INSTANCE);
 *     }
 * }
 * }</pre>
 *
 * @see org.higherkindedj.optics.annotations.GenerateFocus
 * @see org.higherkindedj.optics.annotations.TraverseField
 */
public class KindFieldFocusExample {

    // ============= Domain Model with Kind Fields =============
    /**
     * A skill with a name and proficiency level.
     */
    public record Skill(String name, int proficiency) {

        /**
         * Creates a skill with increased proficiency.
         */
        public Skill improve() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A team member with Kind-wrapped skills.
     *
     * <p>The {@code skills} field uses {@code Kind<ListKind.Witness, Skill>} to demonstrate
     * HKT-wrapped collection support. The generated Focus class will automatically include {@code
     * traverseOver()} for this field.
     */
    @GenerateFocus
    public record Member(String name, Kind<ListKind.Witness, Skill> skills) {
    }

    /**
     * A team with Kind-wrapped members and an optional lead member.
     *
     * <p>This record demonstrates both:
     *
     * <ul>
     *   <li>{@code Kind<ListKind.Witness, Member>} → TraversalPath (zero-or-more)
     *   <li>{@code Kind<MaybeKind.Witness, Member>} → AffinePath (zero-or-one)
     * </ul>
     */
    @GenerateFocus
    public record Team(String name, Kind<MaybeKind.Witness, Member> lead, Kind<ListKind.Witness, Member> members) {
    }

    /**
     * A project with Kind-wrapped teams.
     *
     * <p>Demonstrates nested Kind field navigation.
     */
    @GenerateFocus
    public record Project(String name, Kind<ListKind.Witness, Team> teams) {
    }

    // ============= Example Usage =============
    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates basic Kind<ListKind.Witness, A> field navigation.
     */
    static void basicKindFieldExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates Kind<MaybeKind.Witness, A> field navigation.
     */
    static void optionalKindFieldExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates nested Kind field navigation.
     */
    static void nestedKindFieldExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
