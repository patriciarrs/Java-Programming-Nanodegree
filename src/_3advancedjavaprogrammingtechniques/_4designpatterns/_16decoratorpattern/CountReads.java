package _3advancedjavaprogrammingtechniques._4designpatterns._16decoratorpattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

/*
 * Adapter vs Decorator
 * - These patterns both "wrap" another object, called the delegate.
 * - An Adapter returns a different interface than the delegate.
 * - A Decorator returns the same interface, but with added functionality or responsibilities.
 * - A Proxy is similar to a Decorator, but the proxy usually controls or manages access to the delegate.
 */

public final class CountReads {
    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader(
                "../../_3workingwithfilesandio/_4inputandoutputstreams/randomtext.txt")) {

            /* CountingReader's here decorate the other readers. */

            // This CountingReader will tell us the number of times we read from the FileReader
            CountingReader unbufferedReads = new CountingReader(reader);

            // This CountingReader will tell us the number of times we read from the BufferedReader
            CountingReader bufferedReads = new CountingReader(new BufferedReader(unbufferedReads));

            // Reading from the file, 100 chars at a time
            char[] data = new char[100];

            // Keep executing bufferedReads.read() until no bytes are read back
            while (bufferedReads.read(data) != -1) ;

            // BufferedReader had 35 reads to it (the reads that we requested)
            System.out.println("Calls to BufferedReader.read(): " + bufferedReads.getCount());

            // The actual reads from disk are 2
            System.out.println("Calls to FileReader.read(): " + unbufferedReads.getCount());
        }
    }

    /**
     * The CountingReader will delegate reads to another reader and count the number of times the read method was
     * called. CountingReader class extends the Reader abstract class.
     */
    public static final class CountingReader extends Reader {
        private final Reader delegate;
        private int count = 0;

        CountingReader(Reader delegate) {
            this.delegate = Objects.requireNonNull(delegate);
        }

        public int getCount() {
            return count;
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            count++;

            // Delegate the calls to the delegate.
            return delegate.read(cbuf, off, len);
        }

        @Override
        public void close() throws IOException {
            delegate.close();

        }
    }
}