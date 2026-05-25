// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.example.optics.focus;

import java.util.Map;
import org.higherkindedj.hkt.either.Either;
import org.higherkindedj.optics.annotations.GenerateFocus;
import org.higherkindedj.optics.focus.FocusPath;

/**
 * Demonstrates fluent navigation using generated navigator classes.
 *
 * <p>This example shows how to use {@code @GenerateFocus(generateNavigators = true)} to enable
 * fluent cross-type navigation without explicit {@code .via()} calls.
 *
 * <h2>Key Concepts</h2>
 *
 * <ul>
 *   <li>Enabling navigator generation with {@code generateNavigators = true}
 *   <li>Fluent cross-type navigation: {@code CompanyFocus.headquarters().city()}
 *   <li>Navigator delegate methods: {@code get()}, {@code set()}, {@code modify()}
 *   <li>Controlling navigator generation with {@code maxNavigatorDepth}, {@code includeFields}, and
 *       {@code excludeFields}
 *   <li>Falling back to {@code .via()} for deeper navigation beyond the depth limit
 *   <li>Using {@code widenCollections = true} to auto-widen SPI ZERO_OR_MORE types
 *   <li>SPI generator priority for resolving conflicts between overlapping generators
 * </ul>
 *
 * <h2>Comparison: With vs Without Navigators</h2>
 *
 * <p><strong>Without navigators</strong> (explicit composition):
 *
 * <pre>{@code
 * String city = CompanyFocus.headquarters()
 *     .via(AddressFocus.city().toLens())
 *     .get(company);
 * }</pre>
 *
 * <p><strong>With navigators</strong> (fluent navigation):
 *
 * <pre>{@code
 * String city = CompanyFocus.headquarters().city().get(company);
 * }</pre>
 *
 * <p>Navigators are generated for fields whose types are also annotated with
 * {@code @GenerateFocus(generateNavigators = true)}.
 */
public class NavigatorExample {

    // ============= Domain Model with Navigators Enabled =============
    /**
     * A company with a headquarters address.
     *
     * <p>With {@code generateNavigators = true}, the processor generates a {@code
     * HeadquartersNavigator} inner class in {@code CompanyFocus} that enables fluent navigation to
     * {@code Address} fields.
     */
    @GenerateFocus(generateNavigators = true)
    public record Company(String name, Address headquarters, int employeeCount) {
    }

    /**
     * An address with street and city fields.
     *
     * <p>Both fields are navigable from parent types when navigators are enabled.
     */
    @GenerateFocus(generateNavigators = true)
    public record Address(String street, String city, String postcode) {
    }

    // ============= Domain Model with Depth Limiting =============
    /**
     * An organisation with nested department structure.
     *
     * <p>The {@code maxNavigatorDepth = 2} limits how deep navigator generation goes. At depth 2, the
     * navigation returns plain {@code FocusPath} instances instead of further navigators.
     */
    @GenerateFocus(generateNavigators = true, maxNavigatorDepth = 2)
    public record Organisation(String name, Division mainDivision) {
    }

    /**
     * A division containing a department.
     */
    @GenerateFocus(generateNavigators = true)
    public record Division(String name, Department department) {
    }

    /**
     * A department with a manager name.
     */
    @GenerateFocus(generateNavigators = true)
    public record Department(String name, String managerName) {
    }

    // ============= Domain Model with Field Filtering =============
    /**
     * A person with multiple addresses, demonstrating field filtering.
     *
     * <p>The {@code includeFields} attribute restricts navigator generation to only the specified
     * fields. Here, only {@code homeAddress} gets a navigator; {@code workAddress} uses standard
     * {@code FocusPath}.
     */
    @GenerateFocus(generateNavigators = true, includeFields = { "homeAddress" })
    public record Person(String name, Address homeAddress, Address workAddress) {
    }

    // ============= Domain Model with SPI-Aware Navigator Widening =============
    /**
     * A warehouse with inventory tracked as a Map and a location address.
     *
     * <p>The {@code inventory} field is a {@code Map<String, Integer>}, which the SPI recognises via
     * {@code MapValueGenerator} with {@code ZERO_OR_MORE} cardinality. Navigator methods for this
     * field will return {@code TraversalPath} instead of {@code FocusPath}.
     *
     * <p>The {@code verifiedName} field is an {@code Either<String, String>}, which the SPI
     * recognises via {@code EitherGenerator} with {@code ZERO_OR_ONE} cardinality. Navigator methods
     * for this field will return {@code AffinePath} instead of {@code FocusPath}.
     */
    @GenerateFocus(generateNavigators = true)
    public record Warehouse(String name, Map<String, Integer> inventory, Either<String, String> verifiedName, Address location) {
    }

    // ============= Domain Model with widenCollections =============
    /**
     * A shop with inventory tracked as a Map, demonstrating {@code widenCollections = true}.
     *
     * <p>By default, SPI-registered ZERO_OR_MORE container types (like {@code Map<K,V>}) produce
     * {@code FocusPath} in the generated Focus class. With {@code widenCollections = true}, they
     * automatically widen to {@code TraversalPath}, eliminating the need to manually call {@code
     * .each(eachInstance)}.
     *
     * <p>Compare:
     *
     * <ul>
     *   <li><b>Without</b> {@code widenCollections}: {@code ShopFocus.stock()} returns {@code
     *       FocusPath<Shop, Map<String, Integer>>} — requires manual {@code .each(mapValuesEach())}
     *   <li><b>With</b> {@code widenCollections}: {@code ShopWidenedFocus.stock()} returns {@code
     *       TraversalPath<ShopWidened, Integer>} — already widened
     * </ul>
     */
    @GenerateFocus
    public record Shop(String name, Map<String, Integer> stock) {
    }

    /**
     * Same as {@link Shop} but with {@code widenCollections = true}.
     */
    @GenerateFocus(widenCollections = true)
    public record ShopWidened(String name, Map<String, Integer> stock) {
    }

    // ============= Examples =============
    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates basic fluent navigation using generated navigators.
     *
     * <p>When the annotation processor runs on {@code Company} and {@code Address}, it generates
     * navigator classes that enable:
     *
     * <pre>{@code
     * CompanyFocus.headquarters().city()  // Returns FocusPath<Company, String>
     * }</pre>
     *
     * <p>Instead of:
     *
     * <pre>{@code
     * CompanyFocus.headquarters().via(AddressFocus.city().toLens())
     * }</pre>
     */
    static void basicNavigatorUsage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates navigator delegate methods.
     *
     * <p>Navigator classes delegate all {@code FocusPath} operations to the underlying path:
     *
     * <ul>
     *   <li>{@code get(source)} - Extract the focused value
     *   <li>{@code set(value, source)} - Replace the focused value
     *   <li>{@code modify(f, source)} - Transform the focused value
     *   <li>{@code toPath()} - Access the underlying {@code FocusPath}
     *   <li>{@code toLens()} - Extract the underlying {@code Lens}
     * </ul>
     */
    static void navigatorDelegateMethods() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates SPI-aware navigator path widening.
     *
     * <p>The {@code TraversableGenerator} SPI allows the processor to recognise container types
     * beyond the hardcoded {@code Optional}, {@code Maybe}, {@code List}, {@code Set}, and {@code
     * Collection}. Each SPI generator declares a {@code Cardinality}:
     *
     * <ul>
     *   <li>{@code ZERO_OR_ONE} (Either, Try, Validated) → navigator returns {@code AffinePath}
     *   <li>{@code ZERO_OR_MORE} (Map, arrays, third-party collections) → navigator returns {@code
     *       TraversalPath}
     * </ul>
     *
     * <p>This means navigators correctly handle SPI-registered types without falling back to {@code
     * FocusPath}:
     *
     * <pre>{@code
     * // Map<String, Integer> field → TraversalPath (via MapValueGenerator SPI)
     * WarehouseFocus.inventory()  // Returns TraversalPath<Warehouse, Integer>
     *
     * // Either<String, String> field → AffinePath (via EitherGenerator SPI)
     * WarehouseFocus.verifiedName()  // Returns AffinePath<Warehouse, String>
     * }</pre>
     */
    static void spiAwareNavigationExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates the {@code widenCollections} annotation attribute.
     *
     * <p>By default, SPI-registered ZERO_OR_MORE container types (like {@code Map<K,V>}) produce
     * {@code FocusPath} in the generated Focus class. Users must manually call {@code
     * .each(eachInstance)} to get a {@code TraversalPath}.
     *
     * <p>With {@code @GenerateFocus(widenCollections = true)}, the processor automatically applies
     * the SPI's optic expression, producing {@code TraversalPath} directly.
     *
     * <pre>{@code
     * // Without widenCollections (default):
     * FocusPath<Shop, Map<String, Integer>> stock = ShopFocus.stock();
     * TraversalPath<Shop, Integer> values = stock.each(EachInstances.mapValuesEach());
     *
     * // With widenCollections = true:
     * TraversalPath<ShopWidened, Integer> values = ShopWidenedFocus.stock();
     * }</pre>
     */
    static void widenCollectionsExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates the SPI priority system for resolving conflicts.
     *
     * <p>When multiple {@code TraversableGenerator} SPI providers support the same type, priority
     * determines which one wins. Higher values win; equal priorities emit a compile-time warning.
     *
     * <p>Priority constants:
     *
     * <ul>
     *   <li>{@code PRIORITY_FALLBACK} (-100) — catch-all generators
     *   <li>{@code PRIORITY_DEFAULT} (0) — standard generators (the default)
     *   <li>{@code PRIORITY_OVERRIDE} (100) — explicit overrides of built-in generators
     * </ul>
     *
     * <p>This system allows third-party libraries to provide custom generators that override or
     * coexist with built-in ones without conflicts.
     */
    static void spiPriorityExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates depth limiting with {@code maxNavigatorDepth}.
     *
     * <p>Navigator generation stops at the specified depth. Beyond this, navigation returns plain
     * {@code FocusPath} instances. For deeper access, use {@code .via()} composition.
     *
     * <pre>{@code
     * @GenerateFocus(generateNavigators = true, maxNavigatorDepth = 2)
     * record Organisation(Division mainDivision) {}
     *
     * // Depth 1: Returns MainDivisionNavigator (has nested navigators)
     * OrganisationFocus.mainDivision()
     *
     * // Depth 2: Returns DepartmentNavigator (delegate methods only, no deeper navigators)
     * OrganisationFocus.mainDivision().department()
     *
     * // Use .toPath() to access the underlying FocusPath for .via() composition
     * OrganisationFocus.mainDivision().department().toPath().via(DepartmentFocus.managerName().toLens())
     * }</pre>
     */
    static void depthLimitingExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Demonstrates field filtering with {@code includeFields} and {@code excludeFields}.
     *
     * <p>Control which fields get navigator generation:
     *
     * <ul>
     *   <li>{@code includeFields = {"field1", "field2"}} - Only these fields get navigators
     *   <li>{@code excludeFields = {"field3"}} - These fields use standard {@code FocusPath}
     * </ul>
     *
     * <p>If both are specified, {@code includeFields} takes precedence.
     *
     * <pre>{@code
     * @GenerateFocus(generateNavigators = true, includeFields = {"homeAddress"})
     * record Person(String name, Address homeAddress, Address workAddress) {}
     *
     * // homeAddress gets a navigator
     * PersonFocus.homeAddress().city()  // Returns FocusPath<Person, String>
     *
     * // workAddress uses standard FocusPath (no navigator)
     * PersonFocus.workAddress()  // Returns FocusPath<Person, Address>
     * PersonFocus.workAddress().via(AddressFocus.city().toLens())  // Explicit composition
     * }</pre>
     */
    static void fieldFilteringExample() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
