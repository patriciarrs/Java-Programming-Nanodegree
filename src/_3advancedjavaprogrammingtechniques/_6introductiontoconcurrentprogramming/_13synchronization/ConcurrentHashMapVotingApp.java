package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._13synchronization;

import java.util.*;
import java.util.concurrent.*;

/*
 * ConcurrentHashMap has low-level optimizations that make it ideal for multithreaded access.
 *
 * For example, when two threads try to add entries to the map at the same time.
 *
 * Under the right circumstances ConcurrentHashMap may determine that the writes are non-conflicting,
 * and will allow them both to happen at the same time.
 *
 * With Collections.synchronizedMap() only one thread at a time is allowed to access the map,
 * no matter how those threads are using the map.
 */
public final class ConcurrentHashMapVotingApp {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(12);

        Map<String, Integer> votes = new ConcurrentHashMap<>();

        List<Future<?>> futures = new ArrayList<>(10_000);
        for (int i = 0; i < 10_000; i++) {
            futures.add(
                    executor.submit(() -> {
                        votes.compute("Larry", (k, v) -> (v == null) ? 1 : v + 1);
                    }));
        }
        for (Future<?> future : futures) {
            future.get();
        }
        executor.shutdown();

        System.out.println(votes);
    }
}