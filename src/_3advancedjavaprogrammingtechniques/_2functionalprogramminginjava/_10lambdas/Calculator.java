package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._10lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public final class Calculator {
    private final Map<String, BinaryOperator<Integer>> operatorToOperation = new HashMap<>();

    public void registerOperation(String symbol, BinaryOperator<Integer> operator) {
        operatorToOperation.put(symbol.strip(), operator);
    }

    public int calculate(int a, String operator, int b) {
        BinaryOperator<Integer> operation = operatorToOperation.get(operator);

        return operation.apply(a, b);
    }
}