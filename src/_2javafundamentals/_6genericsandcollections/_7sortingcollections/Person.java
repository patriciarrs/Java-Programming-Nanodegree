package _2javafundamentals._6genericsandcollections._7sortingcollections;

public class Person implements Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }
}
