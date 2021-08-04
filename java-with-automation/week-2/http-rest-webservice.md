# Overview

## What is an API?
API stands for Application Programming Interface, which is an interface (not to be confused with OOP interfaces) that enables two applications to interact with each other according to a collection of software functions and procedures. An API is essentially software code that can be accessed and executed.

For example, think of the different features in Java we have used or looked at:
- String API
- Collections API
- Thread API
- JDBC API

The above are built into Java, so they're basically what we would call APIs "internal" to Java itself. But we also have external APIs that we have already made use of, such as the SLF4J API, or the JUnit API (for writing unit tests).

Even more than the above examples, we can also consider **web services** as being APIs themselves. On the PokeAPI website, we have many different endpoints that allow us to send requests and receive responses that contain a lot of data about Pokemon over HTTP. In particular, PokeAPI is an example of a REST API in which we can send a request to retrieve data in the form of a JSON response.

- GET https://pokeapi.co/api/v2/pokemon/ditto
    - We can "invoke" the functionality that retrieves the information about a specific pokemon

As an analogy, this is almost like methods in Java, just more complex behind the scenes with different software layers (controller, service, dao), HTTP communication and processing, client-server networking, etc. We send a request (input) and receive a response (output). Similarly, methods in Java take arguments, and RETURN some data.

So, API is basically a general term for software that we utilize through other pieces of software. When we build a web application / web service, we are building an API that other applications can use. For example,
- HTML/CSS + JavaScript frontend
    - JavaScript is the programming language itself for the frontend application
    - We can utilize JavaScript to send HTTP requests to a backend, receive data back, populate the web page with that data, etc.
- In Project 0, we just use Postman as our "frontend" application

# Web Service
The application / API we are building in Project-0 is a **web service** that utilizes HTTP for communication. We establish a **client/server** relationship between this P0 application and Postman.

The idea of a web service is to provide a common platform that allows many different applications built on many different programming languages to communicate with each other. For example, you could have a JavaScript application send and receive data from another application written in Java. You could even have this Java backend application communicate with another backend application written in Python. These web services typically utilize HTTP for communication as well as RESTful standards in current modern development.

We have two types of web services that are in common use today:
1. SOAP (Simple Object Access Protocol) web services
    - Old and typically not utilized anymore, except for in old legacy applications
    - Data is transferred in the form of XML
        - Uses the idea of messages that contain
            - A header
            - A body
    - Uses HTTP
2. RESTful web services
    - Lightweight, maintainable, and scalable way of building modern web services
    - Uses primarily JSON to structure data (in the past XML might have been used)
    - Uses HTTP
    - REpresentational State Transfer
    - Key elements:
        - Requests
            - a. Resources: specified within the URI
            - b. Request Verbs: GET, POST, PUT, DELETE, PATCH, etc.
            - c. Request Headers: metadata send with our request, such as the type of data we are sending
            - d. Request Body: data sent with the request
        - Response
            - a. Response Headers: metadata sent with the response
            - b. Response Body: data sent with the response
            - c. Response status codes

# HTTP
HTTP stands for HyperText Transfer Protocol. It is a widely used protocol to transfer information over the internet.

HTTP is structured in the form of requests/responses. In HTTP, the client is always the one sending a request, then receiving a response from the server.

## Request
- Request Headers
    - Headers come in the form of key - value pairs
    - ex. Content-Type: application/json
        - This is basically signifying to the server recieving the request, that there is information being sent from the client in the form of JSON. This allows the server to prepare to know what to do with that JSON (ex. deserializing the JSON into a Java object)
- URI
    - Destination of the request
    - The path should contain the resource itself, if we are conforming to RESTful standards
        - ex. GET /ship
    - This could also contain path parameters
        - ex. GET /ship/1 (1 is the path parameter)
- Query Parameters
    - Additional information that is being sent with the request
    - Not to be confused with the path itself
    - These parameters are structured in the form of key-value pairs
    - They are separated from the path via a `?`
        - ex. GET `/ship?ageLessThan=100&ageGreaterThan=50`
- HTTP Version
- Request Body
- HTTP Method/Verb
    - Information about the goal of the request
    - Examples
        - GET: retrieve information
            - ex. GET `/ship` to get all ships
            - ex. GET `/ship/1` to get ship with id 1
        - POST: add a resource (or send information)
            - ex. POST `/ship`
        - PUT: update a resource (all of the information about that resource)
            - ex. PUT `/ship/1`, and in the body provide the name and age I want to update for this resource
        - DELETE: delete information
            - ex. DELETE `/ship/1`
        - PATCH: partial update
        - HEAD: same as GET, but does not return a response body, just information in the headers

## Response
- Response Headers
- HTTP Version
- Response Body
- Response Status Codes
    - 1XX series
        - Informational series
    - 2XX series
        - Successful
        - 200 OK
        - 201 Created
        - 202 Accepted
        - 204 No Content
    - 3XX series
        - Redirections
        - 300 Multiple Choices
        - 301 Moved Permanently
        - 307 Temporary Redirect
        - 308 Permanent Redirect
    - 4XX series
        - Client Side Errors (the client provided invalid or incorrect information, etc.)
        - 400 Bad Request
        - 401 Unauthorized
        - 403 Forbidden
        - 404 Not Found
        - 418 I'm a Teapot
    - 5XX series
        - Server Side Error (from the standpoint of a backend developer, these should generally be avoided)
            - 5xx errors occur in the cases where you have some kind of unhandled exception, for instance. If it propagates all the way up to the HTTP response handling methods without ever having been handled, it will default to 500
        - 500 Internal Server Error
        - 501 Not Implemented
        - 502 Bad Gateway
        - 503 Service Unavailable

### Rule of Thumb: Avoid having unhandled exceptions, which will result in 500 responses
We typically get a status code of 500 if some sort of exception occurs in our code that is not being handled. We should avoid this by making sure to handle all possible exceptions that could occur and then defining an actual response code such as 404, or 400, etc. In Javalin, we do this through **exception mapping** (because Javalin abstracts away all of the exception handling for us). But in other cases, we would have a try-catch, and inside the catch block, set the response status to whatever it needs to be set to.

An example would be whenever we throw the ShipNotFoundException when we try to edit a ship with an id of 10000 (for example, which doesn't exist). This exception, if not handled, would result in a 500. But we clearly want this response code to be 404.

# REST
- REpresentational State Transfer
- The main concept of REST is to represent everything on our backend server as a resource
- There are many different constraints with REST. These are guidelines that should be followed to have a truly RESTful application.
- REST Contraints:
    - i. Stateless
        - The server should not save information (state) about a previous request
        - We might need to violate this constraint if we are implementing login functionality. Login functionality might be achieved through HttpSessions, which is a way to manage state about who sent previous requests to the server (this wouldn't be stateless).
        - Applications we build should generally follow some sort of RESTful conventions, with some tweaks here and there potentially
    - ii. Cacheable
        - If requests occur often enough for the same resource, there should be some ability to have caching for improved performance
        - So, for example, instead of "hitting" the database each time we GET a resource, we might want to cache the resource on the server itself
            - With JDBC/Javalin alone we can't really do this, but as we continue to learn more in future weeks, this is doable with Hibernate.
    - iii. Uniform Interface
        - This is referring to the URI structure along with having a consistent structure for JSON responses
        - We should have familiar patterns in the response for different requests
    - iv. Client/Server relationship
        - The API should have some sort of relationship with a client that is using it
        - As resources are changed/added/deleted/etc., we can have some sort of "dynamic" behavior between the two sides.
    - v. Layered Architecture
        - The web service/API could be structured as many different servers that communicate to each other
        - But all of this complexity should be hidden from the end-user of the API
        - The API should function as if the end consumer is only aware of a single destination, even if there are many "nested" layers of servers behind the scenes
    - vi. Code on Demand (Optional)
        - The server should be able to send some code on demand for the client to execute
        - Code can be represented as a resource
