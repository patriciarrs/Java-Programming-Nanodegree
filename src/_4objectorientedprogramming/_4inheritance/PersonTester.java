package _4objectorientedprogramming._4inheritance;

public class PersonTester {
    public static void main(String[] args) {
        Person sally = new Person("Sally", "Philips");
        System.out.println(sally);

        Student mike = new Student("Mike", "Thompson", "12345");
        System.out.println(mike);

        StudentEmployee jeff = new StudentEmployee("Jeff", "Sam", "4567", "#12345", 20.5);
        System.out.println(jeff);
    }
}
