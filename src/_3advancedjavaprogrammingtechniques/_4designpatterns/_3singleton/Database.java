package _3advancedjavaprogrammingtechniques._4designpatterns._3singleton;

import java.util.Objects;

/*
 * We may want to use a singleton if:
 * - A class that has only one instance, but no clear owner.
 * - We want that instance to be available everywhere in your code.
 * - The instance is initialized only when it's first used (a.k.a. lazy initialization).
 */

/*
 * Disadvantages of Singletons
 *
 * - Can cause brittle assumptions in the code. If later on, we decide we need multiple instances of the class, we might have to refactor a bunch of code.
 * E.g.: Eventually we decide we need a testing environment in addition to the production environment - we'll create a separate database for the testing environment,
 * but then we need 2 different database instances (we might end up rewriting a lot of code to account for the new database).
 *
 * - Code that depends on singletons can become hard to test.
 * E.g.: All the clients get an instance of the singleton through the same static factory method.
 * What happens if we're writing a test for that client, and we want to use a fake database?
 * For cases like this, we should consider using dependency injection to manage your singletons.
 */

/**
 * The Database class is final - it can't be extended.
 * <p>
 * If clients were able to create a database subclass, they would be able to create more database instances.
 */
public final class Database {
    private static Database database;

    /**
     * Private constructor: the point is to ensure that there's only every one instance of the database.
     */
    private Database() {
    }

    /**
     * If we compare the a and b references for equality, they should be the same.
     * <p>
     * We're using the equality operator instead of the equals() method - this proves that when we call the
     * getInstance() method twice, the exact same instance is returned.
     */
    public static void main(String[] args) {
        Database a = Database.getInstance();
        Database b = Database.getInstance();

        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
    }

    /**
     * The Singleton is lazily initialized: the database connection is only established once the getInstance() method is
     * called, and the connect() method won't be called again the next time we call getInstance().
     */
    public static Database getInstance() {
        if (database == null) {
            database = new Database();
            database.connect("/usr/local/data/users.db");
        }
        return database;
    }

    // Connects to the remote database.
    private void connect(String url) {
        Objects.requireNonNull(url);
    }
}