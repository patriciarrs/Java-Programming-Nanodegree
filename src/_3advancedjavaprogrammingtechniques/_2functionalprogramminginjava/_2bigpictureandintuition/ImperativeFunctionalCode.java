package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._2bigpictureandintuition;

import _2javafundamentals._4objectorientedprogramming._4inheritance.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImperativeFunctionalCode {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        int imperativeTopScore = imperativeGetTopScore(students);
        int functionalTopScore = functionalGetTopScore(students);
    }

    /* Focuses on how a task is performed.
     * Each line of code gives a specific procedure or operation.
     */
    static int imperativeGetTopScore(List<Student> students) {
        int topScore = 0;
        for (Student s : students) {
            if (s == null) continue;
            topScore = Math.max(topScore, s.getScore());
        }
        return topScore;
    }

    /* Focuses on what happens to inputs in order to produce outputs.
     * Describes how to transform the input into the output.
     */
    static int functionalGetTopScore(List<Student> students) {
        return students.stream()
                .filter(Objects::nonNull)
                .mapToInt(Student::getScore)
                .max()
                .orElse(0);
    }
}
