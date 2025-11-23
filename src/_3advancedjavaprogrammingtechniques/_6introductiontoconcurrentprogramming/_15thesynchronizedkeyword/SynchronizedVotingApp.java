package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._15thesynchronizedkeyword;

import java.util.HashMap;
import java.util.Map;

/*
 * If we decide to use the "this" keyword, the lock object is the current instance of the class.
 * If we're using "this" to lock the entire method, we can use this trick instead:
 */
public final class SynchronizedVotingApp {
    private final Map<String, Integer> votes = new HashMap<>();

    public synchronized void castVote(String performer) {
        Integer count = votes.get(performer);
        if (count == null) {
            votes.put(performer, 1);
        } else {
            votes.put(performer, count + 1);
        }
    }
}
