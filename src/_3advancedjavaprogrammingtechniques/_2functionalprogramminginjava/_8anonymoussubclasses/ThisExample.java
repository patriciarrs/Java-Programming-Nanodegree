package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._8anonymoussubclasses;

/* An anonymous class is a class that is defined "in-line" and has no name.
 * - Class generated at compile-time
 * - Can override equals()/hashCode()
 * - "this" refers to the anonymous class
 * ***
 * Lambdas
 * - Class generated at runtime
 * - Cannot override equals()/hashCode(); has no identity
 * - "this" refers to the enclosing class
 */
public final class ThisExample {
    /* Returns the class object representing ThisExample.
     * The "this" keyword inside the lambda references the enclosing class (ThisExample).
     */
    private final Runnable withLambda =
            () -> System.out.println("From lambda: " + this.getClass());

    /* The Java compiler generates a class called ThisExample$1 for the anonymous class.
     * The "this" keyword refers to that generated class.
     */
    private final Runnable withSubclass = new Runnable() {
        @Override
        public void run() {
            System.out.println("From subclass: " + this.getClass());
        }
    };

    public static void main(String[] args) {
        ThisExample thisExample = new ThisExample();

        thisExample.withLambda.run(); // class ThisExample
        thisExample.withSubclass.run(); // class ThisExample$1
    }
}