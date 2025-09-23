package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._11externalsort2;

import java.io.BufferedReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public final class MergeShards {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MergeShards [input folder] [output file]");
            return;
        }

        List<Path> inputs = Files.walk(Path.of(args[0]), 1).skip(1).toList();

        // List of BufferedReaders - one for each input Path (shard.txt).
        List<BufferedReader> readers = new ArrayList<>(inputs.size());

        Path outputPath = Path.of(args[1]);

        // TODO: Inside a try-finally block, create the List of BufferedReaders: one for each "input"
        //       Path. Without modifying the shard files, merge them together into a single text file
        //       whose location is specified by the "outputPath".
        //
        //       To do this, you should put words in a PriorityQueue<WordEntry>, but make sure the
        //       priority queue never contains more entries than there are input files. The whole point
        //       of doing a distributed merge sort is that there are too many words to fit into memory!
        //
        //       In the "finally" part of the try-finally block, make sure to close all the
        //       BufferedReaders.

        // Since we need to close a list of readers, it's not possible to use try-with-resources.
        try {
            for (Path input : inputs) {
                readers.add(Files.newBufferedReader(input));
            }

            // PriorityQueue keeps the words sorted
            PriorityQueue<WordEntry> wordEntries = new PriorityQueue<>();

            // At the end of the loop wordEntries will have 100 entries (one per shard).
            for (BufferedReader reader : readers) {
                String word = reader.readLine();

                if (word != null) {
                    wordEntries.add(new WordEntry(word, reader));
                }
            }

            try (Writer writer = Files.newBufferedWriter(outputPath)) {
                // Continually calls PriorityQueue to get the next alphabetical word to write.
                while (!wordEntries.isEmpty()) {
                    // The poll method returns the word in the queue that alphabetically comes first.
                    WordEntry wordEntry = wordEntries.poll();

                    // Write the word to the output file.
                    writer.write(wordEntry.word);
                    writer.write(System.lineSeparator());

                    // Get a word from the same BufferedReader that produced the word written above.
                    String word = wordEntry.reader.readLine();

                    if (word != null) {
                        // "Replenish" the PriorityQueue with the new word
                        wordEntries.add(new WordEntry(word, wordEntry.reader));
                    }
                }
            }
        } finally {
            // Close all the BufferedReaders.
            for (BufferedReader reader : readers) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private record WordEntry(String word, BufferedReader reader) implements Comparable<WordEntry> {
        private WordEntry(String word, BufferedReader reader) {
            this.word = Objects.requireNonNull(word);
            this.reader = Objects.requireNonNull(reader);
        }

        @Override
        public int compareTo(WordEntry other) {
            return word.compareTo(other.word);
        }
    }
}
