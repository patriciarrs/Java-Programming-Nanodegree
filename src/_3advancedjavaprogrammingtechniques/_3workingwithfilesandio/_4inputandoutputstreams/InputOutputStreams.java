package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._4inputandoutputstreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/*
 * Input and output streams are the lowest level APIs Java offers for reading or writing a stream of bytes.
 * They give access to the raw data, in the form of bytes.
 * This data can come from a file, user input on the command-line, a network, ...
 * Uses:
 * - access low-level bytes of data from input (e.g., implementing a custom network protocol or file format);
 * - write bytes to output.
 * */
public class InputOutputStreams {
    public static void main(String[] args) throws IOException {
        inputStream();
        outputStream();
    }

    static void inputStream() throws IOException {
        InputStream inputStream =
                Files.newInputStream(Path.of("test"), StandardOpenOption.READ);

        byte[] data = new byte[10];

        /* "read()" reads some number of bytes from the input stream and stores them into the byte array.
         * It returns the number of bytes read; if no bytes were read, it returns -1.
         * The entire file is read, 10 bytes at a time, until the loop reaches the end of the file.
         * */
        while (inputStream.read(data) != -1) {
            useData(data);
        }

        inputStream.close();  // Close the "test" file
    }

    static void outputStream() throws IOException {
        OutputStream out = Files.newOutputStream(Path.of("test"));

        // "write()" receives s byte array, and it writes those bytes to the output stream.
        out.write("Hello, world!".getBytes());

        out.close();  // Close the "test" file
    }

    private static void useData(byte[] data) {
    }
}
