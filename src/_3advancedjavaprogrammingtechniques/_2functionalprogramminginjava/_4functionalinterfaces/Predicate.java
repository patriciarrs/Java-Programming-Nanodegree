package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._4functionalinterfaces;

/* A functional interface is an interface with exactly one abstract method: the functional method.
 * Functional interfaces are allowed to have type parameters (like non-functional interfaces).
 * Here, Predicate has one type parameter T (the type being tested).
 * ***
 * If an interface describes a single operation, consider making it a functional interface.
 */

/* The @FunctionalInterface annotation serves 2 purposes:
 * If that annotation is added to any interface that is not a valid functional interface, the Java compiler will report a compilation error.
 * It tells whoever is reading the code that this is interface is designed to be used with lambdas.
 */
@FunctionalInterface
public interface Predicate<T> {
    /* Functional interfaces can have other default methods. */
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    /* Predicate's one abstract method: the functional method.
     * "Abstract" = the method is not implemented (it cannot have a default implementation).
     */
    boolean test(T t);

    // Other methods left out of this example
}