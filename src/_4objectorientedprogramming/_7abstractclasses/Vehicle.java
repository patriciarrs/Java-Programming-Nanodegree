package _4objectorientedprogramming._7abstractclasses;

public abstract class Vehicle {
    private String start;
    private String stop;
    private String direction;

    public Vehicle(String start, String stop, String direction) {
        this.start = start;
        this.stop = stop;
        this.direction = direction;
    }

    public abstract void speed();
}
