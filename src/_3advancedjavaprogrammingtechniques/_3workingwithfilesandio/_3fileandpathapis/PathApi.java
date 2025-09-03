package _3advancedjavaprogrammingtechniques._3workingwithfilesandio._3fileandpathapis;

import java.nio.file.Path;

public class PathApi {
    public static void main(String[] args) {
        Path p = Path.of(".");

        // Path:.
        System.out.println("Path:" + p);

        // Path:/Users/user/Documents/GitHub/Java-Programming-Nanodegree/.
        System.out.println("Path:" + p.toAbsolutePath());

        // Path:/Users/user/Documents/GitHub/Java-Programming-Nanodegree
        System.out.println("Path:" + p.toAbsolutePath().normalize());

        // Path:/Users/user/Documents/GitHub/Java-Programming-Nanodegree/./..
        System.out.println("Path:" + p.toAbsolutePath().resolve(".."));

        // Path:/Users/user/Documents/GitHub
        System.out.println("Path:" + p.toAbsolutePath().resolve("..").normalize());

        // Path:file:///Users/user/Documents/GitHub/ (used in a browser, it will navigate to that location)
        System.out.println("Path:" + p.toAbsolutePath().resolve("..").normalize().toUri());
    }
}
