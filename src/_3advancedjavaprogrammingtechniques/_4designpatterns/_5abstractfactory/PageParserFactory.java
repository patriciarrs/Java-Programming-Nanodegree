/*
package _3advancedjavaprogrammingtechniques._4designpatterns._5abstractfactory;

*/
/*
 * A factory is anything that creates objects.
 * Factories are useful for hiding construction details from callers.
 * - If the thing creating objects is a method, it's known as a factory method (e.g., Stream.of()).
 * - If the thing creating objects is also an object, it's known as an abstract factory.
 * These are useful when we want to separate construction of objects into a completely separate Java interface.
 *
 * When to Use Abstract Factories?
 * We want to hide construction details from callers.
 * We want to encapsulate construction of several related objects into a single Java interface.
 *//*


 */
/**
 * A factory interface that supplies instances of {@link PageParser} that have common parameters (such as the timeout
 * and ignored words) preset from injected values.
 *//*

public interface PageParserFactory {
    */
/* PageParserFactory is an interface, but it doesn't have to be.
 * Under the hood, the PageParserFactory creates pageParserImpl's,
 * but the clients are coding against the PageParser interface. *//*


 */
/**
 * Returns a {@link PageParser} that parses the given {@link url}.
 *//*

    PageParser get(String url);

    */
/*
 * All instantiations of PageParserImpl are managed by PageParserFactory.
 * Since the PageParserImpl is private to the package, clients can't instantiate it directly with the constructor.
 * They have to call PageParserFactory.get.
 *//*

}*/
