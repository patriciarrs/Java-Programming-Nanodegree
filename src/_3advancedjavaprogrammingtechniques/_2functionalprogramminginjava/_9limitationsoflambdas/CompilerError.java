package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._9limitationsoflambdas;

/* Shortcomings of Lambdas:
- They can only be used to implement functional interfaces, not classes.
- Lambdas cannot implement any interface that has multiple abstract methods.
- Lambdas cannot throw checked exceptions (any subclass of Exception, such as IOException).
*/
public final class CompilerError {
    public static void main(String[] args) {
        // This code DOES NOT COMPILE because Files.readAllFiles can throw an IOException,
        // and lambdas are not allowed to throw checked exceptions!
        /*Stream.of("file-a.txt", "file-b.txt", "file-c.txt")
                .map(fileName -> Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8))
                .flatMap(Collection::stream)
                .forEach(System.out::println);*/
    }
}