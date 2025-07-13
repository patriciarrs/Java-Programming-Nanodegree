package _4objectorientedprogramming._7abstractclasses;

/**
 * Can have class variables.
 * Can have instance variables, i.e. variables that are specific to individual subclasses.
 * Can have both abstract methods and concrete methods that are shared with the subclasses.
 * Subclasses can only extend one class.
 * <p>
 * Use an ABSTRACT class when:
 * We want subclasses to have instance variables.
 * We want to provide concrete methods for subclasses.
 * We want to make use of both concrete methods and abstract methods for subclasses.
 */
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
