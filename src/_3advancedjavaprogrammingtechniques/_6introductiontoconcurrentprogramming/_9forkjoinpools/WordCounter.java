package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._9forkjoinpools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public final class WordCounter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: WordCounter [path] [word]");
            return;
        }

        Path start = Path.of(args[0]);
        String word = args[1];

        Instant before = Instant.now();

        // Method used before parallelization
        // long count = countWords(start, word);

        ForkJoinPool pool = new ForkJoinPool();
        // Root task: Returns its stored result to pool.invoke().
        long count = pool.invoke(new CountWordsTask(start, word));

        Duration elapsed = Duration.between(before, Instant.now());
        System.out.println(count + " (" + elapsed.toSeconds() + " seconds)");
    }

    /**
     * Counts all occurrences of a word in a file.
     */
    public static long countWordInFile(Path file, String word) {
        try {
            return Files.readAllLines(file, StandardCharsets.UTF_8)
                    .stream()
                    .flatMap(l -> Arrays.stream(l.split(" ")))
                    .filter(word::equalsIgnoreCase)
                    .count();
        } catch (IOException e) {
            return 0;
        }
    }

    // Method used before parallelization
    private static long countWords(Path path, String word) {
        // If it's a file, count the words directly
        if (!Files.isDirectory(path)) {
            return countWordInFile(path, word);
        }

        // If it's a directory, list its subpaths and sum the counts
        try {
            return Files.list(path)
                    .mapToLong(p -> countWords(p, word))
                    .sum();
        } catch (IOException e) {
            return 0;
        }
    }
}