package _5commontypes._5enums;

public class Light {
    public Light() {
    }

    public void changeLight(Stoplight currentLight) {
        if (currentLight == Stoplight.GREEN) {
            System.out.println("Green means Go!");
        } else if (currentLight == Stoplight.YELLOW) {
            System.out.println("Slow down!");
        } else if (currentLight == Stoplight.RED) {
            System.out.println("Stop!");
        }
    }
}
