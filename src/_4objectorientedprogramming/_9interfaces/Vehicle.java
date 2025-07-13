package _4objectorientedprogramming._9interfaces;

/**
 * Can have class variables.
 * Every method in an interface is abstract.
 * Cannot have instance variables. Variables in an interface must be the same for every class implementing the interface.
 * Classes can implement more than one interface and have multiple inheritance.
 * <p>
 * Use an INTERFACE when:
 * We expect unrelated classes will be implementing our interface.
 * We want to support multiple inheritance.
 * We want to specify the behavior for a data type, but we do not care about the implementation.
 */
public interface Vehicle {
    public void start();

    public void stop();

    public void speed();

    public void direction();
}
