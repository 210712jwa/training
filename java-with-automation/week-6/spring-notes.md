# Spring Framework Overview

## Goals
- Lightweight Development with POJOs (Plain Java Objects)
- Dependency Injection
    - Promotes loose coupling
        - Plug and dependencies of a certain type
        - The only thing that you need to change is the configuration itself
        - "Loose coupling"
            - All about being able to "switch out dependencies" easily
            - Not having to hardcode the instantiation of objects
- Minimization of boiler-plate code

# IoC

- Inversion of Control
    - "Inverts" the control of object creation and application flow to a framework
        - Instead of the developer instantiating the objects and passing dependencies around, the framework has the control instead
        - Dependency Injection (DI) is a pattern to implement IoC
            - "Behavior is injected into your classes"
            - Achieves "loose coupling"

![dependency injection](https://docs.spring.io/spring-framework/docs/current/reference/html/images/container-magic.png)

# Dependency Injection
- Implementation of inversion of control
    - Dependency: some object another object needs to function properly
        - ex: ShipService depends on ShipDao to operate correctly
    - Injection: passing a dependency to a dependent object
    - When a Spring bean is instantiated, any dependencies that it requires will be provided through DI (given that those dependencies are also configured as Spring beans)
    - Decouples configuration from implementation
        - "We configure outside of the code, not inside of it"

# Spring Bean
- Any object whose lifecycle is managed by Spring (the IoC container)
- We specify through configuration what should be a Spring Bean
    - 3 types of configuration:
        - XML configuration
        - Annotation configuration
            - `@Controller`: part of the Spring MVC module that is used to indicate a special controller bean
            - `@Component`: to register any "generic" spring bean
            - `@Service`: to register a spring bean that is a Service layer object
            - `@Repository`: to register a spring bean that is a DAO (adds additional configuration if we're using a module such as Spring ORM)
            - `@Autowired`: to inject
        - Java class-based configuration
            - `@Configuration`
            - `@Bean`

# Modules
- Core container: The core functionalities of Spring for creating beans, managing bean dependencies, and providing dependency injection
    - Beans: spring-beans module
    - Core: spring-core module
    - Context: spring-context module
    - Expression: spring-expression module

The `Core` and `Beans` modules provide the fundamental parts of the Spring framework, such as IoC (inversion of control) and DI (dependency injection). **BeanFactory** is included as part of these two modules and it is an implementation of the factory design pattern, which removes the need to create programmatic singletons and enables the decoupling of configuration and specification of dependencies from within the program logic itself.

The `Context` module builds on top of the Core and Beans modules and allows access to objects in a modern framework-stye manner using annotations. Context is what provides us with `ApplicationContext`, which extends BeanFactory.

- Additional Modules:
    - Web module: allows us to utilize Spring MVC functionality (such as controllers)
    - AOP module: aspect oriented programming, we will look at this as well
    - ORM module: allows us to integrate ORMs such as Hibernate more intricately into our project
    - Test module: provides different features to easily perform integration tests and DAO layer tests with an actual database (H2 in-memory database instead of our MariaDB database)
    - etc.

# Spring Projects
Spring projects are built on top of these different modules that make up Spring framework. These are "boiler-plate" projects that help us to easily build Spring applications.

- Spring Boot
- Spring Data
- Spring Security
- Etc.

# BeanFactory v. ApplicationContext
Both BeanFactory and ApplicationContext represent an IoC container, which manage the lifecycle of Spring beans.

## BeanFactory
- Older
- Lazily instantiates Spring Beans
    - Only instantiates a bean when it is absolutely required/requested
- Must provide a resource object configured for our `beans.xml`

Example implementation: `XmlBeanFactory`
```java
BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
```

## ApplicationContext
- Newer
- Eagerly instantiates Spring Beans
    - All of our beans are created immediately when the application starts up
- **Provides support for annotations**
- Naming convention changed from `beans.xml` to `applicationContext.xml`
- Sub-interface of BeanFactory
- Easier integration with Spring AOP
- Support for application-layer specific contexts such as `WebApplicationContext`

Example Implementations:
- ClassPathXmlApplicationContext
- FileSystemXmlApplicationContext
- XmlWebApplicationContext
- etc.

# Configuration
- XML Config
    - Our configuration is defined in `applicationContext.xml`
    - We can specify
        - beans that we want to have instantiated and configured
        - whether we want component scanning (annotation scanning)
        - etc.
- Annotation Config
    - Enable "Component Scanning" in our applicationContext.xml
    - Annotate classes w/ "stereotype annotations"
        - `@Component`: generic Spring bean
        - `@Repository`: for DAOs
        - `@Service`: for services in service layer
        - `@Controller`: for our HTTP controllers in the controller layer
- Java Class Config
    - Utilize the `@Configuration` annotation to designate a class as a configuration class
    - Use `@Bean` on each method inside of this class that should be instantiating and configuring a bean
        - The method name is the name of the bean itself
        - `@Bean` is a special annotation that intercepts the method call to check if the bean already exists or not inside of the IoC container
            - If it already exists, it does not execute the method, it instead just returns from the container the current bean
            - If it does not exist yet, then the method executes whereby the bean will be instantiated with the `new` keyword and any configurations performed before returning the bean

# Bean Scopes
Scopes determine how many instances of a particular Spring bean we should create and have at any particular time. This depends on the context in which they are used, which is why this is referred to as "scope".

- Universal Scopes
    - Singleton (default): There is only 1 instance of a bean
    - Prototype: There will be a new bean instantiated each time it is requested
- Web-Aware Scopes
    - Request: One per HTTP request
    - Session: One per HTTP session
    - New as of Spring 5
        - Application: One per ServletContext (per web container)
        - WebSocket: One per websocket
    - Now deprecated
        - Global session: was used for Portlets (no longer used)

# Bean Wiring
- There are many different ways we can wire dependencies together
- Bean wiring is the process of connecting our beans using dependency injection (DI)

## Setter Injection
- Uses setter methods to provide dependencies
- Does not ensure successful DI because an instance must be created before using the setter to provide the dependency
    - This means we could potentially have a spring bean that did not actually have its dependencies provided
    - One solution to this issue with setter injection is to utilize the `@Required` annotation to make sure that there is actually a dependency provided
        - Would prevent `NullPointerException` issues down the road
- Con: not ensured that we will have dependencies available
- Pro: allows us to provide dependencies later because some dependencies might be slow to instantiate and we might not necessarily want to wait for all of those to instantiate first

## Constructor Injection
- Uses a constructor
    - We provide to the constructor the necessary dependencies
- Con: if the dependencies take a long time to instantiate, this bean is not available until all of those other dependencies are also available
- Pro: This ensures that the bean cannot be instantiated without the proper dependencies being injected

## Field Injection
- `@Autowired` directly on top of the field itself
    - Keep in mind, that Autowired can also be placed on setters and constructors to perform constructor/setter injection
- Special because it utilizes Java Reflection under the hood, not constructors or setters

```java
@Autowired
private IMyService myService;
```

# Autowiring
Autowiring in general uses the `@Autowired` annotation. You can place this on fields directly, in which case we would be utilizing `field injection`, or you could place it on constructors/setters for constructor or setter injection.

There are 2 different types of Autowiring:
- By Type (default)
    - Spring will "automagically" perform DI based on the type of dependency

```java
public class BeanA {
    private BeanB beanB;

    @Autowired
    public void setBeanB(BeanB myBean) {
        this.beanB = myBean;
    }
}
```

- By Name
    - Spring will "automagically" perform DI based on the name of the dependency

```java
public class BeanA {
    private BeanB beanB;

    @Autowired
    @Qualifier("myBean") // Spring looks for a bean of the name "myBean" to inject, not the type
    public void setBeanB(BeanB myBean) {
        this.beanB = myBean;
    }
}
```

- `@Qualifier` annotation: if we have more than one bean of a particular type, and we use `@Autowired`, Spring would not know which one to inject. So we could use this annotation to distinguish between beans of the same type by name.