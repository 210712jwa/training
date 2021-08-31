# Spring MVC

## What is Spring MVC?
- Spring MVC (or Spring Model-View-Controller) is a framework built around the concept of model, view, controller, that enables web application functionality within the context of Spring
- Based around the Servlet API (DispatcherServlet)
    - DispatcherServlet is the single Servlet that we register with the web server (Tomcat) that will forward HTTP requests to the corresponding classes with @Controller annotations + (@GetMapping, @PostMapping, etc.)
- Controllers act as the entry-point to the core business logic of the application by invoking the service layer, which then invokes the DAO layer, etc.
- There is also another special component called the ViewResolver, which can be used to handle view templates like JSPs, or static files like HTML

For our purposes, we're really only making use of the "Model" and "Controller" part of Spring MVC, not the "View" part. But the "view" part is there to provide server-side rendering of "static resources".

For us, the "View" is handled on the client-side using Angular.

# General Flow of HTTP Requests to Spring MVC
- The HTTP request is sent to the Servlet engine (Tomcat)
- Tomcat creates an HttpServletRequest object and HttpServletResponse object
- Tomcat forwards these objects to the DispatcherServlet
    - `org.springframework.web.servlet.DispatcherServlet`
    - This servlet is configured in our web.xml to be the default servlet that is contacted for all of our endpoints not mapped to any other Servlet (using `/` as the url-mapping)
- From there, the DispatcherServlet consults the `handler mapping`
    - In our case, we're actually making use of the `org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping`
    - We configure this handler mapping in our applicationContext.xml
        - `<mvc:annotation-driven>`
    - Using annotations such as `@GetMapping`, `@PostMapping`, etc. is what provides the handler mapping the appropriate paths
- The handler mapping returns to the DispatcherServlet which Controller to delegate the request to
- The Controller will then receive the request and send a response back to the DispatcherServlet
- The DispatcherServlet will then send the data back to the client in whatever data format is required
    - JSON
    - Images
    - Files
    - XML
    - etc.

# Spring MVC Annotations
- `@Controller`: specifies a class as a controller, which is a special bean used to handle web application requests
- `@RequestBody`: allows spring to map data from the body of a request to a Java object (within the method's parameters)
- `@ResponseBody`: used to convert a Java object into JSON (or some other specified format)
- `@ResponseStatus`: used to mark a method or exception w/ an HTTP response status code
- `@RequestParam`: used to bind "query parameters" `ex: ?amountLessThan=2000` to a variable
- `@PathVariable`: used to bind "path parameters" `ex: /reimbursement/{id}/image` where id is the path parameter, to a variable
- `@RequestHeader`: We can also map a header's value to a variable
- `@RestController`: same as `@Controller`, but implicitly adds `@ResponseBody` to the controller methods