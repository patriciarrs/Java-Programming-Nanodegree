# What is a Module

A Module is a JAR.

Modules contain:

- classes in packages;
- `META-INF` directory with `MANIFEST.MF` - declares class metadata;
- `module-info.java` = **Module Descriptor**:
  - indicates which packages the module makes available, and which modules this module relies on;
  - at the top level of the `src/main/java` directory.

# Defining Modules

## Keywords

`module-info.java`:

```java
module com.udacity.jpnd.module1 {
    exports com.udacity.jpnd.module1.somepackage;
    requires com.udacity.jpnd.module2;
}
```

- `exports` - `com.udacity.jpnd.module1.somepackage` should be available to users of this module (does not include
  subpackages).
  - Compile-time access.
- `requires` - makes the packages in `com.udacity.jpnd.module2` module available in `com.udacity.jpnd.module1`.
  - Circular dependencies will not compile.

## Additional Keywords

`module-info.java`:

```java
module com.udacity.jpnd.module1 {
    exports com.udacity.jpnd.module1.publicpackage;
    exports com.udacity.jpnd.module1.internalpackage to com.udacity.jpnd.module3;

    opens com.udacity.jpnd.module1.somepackage to some.unit.test.framework;

    requires transitive com.udacity.jpnd.module2;
}
```

- `to`: modifies `exports` to limit which modules can access the specified package.
- `transitive`: modifies `requires` to specify that the required module will also be made available to any other module
  that include `com.udacity.jpnd.module1`.
- `opens`: Makes `com.udacity.jpnd.module1.somepackage` available for both public and private class reflection access.
  - Runtime access.
  - Can use the `to` keyword to limit which modules have this access.

![Access Provided By Commands](images/compile-vs-runtime-access.jpg "Access Provided By Commands")

## Java Service Provider Interface ([SPI](https://docs.oracle.com/javase/9/docs/api/java/util/ServiceLoader.html))

A way for Java to dynamically discover and load implementations for a specified interface.

```java
// Service Provider
module module1 {
    exports module1.somepackage;
    provides module1.somepackage.MyInterface with module1.somepackage.MyInterfaceImpl;
}

// Service Consumer
module module2 {
    requires module1;
    uses module1.somepackage.MyInterface;
}
```

- `provides`/`with` (service provider)
- `uses` (service consumer)

# Module Types

## CLASSPATH
 - Before modules;
 - Where the compiler looks for all class files.

## MODULEPATH
- With modules;
- Where the compiler looks for all modules.

## Unnamed Module

- All Java applications compiled in Java 9+ use the module system.
- Even if they contain no modules and do not use a module descriptor, everything placed on the CLASSPATH is placed into the Unnamed Module.

![Modules are added to the MODULEPATH and some JAR is added to the CLASSPATH](images/unnamed-module.jpg "Non-modular Jars Become Part of Unnamed Module")

## Automatic Module

- **Unnamed Module** cannot access content in **Names Modules**, because it cannot use the `requires` statement.
- **Named Modules** cannot access the **Unnamed Module**, because the **Unnamed Module** cannot be referenced by `requires`.

The solution to this problem is **Automatic Module**.

**Automatic Modules** are created by placing non-modular jars on the MODULEPATH.

![Requiring Automatic Module](images/automatic-module.png "Requiring Automatic Module")

If the project has dependencies, they can be placed on the MODULEPATH so that they become automatic modules which we can reference by name in the module descriptor.

MANIFEST.MF:
```mf
Manifest-Version: 1.0
Build-Jdk: 14.0.1
Automatic-Module-Name: com.udacity.CoolLib
```

The default name of automatic modules is the name of the jar (`CoolLib` in this case), but that name can be overridden by the `Automatic-Module-Name` property in the JAR Manifest.
We can then reference the module using `requires`.

module-info.java:
```java
module mymodule {
    requires com.udacity.CoolLib;
}
```

## Module Access

|            | Named Module        | Unnamed Module        | Automatic Module              |
|------------|---------------------|-----------------------|-------------------------------|
| Created By | `module-info.java`  | Jar on CLASSPATH      | Jar on MODULEPATH             |
| Exports    | In `module-info`    | n/a                   | Everything                    |
| Opens      | In `module-info`    | n/a                   | Everything                    |
| Requires   | In `module-info`    | n/a                   | Everything                    |
| Can Access | Named and Automatic | Unnamed and Automatic | Named, Unnamed, and Automatic |