package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._10parallelstreams;

import _2javafundamentals._4objectorientedprogramming._4inheritance.Student;

import java.time.Year;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ParallelStreamsWithThreadPools {
    ForkJoinPool pool = new ForkJoinPool();

    // ... studentList ...

    Future<Map<Year, Long>> graduatingClassSizes = pool.submit(() ->
            studentList.parallelStream()
                    .collect(Collectors.groupingByConcurrent(
                            Student::getGraduationYear, Collectors.counting())));
}
