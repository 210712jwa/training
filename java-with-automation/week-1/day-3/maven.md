# Maven

Maven is a dependency manager **AND** build automation tool for Java programs. Maven project configuration and dependencies are handled through a file known as the `pom.xml` file. POM stands for Project Object Model. This file contains information about the project, including project dependencies and various Maven plugins we may be utilizing.
- `<properties>`: Where we can put various project specific settings, such as the version of Java we're using
- `<dependencies>`: Where we can put the various Maven dependencies we are using

# What is a Dependency?
Dependencies in Maven are just other Maven projects that happen to have been published onto a repository such as Mvnrepository. Whenever we place the settings for dependencies we want into our pom.xml, Maven will automatically go to grab those dependencies. This allows us to make use of the various classes and interfaces that exist for that particular dependency. For example, we have utilized JUnit, Logback, and SLF4J, as well as Javalin.

Dependencies in general in programming just refer to anything that a piece of code depends on. For example, if a method of a particular class depends on another object's methods, this other object is a dependency.

# Maven Build Lifecycle
The Maven build lifecycle is a series of phases that we have to sequentially pass through in order to reach the next step. If any step along the way fails, that particular build is considering failing. We can manually invoke a build by typing `mvn <phase name>`. This will execute all steps up to that particular phase. For example, commonly used is `mvn package` in order to create a JAR or WAR file that can be deployed to some server that we will be running our application on.

There are 8 different phases:
1. Validate: ensures that project settings and dependencies are all available
2. Compile: compile the source code into bytecode. Every .java file inside of our /src folder gets compiled into bytecode that is then placed inside the /target folder
3. Test: runs any tests that are present as part of the project. Tests must all pass in order for this phase to pass
4. Package: bundles our bytecode (.class files) into a JAR or WAR file
5. Integration: runs any integration tests
6. Verify: verify that integration tests were successful
7. Install: installs the project (JAR/WAR file) to our local repository
8. Deploy: push the project from the local repository to the remote repository