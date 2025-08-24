package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._9limitationsoflambdas;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class ReadFilesMain {
    public static void main(String[] args) throws IOException {
        /* One way to address the IOException is to handle it inside the lambda using a try-catch. */
        Stream.of("file-a.txt", "file-b.txt", "file-c.txt")
                .map(Path::of)
                .map(p -> {
                    try {
                        return Files.readAllLines(p, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        return List.of();
                    }
                })
                .flatMap(List::stream)
                .forEach(System.out::println);

        /* Alternatively, another approach to handling exceptions is to use a for loop
         * instead of using streams and lambdas. */
        List<String> fileNames = Arrays.asList("file-a.txt", "file-b.txt", "file-c.txt");

        for (String fileName : fileNames) {
            for (String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)) {
                System.out.println(line);
            }
        }
    }
}