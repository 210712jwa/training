# Logging
Logging is the process whereby we can keep track of different events that have occurred during the running of our application. These events are logged in the form of log messages. Log messages can be stored in a file, a database, printed out to the console, sent over to a log aggregation server, etc. Within production applications, logs are useful in order to monitor the health of an application and whether anything unintended is happening as well as helping us to debug issues.

# Logging Frameworks
Logging frameworks are the backbone of our ability to have logging functionality within our applications. They provide various different implementations for accomplishing different logging tasks. Some common logging frameworks include
- Java's built in Logger (java.util.logging)
- Log4J
- Logback (more modern and faster than Log4J)
    - Created by the same developers who made Log4J

# SLF4J (Simple Logging Facade for Java)
SLF4J is an API (Application Programming Interface) that sits on top of our logging frameworks. This dependency provides abstraction for the behaviors that our logging framework should perform. So, if we have a logging framework that is implementing or extending the interfaces/classes from this SLF4J API, we ensure that we can easily plug and play different frameworks into our application. 

Our application will be performing logging by writing application code defined within SLF4J.

# Logback Architecture
Within logback, there are 3 key types of classes to be aware of:
- Appenders: send log messages to their final destinations (console, file, database, etc.)
- Layout: how messages that will be logged are formatted
- Logger: the class that applications interact with to create log messages

# Logging Levels
Not all log messages convey the same urgency. Some log messages might indicate that a big issue has occurred with our application, while other log messages are simply informational or for debugging purposes. Below are the logging levels from highest priority to lowest:
- ERROR
- WARN
- INFO
- DEBUG
- TRACE

We can suppress certain logging messages so that they do not actually get logged to our console, to our log file, etc. For example, we could restrict logging to a certain level and higher. So if I want to omit DEBUG and TRACE messages from being logged, I can choose to log only INFO and higher (WARN, ERROR)