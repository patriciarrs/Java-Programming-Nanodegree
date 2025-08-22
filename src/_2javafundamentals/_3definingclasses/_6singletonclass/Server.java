package _2javafundamentals._3definingclasses._6singletonclass;

import java.util.ArrayList;

/**
 * This Singleton approach will ensure that the object that references the server class will have access to the server's
 * hotelRoom ArrayList.
 * <p>
 * [Sometimes we have a specific use case for a class object using a Singleton Class. This means there will only be one
 * class instance in the JVM. We use the singleton class for utility classes and services when we only want one
 * instance. This class ensures that the state data or methods are shared with all the other objects in the JVM.]
 */
public class Server {
    /**
     * Initialize the only object in Server Singleton class. We are creating a static reference to the class server.
     */
    private static final Server reference = new Server();

    private final ArrayList hotelRooms;

    /**
     * This private constructor prevents the client app from creating the Server class instance. The Singleton class has
     * access to the hotelRooms ArrayList
     */
    private Server() {
        this.hotelRooms = new ArrayList<>();
    }

    // We use the class name to access the server with this method (getInstance)
    public Server getInstance() {
        return reference;
    }
}
