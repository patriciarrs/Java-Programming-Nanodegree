package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._15thesynchronizedkeyword;

import java.util.HashMap;
import java.util.Map;

public final class SynchronizedThisVotingApp {
    private final Map<String, Integer> votes = new HashMap<>();

    public void castVote(String performer) {
        /*
         * The thing in parentheses after the synchronized keyword is the lock object.
         * When a thread enters the code block, it takes ownership of the lock.
         * Only one thread at a time can own the lock at a time,
         * so only one thread is allowed to be executing code inside the synchronized block at a given time.
         */
        synchronized (this) {
            Integer count = votes.get(performer);
            if (count == null) {
                votes.put(performer, 1);
            } else {
                votes.put(performer, count + 1);
            }
        }
    }
}

/*
* Any object can be used as the lock.
* For example, we could use the votes map as the lock object:

public void castVote(String performer) {
    synchronized (votes) {
      ...
    }
  }
}

* Or, we could create a completely new object just to serve the purpose of the lock:

private final Object lock = "SpecialLock";

public void castVote(String performer) {
    synchronized (lock) {
      ...
    }
  }
}
*/