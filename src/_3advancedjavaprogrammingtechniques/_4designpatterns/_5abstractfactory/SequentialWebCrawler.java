/*
package _3advancedjavaprogrammingtechniques._4designpatterns._5abstractfactory;

import com.udacity.webcrawler.json.CrawlResult;
import com.udacity.webcrawler.parser.PageParser;
import com.udacity.webcrawler.parser.PageParserFactory;

import javax.inject.Inject;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

*/
/**
 * A {@link WebCrawler} that downloads and processes one page at a time.
 *//*

final class SequentialWebCrawler implements WebCrawler {

    private final Clock clock;
    private final PageParserFactory parserFactory;
    private final Duration timeout;
    private final int popularWordCount;
    private final int maxDepth;
    private final List<Pattern> ignoredUrls;

    */
/*
 * Clients first need an instance of the factory.
 * Here, they call the constructor.
 * PageParserFactory parserFactory = new PageParserFactoryImpl(Duration.ofSeconds(5), List.of("foo"));
 * Notice that the timeout and ignored list of PageParsers is determined when the factory is constructed and the Parse URL is determined by the parameter of get.
 *
 * In a lot of cases, clients will obtain a factory through dependency injection.
 * Clients can only create PageParsers by calling the get method.
 * Clients don't actually know they're getting a PageParserImpl.
 * All they care about is: the returned object implements the PageParser interface.
 *//*


    @Inject
    SequentialWebCrawler(
            Clock clock,
            PageParserFactory parserFactory,
            @Timeout Duration timeout,
            @PopularWordCount int popularWordCount,
            @MaxDepth int maxDepth,
            @IgnoredUrls List<Pattern> ignoredUrls) {
        this.clock = clock;
        // A PageParserFactory is injected into the constructor
        this.parserFactory = parserFactory;
        this.timeout = timeout;
        this.popularWordCount = popularWordCount;
        this.maxDepth = maxDepth;
        this.ignoredUrls = ignoredUrls;
    }

    @Override
    public CrawlResult crawl(List<String> startingUrls) {
        Instant deadline = clock.instant().plus(timeout);
        Map<String, Integer> counts = new HashMap<>();
        Set<String> visitedUrls = new HashSet<>();
        for (String url : startingUrls) {
            crawlInternal(url, deadline, maxDepth, counts, visitedUrls);
        }

        if (counts.isEmpty()) {
            return new CrawlResult.Builder()
                    .setWordCounts(counts)
                    .setUrlsVisited(visitedUrls.size())
                    .build();
        }

        return new CrawlResult.Builder()
                .setWordCounts(WordCounts.sort(counts, popularWordCount))
                .setUrlsVisited(visitedUrls.size())
                .build();
    }

    private void crawlInternal(
            String url,
            Instant deadline,
            int maxDepth,
            Map<String, Integer> counts,
            Set<String> visitedUrls) {
        if (maxDepth == 0 || clock.instant().isAfter(deadline)) {
            return;
        }
        for (Pattern pattern : ignoredUrls) {
            if (pattern.matcher(url).matches()) {
                return;
            }
        }
        if (visitedUrls.contains(url)) {
            return;
        }
        visitedUrls.add(url);
        */
/* When we want to create a new page parser, we just call the get method and pass in the URL of the website we want to parse.
 * Thanks to the abstract factory pattern and dependency injection, all the other dependencies of the PageParser and the PageParserFactory are filled out for us.  *//*

        PageParser.Result result = parserFactory.get(url).parse();
        for (Map.Entry<String, Integer> e : result.getWordCounts().entrySet()) {
            if (counts.containsKey(e.getKey())) {
                counts.put(e.getKey(), e.getValue() + counts.get(e.getKey()));
            } else {
                counts.put(e.getKey(), e.getValue());
            }
        }
        for (String link : result.getLinks()) {
            crawlInternal(link, deadline, maxDepth - 1, counts, visitedUrls);
        }
    }
}
*/
