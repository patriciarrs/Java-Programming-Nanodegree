package _2javafundamentals._6genericsandcollections._7sortingcollections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StringSorting {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();

        strings.add("Zed");
        strings.add("Alice");
        strings.add("Mike");

        for (String string : strings) {
            System.out.println(string);
        }

        Collections.sort(strings);

        System.out.println("-Sorted-");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
