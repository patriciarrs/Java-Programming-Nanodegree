# Maven

- Maven is a build tool (performs the steps of the build process according to a configuration).

# Build Lifecycle Phases

- Maven organizes the build process into **phases** (steps of the build).
- A phase processes the **goals** (actions) attached to it. 
  - The implementation of the goal is performed by a **plugin**.

**Default phases:**

1. **Validate** - validate that the project definition (pom.xml) has a valid syntax and all the resources can be identified.
2. **Compile** - compile the program into class files.
3. **Test** - run unit tests (don't require code to be packaged or deployed).
4. **Package** - package the code into a JAR + run integration tests.
5. **Install** - move the JAR to the local copy of our Maven repo (It's where Maven stores all JARs referenced by our projects).
6. **Deploy** - copy the JAR into a remote repository (to be shared with others).

> Executing a phase will run all the preceding phases.

# Projects

> A Maven project is defined by a pom.xml.

## POM (Project Object Model)

**Minimal POM:**

```xml
<project>
  <!-- Current object model (format) version to be used with Maven-->
  <modelVersion> 4.0.0 </modelVersion>

  <!-- Group identifier of the project -->
  <groupId> com.udacity.jpnd </groupId>
  <!-- Specific identifier of the project -->
  <artifactId> maven-test </artifactId>
  <!-- Version of the artifact (keeps track of project versions) -->
  <version> 1.0.0 </version> 
</project>
```

- `groupId`
  - can be shared with other projects;
  - uses reverse domain notation (~ Java packages).

> `groupId` + `artifactId` → uniquely identifies the project

## Phases & POM

> `mvn <phase>` → runs the desired maven phase

- If we run `mvn package` with the minimal POM, Maven will create a `target` directory containing the JAR.
- The JAR only has the `META-INF` directory with the `MANIFEST.MF` file.

## Create a Maven Project

### Command line

1. `mvn archetype:generate`
2. Press enter to accept the default template (maven quickstart project).
3. Press enter again to accept the newest version of the template.
4. Fill in the required elements of a minimal pom.

Maven will create a new project directory with a `pom.xml` some starter source code and test directories.

### IntelliJ

1. File > New > Project
2. Maven Archetype 
- Archetype: choose from list `maven-archetype-quickstart`
- Advanced Settings:
  - GroupId
  - ArtifactId
  - Version
3. Create