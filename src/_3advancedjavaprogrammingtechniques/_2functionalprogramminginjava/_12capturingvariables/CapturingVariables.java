package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._12capturingvariables;

import _2javafundamentals._4objectorientedprogramming._4inheritance.Student;

import java.io.StringWriter;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/* If a lambda uses any variables from the surrounding code, those variables become captured variables.
 * Variables can only be captured if they are effectively final.
 * Effectively final variable: a variable whose value does not change after it is initialized.
 */
public class CapturingVariables {

    Map<Year, Integer> getClassSizes(List<Student> students) {
        /*
         * If the code still compiles, when adding the final keyword to a variable, it is effectively final
         * Objects are passed by reference: even though the HashMap changes,
         * the variable's value is the HashMap's location in memory, and that location never changes.
         */
        final Map<Year, Integer> classSizes = new HashMap<>();

        students.stream().forEach(s ->
                classSizes.compute(
                        s.getGraduationYear(),
                        (k, v) -> (v == null) ? 1 : 1 + v));
        return classSizes;
    }

    // The bySize variable is initialized outside the lambda, and then captured for use inside the lambda
    void printResult(List<String> input, StringWriter output) {
        Map<Integer, String> bySize = new HashMap<>();

        input.stream().forEach(
                (String s) -> bySize.put(s.length(), s));

        output.write(generateSummary(bySize));
    }

    private int generateSummary(Map<Integer, String> bySize) {
        return 0;
    }

    void runnables() {
        /* This code will not compile because "i" is not effectively final.
         * Even though the value of ""i" does not change inside the lambda,
         * the value changes (i++) each time the loop iterates.
         */
        /*List<Runnable> runnables = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            runnables.add(() -> System.out.println(i));
        }*/

        // One way to get around this would be to use an IntStream
        List<Runnable> runnables =
                IntStream.range(1, 10)
                        .mapToObj(i -> (Runnable) () -> System.out.println(i))
                        .toList();
    }
}
