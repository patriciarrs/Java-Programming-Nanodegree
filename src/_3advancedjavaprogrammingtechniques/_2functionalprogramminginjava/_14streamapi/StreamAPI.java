package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._14streamapi;

import _2javafundamentals._4objectorientedprogramming._4inheritance.Student;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    void stream() {
        /* .collect(..) repackages the elements of the stream into some data structure or apply additional logic to them.
         * In this case, it's joining the String elements of the stream to create a new String.
         */
        Stream.of("hello", "world").map(String::toUpperCase).collect(Collectors.joining(" ", "", "!"));

        /* Streams are lazily evaluated, meaning no computation happens until the terminal operator is called.
         * So nothing is printed here.
         */
        Stream.of(1, 2, 3)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::print);
    }

    void collectors() {
        final ArrayList<String> stringList = new ArrayList<>();
        final ArrayList<Student> studentList = new ArrayList<>();

        // Here, the collector aggregates the elements into a Set
        Set<String> s = stringList.stream().collect(Collectors.toSet());

        /* groupingBy() is used to collect elements into a Map.
         * Collectors.counting() counts the number of values for each key,
         * so it will count how many students there are for each graduation year.
         */
        Map<Year, Long> graduatingClassSizes = studentList.stream()
                .collect(Collectors.groupingBy(
                        Student::getGraduationYear, Collectors.counting()));
    }
}
