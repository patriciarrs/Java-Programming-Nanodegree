package _3advancedjavaprogrammingtechniques._4designpatterns._19dependencyinjection;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Checks whether a list of files has expired, or reached its 30-day limit.
 * If any of the input files are expired, the program prints out their file names so we can delete them.
 */
public final class ExpirationChecker {

    private final Clock clock;
    private final MetadataFetcher metadataFetcher;

    // Annotate the constructor with the @Inject annotation.
    @Inject
    ExpirationChecker(Clock clock, MetadataFetcher metadataFetcher) {
        /*
         * The ExpirationChecker constructor takes arguments for each of its instance fields.
         * The body of the constructor assigns values to the instance fields.
         */
        this.clock = clock;
        this.metadataFetcher = metadataFetcher;
    }

    public List<Path> getExpiredFiles(List<Path> paths, Duration expiration) {
        return paths.stream()
                .filter((path) -> isExpired(path, expiration))
                .collect(Collectors.toList());
    }

    private boolean isExpired(Path path, Duration expiration) {
        /*
         * Use the new Clock field instead of Instant.now() to get the current time.
         * By doing this, we will be able to use a fake Clock implementation in tests,
         * to control what ExpirationChecker thinks is the current time.
         */
        Instant now = clock.instant();
        try {
            Instant modifiedTime = metadataFetcher.getLastModifiedTime(path);
            return now.isAfter(modifiedTime.plus(expiration));
        } catch (IOException e) {
            return false;
        }
    }
}
