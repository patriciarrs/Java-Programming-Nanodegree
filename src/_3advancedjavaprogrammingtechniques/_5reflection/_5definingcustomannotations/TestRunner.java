package _3advancedjavaprogrammingtechniques._5reflection._5definingcustomannotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
 * Compile and run the test runner:
 * javac TestRunner.java
 * java -ea TestRunner
 *
 * The -ea JVM option stands for "enable assertions".
 * It makes the assert statements in CalculatorTest.java actually throw AssertionErrors.
 * If we leave that option out,the Java runtime just won't run assertions at all.
 */
public final class TestRunner {
    // Static list of test classes
    private static final List<Class<?>> TESTS = List.of(CalculatorTest.class);

    public static void main(String[] args) throws Exception {
        List<String> passed = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        for (Class<?> klass : TESTS) {
            // TODO: For each test class "klass", do the following:
            //        1. Ensure the class implements the UnitTest interface.
            //        2. Create an instance of the class and cast it to UnitTest.

            // TODO: For each method that is annotated with @Test:
            //        1. Call beforeEachTest()
            //        2. Invoke the method annotated with @Test
            //        3. Call afterEachTest()
            //        4. Record the test results by adding getTestName(...) to either the "passed" list
            //           of the "failed" list.

            if (!UnitTest.class.isAssignableFrom(klass)) {
                throw new IllegalArgumentException("Class " + klass + " must implement UnitTest");
            }

            for (Method method : klass.getDeclaredMethods()) {
                if (method.getAnnotation(Test.class) != null) {
                    try {
                        /* Because the goal here is to create a new test fixture each time the unit test runs,
                         * we should create a new instance of the test class for each annotated method. */
                        UnitTest test = (UnitTest) klass.getConstructor().newInstance();

                        test.beforeEachTest();
                        method.invoke(test);
                        test.afterEachTest();

                        passed.add(getTestName(klass, method));
                    } catch (Throwable throwable) {
                        // If the test failed, it will throw an assertion error, or another kind of error.
                        failed.add(getTestName(klass, method));
                    }
                }
            }
        }

        System.out.println("Passed tests: " + passed);
        System.out.println("FAILED tests: " + failed);
    }

    private static String getTestName(Class<?> klass, Method method) {
        return klass.getName() + "#" + method.getName();
    }
}
