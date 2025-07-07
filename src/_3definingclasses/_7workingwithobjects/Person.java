package _3definingclasses._7workingwithobjects;

public class Person {
    private String firstName;
    private String lastName;

    // Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter - Also called Accessor
    public String getFirstName() {
        return firstName;
    }

    // Setter - Also called Mutator
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Additional method
    public void eat(String food) {
        String response = "I love eating";
        System.out.println(response + " " + food);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
