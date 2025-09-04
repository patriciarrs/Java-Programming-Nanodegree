package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._7bufferedstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example {
    public static void main(String[] args) throws IOException {
        bufferedReader();

        bufferedWriter();
    }

    /* When we call BufferedReader.read(), the BufferedReader reads ahead, and fetches more data than we asked for.
     * Whatever it reads is stored in an array, which is also called a buffer.
     * The next time we call read(), if the data we requested is already in the buffer,
     * the BufferedReader will give us that cached data, without having to do another read from disk.
     */
    private static void bufferedReader() throws IOException {
        /*
         * The Files API only returns buffered readers.
         * The main difference between this and the Reader API is the addition of the readLine() method
         * (which returns a full line of text).
         */
        BufferedReader reader =
                Files.newBufferedReader(Path.of("test"), StandardCharsets.UTF_8);

        String line;

        /* 1st, it assigns the data that was read into a variable.
         * 2nd, it compares that variable to some value that indicates when the loop should terminate.
         * "readline" will return null after it reaches the end of the file so this loop will terminate.
         */
        while ((line = reader.readLine()) != null) {
            useString(line);
        }

        reader.close();
    }

    private static void bufferedWriter() throws IOException {
        /* BufferedWriter also uses an in-memory buffer to store writes,
         * and then periodically writes contents of the buffer in batches.
         */
        BufferedWriter writer =
                Files.newBufferedWriter(Path.of("test"),
                        StandardCharsets.UTF_8);

        // The write() method is called twice, but there is only one actual write to the underlying output stream.
        writer.write("Hello, ");
        writer.write("world!");

        /* Emptying out the buffer is called flushing.
         * We can force this to happen immediately by calling the flush() method.
         * Flushing the buffer will write its contents to the file so that any changed become visible.
         */
        writer.flush();

        // Flushes the buffer and closes "test" (so usually it is not needed to call the flush method manually)
        writer.close();
    }

    private static void useString(String line) {
    }
}
