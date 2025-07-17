package _6genericsandcollections._5collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        ArrayList<String> listOfItems = new ArrayList<>();

        listOfItems.add("Mike");
        listOfItems.add("Bob");
        listOfItems.add("Alice");

        for (String item : listOfItems) {
            System.out.println(item);
        }
    }
}
