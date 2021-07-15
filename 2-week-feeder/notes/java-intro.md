# Java
Java is a high-level, compiled, strongly typed, object-oriented programming language.
- High-level: Code that is easily human-readable
- Compiled-language and interpreted language hybrid: Human-readable code (source code) is **compiled**, or transformed, into a form more optimized for computers to read 
    - In the case of Java, source code is compiled into **bytecode**
    - The JVM interprets bytecode
- Strongly-typed: variables declared of a certain type can only have values assigned to it of that same type
- Object-oriented: Java revolves around the use of classes (which are typically used a blueprints for objects), and objects themselves

## Why Java?
- One of the most in-demand languages in the world
- Java has been around for a really long time now 20+ years
- Powering over 3 billion devices
- #1 server-side web technology (backend)

## Benefits
- Platform independent (write once, run anywhere (WORA))
    - Made possible via the JVM
        - We have many different JVMs for different OSes
            - Mac
            - Windows
            - Linux
            - Android
            - etc..
        - The main point is that all of the JVMs understand the same underlying bytecode
- C-language inspired syntax
- Automatic memory management
    - Garbage Collector
        - frees up memory automatically that is not being used
    - The developer does not have to worry about managing memory themselves
- Extensive built-in runtime library
    - libraries included w/ the JRE
- Rich open-source community

# Java 8 Features
Added features such as
- Lambda expressions
- Method references
- Functional interfaces
- Stream API
- Default methods in interfaces
- Collectors class
- etc

# JVM v. JRE v. JDK
In order to write and run Java, we should an appreciation of an understanding of the JVM, JRE, and JDK. In particular, understanding these different components allows us to establish a foundation on waht is means to be using Java.

- JDK (Java Development Kit): Contains the **compiler**, debugger, documentation tools (javadoc), and other command-line utilities + JRE
- JRE (Java Runtime Environment): Contains the runtime libraries that our code may be using + the JVM. If all we want to do is run Java programs, all we need to do is install the JRE.
- JVM (Java Virtual Machine): Enables a computer to run Java programs. It behaves as a bytecode interpreter that translates bytecode to what the computer can understand.

If we want to both run and write programs, we should install a JDK (because it has a compiler). If we only want to run Java programs, we would install a JRE.

## Write Once Run Anywhere (platform independence)
Platform independence is established through the JVM. We really only need to compile the code once from source code into bytecode, which can then be run through the JVM. As long as we have a JVM for the operating system we want to run a Java program on, we will be able to run the same program whether we are on Mac or on Windows, Linux, etc.