# Javalin
Javalin is a lightwieight, "simple web framework for Java and Kotlin". Javalin allows us to receive HTTP requests, invoke some Handlers for these requests, and return HTTP responses.

Behind the scenes, Javalin includes an embedded webserver application known as Jetty. Jetty is a servlet based webserver (so behind the scenes, Javalin also makes use of Java Servlets). Javalin is essentially an abstraction on top of Servlets, which are generally considered more complicated to directly work with. So, Javalin allows us to very quickly start up and create a Java-based backend application with support for HTTP.

## HTTP Handlers
`Handler` is a functional interface in Java that is responsible for containing the logic that should be executed upon the receipt of a request to the Jetty webserver. We first need to map endpoints based on certain URIs that we want to be invoked based on certain HTTP methods.

```java
Javalin app = Javalin.create();

Handler helloHandler = (ctx) -> {
    pirateDao.doSomething(); // let's imagine this method throws a checked exception

    System.out.println("test");
};

app.get("/hello", helloHandler);
```

The above example will print out "test" to the console whenever we send a GET request to the `/hello` endpoint. Because Handler is a functional interface, we can define the logic that should be executed inside of a lambda expression. This lambda expression has a parameter of the type `Context`, which is responsible for helping us to retrieve path parameters, information from the request body, set the status code of the response, set the response body, etc.

## Exception Mapping
Javalin provides to us the ability to do what is known as `exception mapping`. This is different than what you would think of when we are actually handling exceptions via a `try-catch` block. The way that exception mapping works is that we create objects known as `ExceptionHandler` objects.  `ExceptionHandler` is a functional interface that defines an abstract method that has two parameters, the Exception object itself, and the Context object. Whenever we encounter an exception that is thrown up to our normal `Handler` object, this will then go over to the "plumbing" behind the scenes that Javalin has, and make its way over to the ExceptionHandler mapping. From this ExceptionHandler, we can then specify what sort of status codes, etc. that we want to set whenever this particular exception is encountered.

To clear up a possible misconception, it is important to understand that Exception Mapping is a feature of Javalin, and not of Java itself.

### Example

```java
Javalin app = Javalin.create();

private ExceptionHandler<ShipNotFoundException> shipNotFoundExceptionHandler = (e, ctx) -> {
    logger.info("ShipNotFoundException occurred from " + ctx.method() + " " + ctx.path() +  ". Message is " + e.getMessage());

    ctx.status(404); // 404 is "Not Found"
    
    ExceptionMessageDTO messageDTO = new ExceptionMessageDTO();
    messageDTO.setMessage(e.getMessage());
    
    ctx.json(messageDTO);
};

app.exception(ShipNotFoundException.class, shipNotFoundExceptionHandler);
```
