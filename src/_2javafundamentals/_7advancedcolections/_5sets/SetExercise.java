package _2javafundamentals._7advancedcolections._5sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * HashSet: uses a hash table to store elements, which provides constant-time performance for the basic operations, such as add, remove, and contain.
 * <p>
 * TreeSet: uses a tree structure to store elements, keeping the elements in sorted order.
 * This implementation provides efficient operations when adding, removing, and retrieving elements are done in sorted order.
 * <p>
 * LinkedHashSet: is similar to HashSet, but maintains a linked list of the elements in the order in which they were inserted.
 * This allows for iteration over the elements in insertion order.
 */
public class SetExercise {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();

        numbers.add("123-222-3333");
        numbers.add("223-222-3333");
        numbers.add("123-332-3333");
        numbers.add("123-222-4433");
        numbers.add("123-222-1133");
        numbers.add("123-222-3333");
        numbers.add("123-222-3333");
        numbers.add("123-232-4533");
        numbers.add("123-562-3333");
        numbers.add("123-000-3333");
        numbers.add("555-222-3333");
        numbers.add("444-222-3333");

        Set<String> uniqueNumbers = new HashSet<>(numbers);

        for (String number : uniqueNumbers) {
            System.out.println(number);
        }
    }
}
