package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._11exerciseparallelstreams;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public final class SummarizeClients {
    public static void main(String[] args) throws Exception {

        List<UdacisearchClient> clients = ClientStore.getClients();
        int numClients = clients.size();

        // The default pool detects and uses the number of available processors.
        System.out.println("The system has " + Runtime.getRuntime().availableProcessors() + " processors.");

        /* To make all the computations happen at the same time in parallel
         * we have to use thread pools and futures. */
        // TODO: Create a ForkJoinPool to use as a thread pool.
        ForkJoinPool pool = new ForkJoinPool();

        /* For each of the computed metrics, create a Callable that uses a parallel stream to do the computation
         * (Hint: Lambdas are the easiest way to create a Callable).
         * Submit the Callable to the thread pool and keep the returned Future in a variable for later.
         * By default, running a parallel stream without an explicit thread pool is generally a bad idea.
         * Wrapping the parallel stream in a Callable and submitting it to the thread pool like this
         * forces the parallel stream to run in the given thread pool.
         */
        // To make each computation asynchronous, you have to change each .stream() to .parallelStream().
        // TODO: For each metric below, turn it into a Future and submit it to the ForkJoinPool.
        Future<Integer> totalQuarterlySpend =
                pool.submit(() ->
                        clients
                                .parallelStream()
                                .mapToInt(UdacisearchClient::getQuarterlyBudget)
                                .sum());

        Future<Double> averageBudget =
                pool.submit(() -> clients
                        .parallelStream()
                        .mapToDouble(UdacisearchClient::getQuarterlyBudget)
                        .average()
                        .orElse(0));

        Future<Long> nextExpiration =
                pool.submit(() -> clients
                        .parallelStream()
                        .min(Comparator.comparing(UdacisearchClient::getContractEnd))
                        .map(UdacisearchClient::getId)
                        .orElse(-1L));

        Future<List<ZoneId>> representedZoneIds =
                pool.submit(() -> clients
                        .parallelStream()
                        .flatMap(c -> c.getTimeZones().stream())
                        .distinct()  // Or use Collectors.toSet()
                        .collect(Collectors.toList()));

        /* We have to change any non-concurrent collectors to their concurrent counterparts
         * (i.e., .groupingBy() collector to .groupingByConcurrent()). */
        Future<Map<Year, Long>> contractsPerYear =
                pool.submit(() -> clients
                        .parallelStream()
                        .collect(Collectors.groupingByConcurrent(SummarizeClients::getContractYear,
                                Collectors.counting())));

        System.out.println("Num clients: " + numClients);

        // TODO: You will need to call Future#get() on each of the futures to return the actual
        //       computed value.
        pool.shutdown();

        System.out.println("Total quarterly spend: " + totalQuarterlySpend.get());
        System.out.println("Average budget: " + averageBudget.get());
        System.out.println("ID of next expiring contract: " + nextExpiration.get());
        System.out.println("Client time zones: " + representedZoneIds.get());
        System.out.println("Contracts per year: " + contractsPerYear.get());
    }

    private static Year getContractYear(UdacisearchClient client) {
        LocalDate contractDate =
                LocalDate.ofInstant(client.getContractStart(), client.getTimeZones().get(0));
        return Year.of(contractDate.getYear());
    }
}