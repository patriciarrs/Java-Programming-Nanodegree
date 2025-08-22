package _2javafundamentals._4objectorientedprogramming._6polymorphism;

public class Boat extends Vehicle {
    public Boat() {
        super("Boat start", "Boat stop", "Boat speed", "Boat direction");
    }

    @Override
    public void speed() {
        System.out.println("This is my boat class method.");
    }
}
