package _6genericsandcollections._7sortingcollections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WrapperSorting {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();

        numbers.add(201);
        numbers.add(100);
        numbers.add(101);

        for (Integer number : numbers) {
            System.out.println(number);
        }

        Collections.sort(numbers);

        System.out.println("-Sorted-");

        for (Integer string : numbers) {
            System.out.println(string);
        }
    }
}
