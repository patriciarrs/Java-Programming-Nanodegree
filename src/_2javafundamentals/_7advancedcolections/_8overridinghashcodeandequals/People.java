package _2javafundamentals._7advancedcolections._8overridinghashcodeandequals;

import java.util.Objects;

public class People {
    private String address;
    private String name;
    private String number;
    
    /**
     * Regarding equals() and hashCode(), when we override one, we must always override the other.
     */

    /**
     * Define how to determine whether two objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(address, people.address);
    }

    /**
     * Ensures that each object has a unique identifier for efficient storage and retrieval.
     * When inserting objects into a hash structure (like a HashMap, HashSet, or any other collection that utilizes hashing),
     * this method helps in efficient storage and retrieval.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(address);
    }
}
