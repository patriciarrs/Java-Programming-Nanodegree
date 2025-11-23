package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._15thesynchronizedkeyword;

import java.util.Objects;

public final class Database {
    /*
     * The `volatile` keyword ensures that changes to a variable are always visible to all threads.
     * When a variable is declared as `volatile`, reads and writes go directly to main memory, preventing threads from caching its value locally.
     * This is important for variables shared between threads, like the `database` instance in your singleton pattern, to avoid seeing stale or inconsistent values.
     */
    private static volatile Database database;

    private Database() {
    }

    /*
     * public synchronized static Database getInstance() {
     *
     * This isn't that great because it means if multiple threads called the getInstance method at the same time,
     * only one will get through and the rest will have to stop and wait for their turn,
     * even if the database has already been initialized.
     */

    public static Database getInstance() {
        /*
         * This is generally better for performance than synchronizing the entire method or always synchronizing the block,
         * because it only synchronizes when the instance is actually being created.
         *
         * synchronized (Database.class) {
         *  if (database == null) {
         *   database = new Database();
         *   database.connect("/usr/local/data/users.db");
         *  }
         * }
         * will synchronize every time `getInstance()` is called, even after the instance is initialized, which can hurt performance in multi-threaded scenarios.
         */
        if (database == null) {
            synchronized (Database.class) {
                if (database == null) {
                    database = new Database();
                    database.connect("/usr/local/data/users.db");
                }
            }
        }
        return database;
    }

    // Connects to the remote database.
    private void connect(String url) {
        Objects.requireNonNull(url);
    }

    public static void main(String[] args) {
        Database a = Database.getInstance();
        Database b = Database.getInstance();

        System.out.println(a == b);
    }
}