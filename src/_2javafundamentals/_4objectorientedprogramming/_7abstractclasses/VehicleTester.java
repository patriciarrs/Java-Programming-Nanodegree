package _2javafundamentals._4objectorientedprogramming._7abstractclasses;

public class VehicleTester {
    public static void main(String[] args) {
        // 'Vehicle' is abstract; cannot be instantiated
        // Vehicle vehicle = new Vehicle();

        Car car = new Car();
        car.speed();
    }
}
