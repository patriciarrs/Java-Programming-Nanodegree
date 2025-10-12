package _3advancedjavaprogrammingtechniques._4designpatterns._19dependencyinjection;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Main {
    public static void main(String[] args) {
        /*
         * Create a new dependency injection container (which is called an Injector in Guice terminology)
         * that uses the module Guice.createInjector(new ExpirationCheckerModule()),
         * and then get an instance of the ExpirationChecker by using Injector#getInstance(ExpirationChecker.class).
         */
        Injector injector = Guice.createInjector(new ExpirationCheckerModule());
        ExpirationChecker checker = injector.getInstance(ExpirationChecker.class);

        List<Path> paths = Arrays.stream(args).map(Path::of).collect(Collectors.toList());

        System.out.println("The following files are expired: "
                + checker.getExpiredFiles(paths, Duration.ofDays(28)));
    }
}