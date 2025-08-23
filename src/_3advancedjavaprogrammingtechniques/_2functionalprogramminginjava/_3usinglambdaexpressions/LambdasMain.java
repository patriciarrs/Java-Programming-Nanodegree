package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._3usinglambdaexpressions;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/* Key Terms:
 * Lambda expression: An expression that can be used to succinctly implement functional interfaces.
 * Predicate: A function that takes one argument and returns a boolean.
 * ***
 * Predicate<T> is an interface for predicate functions that take an argument of type T.
 * It is common for lambdas to implement predicates to process a collection of objects.
 */
public final class LambdasMain {
    public static void main(String[] args) {

        List<String> input = List.of("hello", "\t   ", "world", "", "\t", " ", "goodbye", "  ");

        long numberOfWhitespaceStrings =
                countMatchingStrings(input, s -> s.trim().isEmpty());

        System.out.println(numberOfWhitespaceStrings + " whitespace strings");

        /* BinaryOperator is a functional interface that defines a single operation between two integers. */
        BinaryOperator<Integer> add =
                (Integer a, Integer b) -> a + b;

        System.out.println(add.apply(1, 2));
    }

    /**
     * Returns the number of strings that match a given condition.
     *
     * @param input     the strings that should be tested.
     * @param condition the condition that strings should be tested against.
     * @return the number of strings in the input that match the condition.
     */
    public static long countMatchingStrings(List<String> input, Predicate<String> condition) {
        return input.stream().filter(condition).count();
    }
}