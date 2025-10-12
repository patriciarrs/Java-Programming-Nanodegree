package _3advancedjavaprogrammingtechniques._4designpatterns._19dependencyinjection;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExpirationCheckerTest {
    public static void main(String[] args) {

        FakeClock fakeClock = new FakeClock();
        Map<Path, Instant> fakeModifiedTimes = new HashMap<>();
        FakeMetadataFetcher fakeMetadataFetcher = new FakeMetadataFetcher(fakeModifiedTimes);

        /*
         * Use a Guice Injector to instantiate the ExpirationChecker.
         * This injector uses the FakeClock and FakeMetadataFetcher implementations.
         * There is a terse way to do this in Guice using the Module interface, which is compatible with lambdas.
         */
        Injector injector = Guice.createInjector(
                b -> b.bind(Clock.class).toInstance(fakeClock),
                b -> b.bind(MetadataFetcher.class).toInstance(fakeMetadataFetcher));
        ExpirationChecker checker = injector.getInstance(ExpirationChecker.class);

        Path expired = Path.of("/test/expired");
        Path notExpired = Path.of("/test/not-expired");
        fakeModifiedTimes.put(expired, fakeClock.instant().minus(Duration.ofDays(31)));
        fakeModifiedTimes.put(notExpired, fakeClock.instant().minus(Duration.ofDays(27)));

        List<Path> expiredFiles =
                checker.getExpiredFiles(List.of(expired, notExpired), Duration.ofDays(30));

        assert expiredFiles.equals(List.of(expired));
    }
}