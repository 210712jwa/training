# Spring Test

Testing is an extremely important part of any software development. We want to write tests in order to provide a way of quickly validating whether our application logic is functioning as intended, and if we make changes to our code, that we do not break existing functionality. Spring provides us a module, the `spring-test` module, that makes testing easier with Spring. In particular, Spring test gives features such as allowing us to test a system integrated as a whole through features such as dependency injection and providing an IoC container.

# Unit Testing
When performing unit testing, we are testing components in isolation, with every dependency of that object being mocked rather than utilizing the real object. The only real object that we would have is the **system under test**. By using mock objects that our system under test requires to function, we can test in isolation the logic specific to this unit only. We assume that the logic in the dependencies are fully working as intended by programmatically specifying what we want to method calls to the mock objects to return.

Typically, we utilize Mockito to create most mock objects, but Spring Test also provides other mock objects for us to use as well:
- Environment
    - Spring provides mock implementations of `Environment` and `PropertySource` abstractions:
        - `MockEnvironment`
        - `MockPropertySource`
- Servlet API
    - `org.springframework.mock.web` package
    - Contains Servlet API mock objects for testing web contexts, controllers, and filters
        - We make use of mock Http requests, sessions, etc.
    - These mock objects are intended to be used with a MockMvc object

# Integration Testing
When performing integration testing, we are not testing components in isolation, but rather how they all work together. Since a Spring application is made up of many different Spring bean components that are configured in some manner (xml config, annotation based config, Java class config) to be injected into one another, we need a way to have this wiring handled in our test environment. Spring Test provides support for integration testing, with the following goals in mind:
- Manage Spring IoC container caching between tests
    - Utilize the same bean container between test classes
    - Or we could specify for it to create a new container for each test class
        - `@DirtiesContext`
- Provide dependency injection of different "test fixture instances" (basically the different instances under test, all wired together properly based on our Spring configuration)
- Provide transaction management when appropriate (`@Transactional` for DAO related features)
- Supplies the base classes that help w/ writing integration tests

# Context Management and Caching
What is meant by context management is the creation of IoC containers (contexts). If a project has a large number of beans, other configurations such as 100s of Hibernate mappings, etc., then loading up a new context everytime could potentially take a REALLY long time. If it takes 30 seconds, 1 minute, 5 minutes, etc. for all the contexts to load up for each test class, this would add up to a lot of time wasted on running tests.

Therefore, caching is a way to reuse the same context for each test. The setup cost is therefore incurred only once, and all subsequent test execution occurs much faster. By default, the same context is reused for each test class.

# Dependency Injection of "Test Fixtures"
When we run our tests, we can have Spring Test help to load up our context and then configure instances of our test classes through dependency injection. From there, we can simply `@Autowire` our various fixtures that we would like to test in our test class. This prevents us from having to do a bunch of manual setup ourselves.

# Transaction Management
When utilizing database persistence such as through Spring ORM (coupled with Hibernate, in our case), or Spring Data (often used w/ Spring boot), we need to take into account the impact of changes to the state of our database on future tests. If we have operations such as inserting or modifying data, we cannot do so outside of a transaction.

By default, our transaction management performed by the TestContext framework will create and rollback a transaction for every single test method (`@Test`). So, if we have a test that is testing a DAO method that is intended to delete some data (`shipDao.deleteShipById(1)`), we can choose to have it delete the data, assert to see if the data is deleted (`shipDao.getShipById(1) == null ?`) and the simply rollback the changes when the test is finished. This means the database returns to the prior state before the deletion of the ship with an id of 1. We can however decide to commit the changes as well. (This would then require us to take into account the order in which test methods should execute).

# Spring Test Annotations
- `@ContextConfiguration`: class-level annotation that defines the location of our configuration file (.xml, or Java class config) that should be used to load and configure the IoC container and the various Spring beans that it should have
- `@WebAppConfiguration`: class-level annotation that defines that the context that is created should be a `WebApplicationContext`. This allows us to properly test for request scoped beans, session scoped beans, etc. since those are what we would consider "web-aware" scopes. (`@Autowired private HttpServletRequest request`)
- `@DirtiesContext`: used to indicate that the underlying context(s) have been "dirtied" (modified in some manner) and should be closed and reopened for other tests
    - This is what we use to start from a "fresh slate" for each test class, especially in order to load up a brand new H2 database for each test class that runs (instead of having caching)
- `@Commit`: if annotated on a test method (along with `@Transactional`), used to specify that the database changes should be committed
- `@Rollback`: indicates whether the transaction should be rolled back. By default transactions are already rolled back. We could specify `@Rollback(false)` which is analogous to `@Commit` 

# MockMvc
MockMvc provides support for testing Spring MVC applications. It gives testers the ability to perform request handling through mock request objects and mock response objects rather than running an actual HTTP server (such as Tomcat).

We can utilize MockMvc to perform requests and check if the responses are what we should be expecting.

Common static imports used:
- MockMvcBuilders.*: used to help us build a mockMvc object
- MockMvcRequestBuilders.*: used to help us build mock requests
- MockMvcResultMatchers.*: used to help us assert that certain responses contain the information we would expect
- MockMvcResultHandlers.*

## Unit Testing w/ MockMvc
To set up MockMvc for testing a controller independently (w/ various mock dependencies being passed in with something like Mockito):

```java
class MyWebTests {
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        AccountService mockAccountService = mock(AccountService.class);

        when(mockAccountService.getAccountById(eq(1))).thenReturn(new Account(1, "user", "pass"));

        // We then instantiate the AccountController, passing in the mockAccountService
        // and pass that into the standaloneSetup method to create our mockMvc object
        // that will send mock requests to this controller
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(mockAccountService)).build();
    }

    @Test
    void test() {
        Account expected = new Account(1, "user", "pass");

        ObjectMapper om = new ObjectMapper();
        String expectedJsonResponse = om.writeValueAsString(expected);

        this.mockMvc.perform(get("account/1"))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedJsonResponse));
    }
}
```

# Integration Testing w/ MockMvc
To set up MockMvc utilizing an actual Spring IoC container w/ Spring beans wired and ready for testing together:

Utilizing JUnit 5 (Jupiter)

```java
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
@TestPropertySource("classpath:springorm-test.properties")
@WebAppConfiguration
class MyTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    AccountDao accountDao;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    @Rollback
    void test() {
        // pre populate data for the test
        accountDao.addAccount(new AccountDto("savings", 10000));
        // this will generate an account w/ id 1

        Account expected = new Account(1, "savings", 10000);
        ObjectMapper om = new ObjectMapper();
        String expectedJsonResponse = om.writeValueAsString(expected);

        this.mockMvc.perform(get("/account/1"))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedJsonResponse));
    }
}
```