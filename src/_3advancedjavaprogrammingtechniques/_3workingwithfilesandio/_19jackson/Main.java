package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._19jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

/*
 * JSON (JavaScript Object Notation)
 *
 * [Download](https://www.jetbrains.com/help/idea/library.html#download-libraries-from-maven) the Jackson libraries directly from Maven.
 *
 * Commands (Linux/Mac)
 * javac -classpath ".:lib/*" Main.java
 * java -classpath ".:lib/*" Main client.json
 *
 * Commands (Windows)
 * javac -classpath ".;lib/*" Main.java
 * javac -classpath ".;lib/*" Main client.json
 * */
public final class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Main [file path]");
            return;
        }

        UdacisearchClient client =
                new UdacisearchClient(
                        "CatFacts LLC",
                        17,
                        8000,
                        5,
                        Instant.now(),
                        Duration.ofDays(180),
                        ZoneId.of("America/Los_Angeles"),
                        "555 Meowmers Ln, Riverside, CA 92501");

        Path outputPath = Path.of(args[0]);

        /* To use the external jars that contain the bytecode for the Jackson library,
         * we have to create a new Jackson objectMapper. */
        ObjectMapper objectMapper = new ObjectMapper();

        /* Because the class we're trying to serialize uses Java time types,
         * and Jackson doesn't know about those types by default,
         * we have to install a Java time module. */
        objectMapper.registerModule(new JavaTimeModule());

        // writeValue serializes the Java class to a JSON string and saves it to file.
        objectMapper.writeValue(Files.newBufferedWriter(outputPath), client);

        System.out.println("Wrote to " + outputPath.toAbsolutePath());

        /* readValue method de-serializes the JSON back into a Java class.
         * We pass in the udacisearchClient.class as an argument
         * so that Jackson knows what kind of Java object it's supposed to create. */
        UdacisearchClient deserialized =
                objectMapper.readValue(Files.newBufferedReader(outputPath), UdacisearchClient.class);
        System.out.println("Deserialized " + deserialized);
    }
}