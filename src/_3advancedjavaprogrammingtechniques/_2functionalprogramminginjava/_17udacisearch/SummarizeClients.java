package _3advancedjavaprogrammingtechniques._2functionalprogramminginjava._17udacisearch;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class SummarizeClients {
    public static void main(String[] args) {
        List<UdacisearchClient> clients = ClientStore.getClients();

        int numClients = clients.size();

        int totalQuarterlySpend = clients.stream().mapToInt(UdacisearchClient::getQuarterlyBudget).sum();

        double averageBudget = clients.stream().mapToDouble(UdacisearchClient::getQuarterlyBudget).average().orElse(0);

        Long nextExpirationClientId = clients.stream().min(
                Comparator.comparing(UdacisearchClient::getContractEnd)).map(UdacisearchClient::getId).orElse(-1L);

        Set<ZoneId> representedZoneIds =
                clients.stream().flatMap(c -> c.getTimeZones().stream()).collect(Collectors.toSet());

        Map<Year, Long> contractsPerYear = clients.stream()
                .collect(Collectors.groupingBy(SummarizeClients::getContractYear, Collectors.counting()));

        System.out.println("Num clients: " + numClients);
        System.out.println("Total quarterly spend: " + totalQuarterlySpend);
        System.out.println("Average budget: " + averageBudget);
        System.out.println("ID of next expiring contract: " + nextExpirationClientId);
        System.out.println("Client time zones: " + representedZoneIds);
        System.out.println("Contracts per year: " + contractsPerYear);
    }

    private static Year getContractYear(UdacisearchClient client) {
        LocalDate contractDate =
                LocalDate.ofInstant(client.getContractStart(), client.getTimeZones().get(0));
        return Year.of(contractDate.getYear());
    }
}
