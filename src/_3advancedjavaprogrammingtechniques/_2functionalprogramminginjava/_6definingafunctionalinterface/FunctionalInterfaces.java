package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._6definingafunctionalinterface;

import java.util.function.BinaryOperator;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        /* Binary operation refers to a method that takes two arguments. */
        BinaryOperation add = (a, b) -> a + b;

        /*
         * We can avoid creating a custom functional interface altogether:
         * use java.util.function.BinaryOperator with a type parameter of Integer.
         */
        BinaryOperator<Integer> add2 = (a, b) -> a + b;

        int sum = add.apply(2, 3);
        System.out.println(sum);
        assert 5 == sum;
    }
}
