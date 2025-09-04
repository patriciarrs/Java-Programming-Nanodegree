package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._4inputandoutputstreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        // 3 different ways to copy a file using input and output streams
        readingAndWritingDataDirectly(args);
        usingTransferTo(args);
        usingFilesApi(args);
    }

    private static void readingAndWritingDataDirectly(String[] args) throws IOException {
        InputStream in = Files.newInputStream(Path.of(args[0]));
        OutputStream out = Files.newOutputStream(Path.of(args[1]));

        byte[] data = new byte[10];
        while (in.read(data) != -1) {
            out.write(data);
        }

        in.close();
        out.close();
    }

    private static void usingTransferTo(String[] args) throws IOException {
        InputStream in = Files.newInputStream(Path.of(args[0]));
        OutputStream out = Files.newOutputStream(Path.of(args[1]));

        in.transferTo(out);

        in.close();
        out.close();
    }

    private static void usingFilesApi(String[] args) throws IOException {
        Files.copy(Path.of(args[0]), Path.of(args[1]));
    }
}