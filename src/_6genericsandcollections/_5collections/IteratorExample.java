package _6genericsandcollections._5collections;

import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();

        names.add("Mike");
        names.add("Bob");
        names.add("Alice");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Queue<String> strings = new ArrayDeque<>();

        strings.add("Sally");
        strings.add("Cesar");

        iterator = strings.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
