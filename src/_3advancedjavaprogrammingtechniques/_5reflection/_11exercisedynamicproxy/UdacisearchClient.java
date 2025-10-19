package _3advancedjavaprogrammingtechniques._5reflection._11exercisedynamicproxy;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public interface UdacisearchClient {
    String getName();

    long getId();

    int getQuarterlyBudget();

    int getNumEmployees();

    Instant getContractStart();

    Duration getContractLength();

    ZoneId getTimeZone();

    String getBillingAddress();
}
