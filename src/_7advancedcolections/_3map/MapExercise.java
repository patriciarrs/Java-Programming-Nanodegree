package _7advancedcolections._3map;

import java.util.HashMap;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args) {
        // Create a HashMap with String keys and Person values
        Map<String, Person> mapOfPeople = new HashMap<String, Person>();

        // Create instances of the Person class
        Person mike = new Person("Mike", "mike@email.com");
        Person shaun = new Person("Shaun", "shaun@email.com");
        Person sally = new Person("Sally", "sally@email.com");
        Person cesar = new Person("Cesar", "cesar@email.com");

        // Add persons to the map using the addToMap method
        addToMap(mapOfPeople, mike);
        addToMap(mapOfPeople, shaun);
        addToMap(mapOfPeople, sally);
        addToMap(mapOfPeople, cesar);

        // Iterate over the keys of the map and print them
        for (String email : mapOfPeople.keySet()) {
            System.out.println(email);
        }

        // Iterate over the values of the map (Person objects) and print them
        for (Person person : mapOfPeople.values()) {
            System.out.println(person);
        }

        // Retrieve and print the person associated with the email "mike@email.com"
        System.out.println("Get Mike: " + mapOfPeople.get("mike@email.com"));

        // Retrieve and print the person associated with the email "jeff@email.com"
        // (returns null if the key doesn't exist)
        System.out.println("Get Jeff: " + mapOfPeople.get("jeff@email.com"));

        // Check if the map contains the key "mike@email.com" and print the result
        System.out.println("Contains Mike: " + mapOfPeople.containsKey("mike@email.com"));

        // Check if the map contains the key "jeff@email.com" and print the result
        System.out.println("Contains Jeff: " + mapOfPeople.containsKey("jeff@email.com"));
    }

    // Method to add persons to the map
    private static void addToMap(Map<String, Person> map, Person person) {
        map.put(person.getEmail(), person);
    }
}
