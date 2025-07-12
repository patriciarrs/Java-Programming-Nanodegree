package _4objectorientedprogramming._7abstractclasses;

import _4objectorientedprogramming._6polymorphism.Boat;
import _4objectorientedprogramming._6polymorphism.Plane;

public class VehicleTester {
    public static void main(String[] args) {
        // 'Vehicle' is abstract; cannot be instantiated
        // Vehicle vehicle = new Vehicle();

        Car car = new Car();
        car.speed();
    }
}
