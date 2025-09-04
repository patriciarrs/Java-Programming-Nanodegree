package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._5readersandwriters;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example {
    /* Readers and Writers are the next level of abstraction built on top of input and output streams.
     * These interfaces read and write text characters and use a stream behind the scenes.
     */

    void reader() throws IOException {
        // Instead of reading bytes, we are reading chars
        Reader reader =
                Files.newBufferedReader(Path.of("test"), StandardCharsets.UTF_8);

        char[] data = new char[10];
        while (reader.read(data) != -1) {
            useData(data);
        }

        reader.close();
    }

    private static void useData(char[] data) {
    }

    void writer() throws IOException {
        Writer writer =
                Files.newBufferedWriter(Path.of("test"),
                        StandardCharsets.UTF_8);

        // This time we are writing encoded Strings of data instead of raw bytes
        writer.write("hello, world");

        writer.close();  // Close the "test" file
    }
}