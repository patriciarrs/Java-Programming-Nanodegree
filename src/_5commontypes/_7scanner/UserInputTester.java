package _5commontypes._7scanner;

import java.util.Scanner;

public class UserInputTester {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a String");
            String userInput = scanner.nextLine();
            System.out.println("User Input: " + userInput);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
