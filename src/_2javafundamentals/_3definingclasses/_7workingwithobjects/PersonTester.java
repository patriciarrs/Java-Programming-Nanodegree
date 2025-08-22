package _2javafundamentals._3definingclasses._7workingwithobjects;

public class PersonTester {
    public static void main(String[] args) {
        Person bob = new Person("Bob", "Philips");
        Person mike = new Person("Mike", "Lipson");

        System.out.println(bob);
        System.out.println(mike);
    }
}
