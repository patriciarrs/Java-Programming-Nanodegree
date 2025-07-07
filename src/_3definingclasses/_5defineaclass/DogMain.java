package _3definingclasses._5defineaclass;

public class DogMain {
    public static void main(String[] args) {
        Dog myDog = new Dog("Labrador", "Buddy", "Golden", 3);

        // Use methods of the Dog class
        System.out.println(myDog.getDogType());
        System.out.println(myDog.getDogName());
        System.out.println(myDog.getDogColor());
        System.out.println(myDog.getDogAge());

        // Or print the entire information using the toString method
        System.out.println(myDog);
    }
}
