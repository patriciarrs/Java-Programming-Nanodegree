package _2javafundamentals._4objectorientedprogramming._6polymorphism;

public class Vehicle {
    private String start;
    private String stop;
    private String speed;
    private String direction;

    public Vehicle(String start, String stop, String speed, String direction) {
        this.start = start;
        this.stop = stop;
        this.speed = speed;
        this.direction = direction;
    }

    public void start() {
        System.out.println(start);
    }

    public void stop() {
        System.out.println(stop);
    }

    public void speed() {
        System.out.println(speed);
    }

    public void direction() {
        System.out.println(direction);
    }
}
