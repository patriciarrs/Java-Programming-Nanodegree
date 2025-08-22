package _2javafundamentals._4objectorientedprogramming._6polymorphism;

public class VehicleTester {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Plane();
        vehicles[2] = new Boat();

        polymorphism(vehicles);
        coupling();
    }

    private static void polymorphism(Vehicle[] vehicles) {
        for (Vehicle vehicle : vehicles) {
            vehicle.speed();
        }
    }

    /**
     * One of the problems that polymorphism solves for us is coupling.
     * If we didn't use polymorphism (if we needed to have the concrete classes for each one of them)
     * that would be more difficult, have more coupling, and be more prone to error.
     * If I needed to add another vehicle, I would have to change other code.
     * <p>
     * In this method, we have to create the car, the plane, and the boat, and then call speed().
     * We need to know exactly which classes are implementing Vehicle, so they can call speed().
     * With polymorphism, we don't need to know what those concrete classes are, or how they behave.
     */
    private static void coupling() {
        Car car = new Car();
        Plane plane = new Plane();
        Boat boat = new Boat();

        car.speed();
        plane.speed();
        boat.speed();
    }
}
