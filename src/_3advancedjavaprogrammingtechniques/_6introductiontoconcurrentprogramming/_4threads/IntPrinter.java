package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._4threads;

import java.util.ArrayList;
import java.util.List;

public final class IntPrinter {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Main <number of threads>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        // TODO: Create a list of n Threads and run them all in parallel with the System.out.println
        //       statement.
        List<Thread> threads = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new IntRunner(i));

            threads.add(thread);
        }

        /*
         * If we call thread.run() (instead of .start()):
         * .run() executes the runnable without starting a new thread.
         * Everything runs in the main thread, and all the numbers print in order.
         * When we run them in parallel (.start()), they print in a completely different order.
         * This is because thread scheduling is managed by the operating system,
         * and it can run threads in any order at once
         *
         * If we want tasks to execute in a particular order,
         * we have to run them in just one thread, or employ some kind of synchronization.
         */
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static final class IntRunner implements Runnable {

        private final int value;

        IntRunner(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            System.out.println("Thread #" + Thread.currentThread().getId() + " printed " + value);
        }
    }
}
