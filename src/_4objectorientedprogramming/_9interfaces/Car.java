package _4objectorientedprogramming._9interfaces;

public class Car implements Vehicle, Production {
    private String type;
    private String speed;
    private String color;
    private String direction;

    public Car(String type, String color, String speed, String direction) {
        this.type = type;
        this.color = color;
        this.speed = speed;
        this.direction = direction;
    }


    @Override
    public void start() {
        
    }

    @Override
    public void stop() {

    }

    @Override
    public void speed() {

    }

    @Override
    public void direction() {

    }

    @Override
    public void location() {

    }
}
