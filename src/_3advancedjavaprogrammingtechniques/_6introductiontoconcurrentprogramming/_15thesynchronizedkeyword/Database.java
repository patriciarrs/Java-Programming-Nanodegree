package _3advancedjavaprogrammingtechniques._6introductiontoconcurrentprogramming._15thesynchronizedkeyword;

import java.util.Objects;

public final class Database {
    private static Database database;

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