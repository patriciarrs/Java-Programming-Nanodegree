package _2javafundamentals._5commontypes._12stringmethods;

public class StringMethods {
    public static void main(String[] args) {
        String text = "Hello";

        System.out.println(text.charAt(2));
        System.out.println(text.equalsIgnoreCase("hello"));
        System.out.println(text.contains("el"));

        String commaSeparatedString = "This, is, a, comma, separated, list";

        String[] stringArray = commaSeparatedString.split(",");

        for (String string : stringArray) {
            System.out.println(string);
        }

        System.out.println(commaSeparatedString.substring(0, 4));

        System.out.println(text.replace("l", "2"));
    }
}
