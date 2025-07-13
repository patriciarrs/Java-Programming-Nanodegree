package _5commontypes._11regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private String email;

    // String for a valid email address using a regular expression
    private final String emailRegex = "^(.+)@(.+).(.+)$";

    // Pattern provides a compiled instance of a String regular expression
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Person(String name, String email) {
        // Matcher contains all the state data for matching a character sequence against the Pattern
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Error, Invalid email");
        }
        
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emailRegex='" + emailRegex + '\'' +
                ", pattern=" + pattern +
                '}';
    }
}
