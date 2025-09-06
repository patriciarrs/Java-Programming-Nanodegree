package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._10preventingresourceleaks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/* Only Closeable or AutoCloseable objects can be used in the try statement.
 * They are almost the same, but closable is intended for use with IO.
 *
 * Most of the I/O classes (including Stream, Reader, Writer, InputStream, and OuptutStream)
 * implement the Closeable interface, whose close() method can throw an IOException.
 * AutoCloseable.close() does not throw IOException.
 *
 *
 * Closeable and AutoCloseable are regular Java interfaces,
 * which means we can write our own implementations and then use them in a try-with-resources block.
 */
public class Example {
    public static void main(String[] args) throws IOException {
        tryCatchFinally();
        tryWithResources();
        multipleResources();
    }

    /* The code in the finally block is guaranteed to execute after the code in the try block (even if the try block returns a value or throws an exception).
     * A catch block is optional.
     */
    static void tryCatchFinally() {
        Writer writer = null;

        try {
            writer = Files.newBufferedWriter(Path.of("test"));
            writer.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* The try-with-resources syntax allows us to initialize resources in parentheses before the start of the try block.
     * Resources initialized in this way are guaranteed to be closed after the try block finishes executing.
     * try-with-resources has removed the need for the finally block in a lot of modern Java code,
     * but there are still some use cases where the finally block is useful.
     */
    static void tryWithResources() {
        try (Writer writer = Files.newBufferedWriter(Path.of("test"))) {
            writer.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // We can initialize multiple resources in the same try statement.
    static void multipleResources() throws IOException {
        // Copy the contents of "foo" to "bar"
        try (InputStream in = Files.newInputStream(Path.of("foo"));
             OutputStream out = Files.newOutputStream(Path.of("bar"))) {
            out.write(in.readAllBytes());
        }
    }

    /* Here, we create a buffered writer that buffers and existing writer.
     *
     * Because the buffered writer is created inside a try with resources,
     * it's close method is guaranteed to be called when the try block finishes executing.
     * Closing the buffered writer also closes the underlying writer.
     *
     * Since this code did not create that underlying writer,
     * that writer could also have been created inside its own try-with-resources.
     * In that case, it's close method will be called twice, an IOException will be thrown and the program might crash.
     */
    void sayHello(Writer writer) throws IOException {
        // Closes the underlying Writer!
        try (BufferedWriter buffered = new BufferedWriter(writer)) {
            buffered.write("Hello, world!");
        }
    }
}