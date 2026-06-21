package _4javaapplicationdeployment._3dependencymanagementwithmaven._5xml;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* Your goal is to write XML that you would use to represent the Java object created using the following code fragment */
        new CarRecords(List.of(
                new Car("Beetle", "Volkswagen", 1963),
                new Car("Miller-Meteor", "Cadillac", 1959)
        ));
    }
}
