package _3advancedjavaprogrammingtechniques._4designpatterns._19dependencyinjection;

import com.google.inject.AbstractModule;

import java.time.Clock;

/*
 * The purpose of this module is to tell Guice (the dependency injection framework)
 * which implementations it should use for each dependency the ExpirationChecker needs to inject.
 */
public final class ExpirationCheckerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MetadataFetcher.class).to(MetadataFetcherImpl.class);
        bind(Clock.class).toInstance(Clock.systemUTC());
    }
}
