package _5commontypes._4exceptions;

public class PhoneExceptionTester {
    public static void main(String[] args) {
        String[] numbers = new String[]{"123-4567", null, "234-4567", "345-5678"};

        for (String number : numbers) {
            try {
                System.out.println(new Phone("iPhone", number));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getLocalizedMessage());
            }

        }
    }
}
