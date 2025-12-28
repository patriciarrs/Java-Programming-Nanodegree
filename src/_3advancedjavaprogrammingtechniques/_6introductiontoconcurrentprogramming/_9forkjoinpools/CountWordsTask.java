package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._9forkjoinpools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Extends RecursiveTask (which returns a Long)
 */
public final class CountWordsTask extends RecursiveTask<Long> {
    private final Path path;
    private final String word;

    public CountWordsTask(Path path, String word) {
        this.path = path;
        this.word = word;
    }

    /**
     * When a task completes: 1. Each CountWordsTask calls compute(), which returns a Long value. 2. The Fork/Join
     * framework automatically saves this return value inside the RecursiveTask object.
     *
     * @return the word count
     */
    @Override
    protected Long compute() {
        // Base case (file): compute() returns the word count → Fork/Join framework stores it in the task object.
        if (!Files.isDirectory(path)) {
            return WordCounter.countWordInFile(path, word);
        }

        /*
         * Recursive case (directory):
         *  Creates subtasks
         *   → invokeAll() waits for all to complete
         *   → getRawResult() retrieves each stored result
         *   → sums them
         *   → returns the sum (which gets stored in this task's internal state).
         */
        Stream<Path> subpaths;
        try {
            subpaths = Files.list(path);
        } catch (IOException e) {
            return 0L;
        }

        // Creates more recursive tasks
        List<CountWordsTask> subtasks =
                subpaths.map(path -> new CountWordsTask(path, word))
                        .collect(Collectors.toList());

        // Submits all subtasks to the ForkJoinPool
        // When the root's invokeAll() returns, every file in the entire tree has been processed — no matter how deeply nested.
        invokeAll(subtasks);

        return subtasks
                .stream()
                .mapToLong(CountWordsTask::getRawResult)
                .sum();
    }
}