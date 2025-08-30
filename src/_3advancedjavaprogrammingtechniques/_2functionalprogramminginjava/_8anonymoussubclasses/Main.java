package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._8anonymoussubclasses;

public final class Main {
    /* Inside a lambda, the "this" keyword only means anything if there is an enclosing class.
     * In this code, the lambda is defined inside a static function, so there is no enclosing class.
     */
    public static void main(String[] args) {
        /*Runnable r = () -> System.out.println(this.getClass());
        r.run();*/
    }
}