# Testing

# What is Testing?
Testing is about analyzing a software item to detect the differences between expected and actual conditions.
- Expected: This is what you are expecting to happen if you are following business requirements
- Actual: This is what is actually outputted when you perform the action (such as executing a method)

Testing is about finding bugs in your code.
- Bug: unintended functionality for a piece of software
    - Bugs can be hard to detect
        - Edge cases: rare inputs that could result in a particular execution path that produces an output that is not something that is expected
    - Most of the time, the code might be functional and work well, but then there's certain cases that it does not
    - As a tester, you should try to think of various edge cases where things could go wrong
        - Prevent catastrophic issues
        - Or just minor bugs
- Error: a misunderstanding of the requirements
    - Relates back to the business
    - Developers are given a set of requirements to implement
    - If they do not conform to the requirements, it is an "error"
    - As a tester, you should write test cases that conform to the requirements rather than the code that the developer wrote
        - If you follow TDD, the developer will have to write code around the tests anyways

# Testing Pyramid
- Unit Testing (base of the pyramid)
    - Most "micro" level of testing
    - Test each unit alone without relying on their dependencies
        - This means we should mock anything that the unit depends on
        - Usually we use Mockito for this purpose
        - ex. UserService depends on UserDAO, but because only want to test the logic specifically inside of a method in UserService, we mock UserDAO to remove this reliance for our test
    - JUnit 4, Jupiter (JUnit 5), TestNG
- Integration Testing (middle)
    - Test all of the components together
        - You are testing everything "integrated" together
    - Besides testing the logic specifically to individual units, we need integration testing in order to test if they work together properly
    - Spring Test
        - Provides us with features that will configure our Spring beans and inject dependencies into our beans
        - This allows us to actually integrate everything together and test the functionalities
    - Other tools
        - MockMvc: mocking HTTP requests being sent
        - H2 database: in-memory database for performing actual testing of the DAO layer integrated with everything else
            - "you can't test the DAO layer without a database"
- System Testing / E2E Testing (top)
    - Test the entire application as a whole
        - Client side (frontend) -> server (backend) -> database
    - Make sure that the entire application works based on how a user would interact with the application
        - In order for the user to be able to perform a certain feature, the frontend, backend, and database need to be properly working
    - Selenium
        - Automates browsers by interacting with a webpage
            - THAT IS ALL Selenium DOES
        - We need to utilize Selenium with a test framework such as JUnit, Jupiter, or TestNG to assert that certain results are happening according to requirements
            - ex. if you type in a invalid username and invalid password, we would then assert that 'invalid username or password' pops up on our webpage
            - ex. if you successfully log in, you should assert that they reach a certain page with certain elements on the screen (some kind of user portal landing page, for example)
- UAT: User Acceptance Testing
    - Test that all requirements / user stories are met
    - We want to simulate being the end-user to guarantee that users can realistically perform the actions that they are supposed to
    - Two-forms: Alpha & Beta Tests
        - Alpha testing is performed usually "in-house"
            - Usually your own employees (testers) or contractors will be performing this testing
        - Beta testing is generally performed out-of-house (actual end-users)

# Types of Testing
- Positive & Negative testing
    - Positive: testing out the functionality according to what an end user should ideally be doing (used correctly)
        - Called the "happy path"
        - For example, test to see if our controller has a 200 status code when we supply a correct username and password in the HTTP request 
    - Negative: testing out the functionality according to what should happen when a user utilizes a feature incorrectly
        - For example, testing to see if our controller returns a 400 status code when we supply incorrect credentials
- Functional testing: any test that validates the actions your application must perform
    - Exploratory testing: we assume that the requirements and validations are based off of the current behavior of the application
    - Exhaustive testing: testing every possible case for our application
        - Every possible combination that a user could make, such as different combinations of button clicks to see if a particular sequence results in something unintended
        - Not really feasible
            - So the idea here is to try to cover 99.9% of the cases that could reasonably happen from a user standpoint
    - Boundary testing: testing the extremes of our application
        - min, max, min + 1, max - 1
    - Equivalence partitioning: divide up test-values in some equivalent manner (intervals)
        - ex. every 25 numbers
        - Negative, Zero, and Positive numbers
- Non-functional testing: Ensuring that the application does not have vulnerabilities
    - Performance Testing:
        - Load Testing: Examine how the application behaves under certain loads of connections
            - Anticipated/expected load
        - Stress Testing: Exame how the application behaves under near maximum load
            - Sometimes oven overload the application to see if/how it breaks
        - Spike Testing: How does the application behave with a sudden increase in user count
        - Ramp up/ramp down: Gradually increase/decrease load
    - Usability testing
        - Is the application even possible to use?
        - White background w/ white text
            - Selenium could definitely read the text from an element
            - But a human could not!
- API Testing: testing to make sure that the application sends and receives data correctly
- Re-testing: re-running tests on functionality that failed before to confirm that a defect is fixed
- Regression-testing: run old test-suites to ensure that newly added functionality does not break old functionality. We want to make sure that our application does not "regress".
    - In an actual company environment, it is not always feasible to constantly re-run all of the tests for old features
    - Regression-testing can be expensive, especially for E2E tests, because a lot of E2E tests might not be automated (not using something like Selenium). Some tests are manual and require manual testing by testers. Automated E2E tests can also be slow (compared to unit tests and integration tests)
- Smoke Testing: Testing used in order to verify critical functionalities of the application
    - We could categorize various tests as "smoke tests" (especially if we are using a test framework with a lot of configuration features such as TestNG to be able to run smoke tests specifically)
    - Performed in order to prevent the test team from having to waste time on running more sophisticated and comprehensive tests when we already know that critical functionality is broken
- Sanity Testing: Testing to see if newly developed functionality works
- Testing Automation: Perform functional tests using automated scripts to create, execute, and track tests in order to save time and provide test consistency
- Manual Testing:
    - We test functionality of the application manually
    - How to:
        - Read and understand guidelines that have been written by the testing team
            - Come from documents
        - Draft test cases
            - Based on software specification/requirements
        - Review test cases w/ team lead
        - Execute test cases
        - Report defects
            - Standardized process
        - After the defects are fixed, verify that they are fixed
    - Documents
        - Test strategy document: here we detail how the team handles testing in general
            - Deals with the process for how much testing should actually be done
            - Specify what document and verifications are needed to show that what has been done is what is expected
        - Test plan document: detail how you will test a specific project
            - What processes and conditions are to be utilized for the current project
        - Test case document: detail all specific test cases
        - Requirements Traceability Matrix (RTM): this document details the different requirements / user stories and links them to the various test cases that we have
        - Level of Effort document:
            - Details the test strategy, test plan, RTM, test summary documents
- Black-box testing: these are tests where the code is not really known to the tester
- White-box testing: these are tests that are based off of knowledge of the code that was written
    - Where we aim for code coverage
    - Important: don't write tests simply for the sake of code coverage
        - It is more important to test what is important

# Defect Lifecycle
- Defect: the result of a failed test
    - Bug: application behaves in a manner that it should not
    - Error: misunderstanding of requirements
- Feature v. Defect
    - Defects can be viewed as a problem
    - In the testing world, features are additional functionality that was not requested
- Lifecycle:
    - i. Open a defect (submitting some sort of ticket in a system such as Jira, etc.)
    - ii. Assign a developer to fix the defect
        - If the developer says that it is not a defect, then the defect is closed
    - iii. Developer fixes the defect
    - iv. Tester will retest to see if the defect is fixed, otherwise go back to step ii
    - v. Close the defect

# Defect Reports
- While reporting a bug to the developer, sometimes the report will contain the following:
    - Defect ID: some unique ID for a defect
    - Defect desription: detailed info about the defect
    - version
    - Steps: steps to follow the replicate the defect
    - Date
    - Reference: other documents (screenshots, images, etc.)
    - Detected By
    - Fixed By
    - Date closed
    - Severity
        - Impact on system's functionality
    - Priority
        - Urgency in which defect needs to be fixed
    - Test Data (if any)
- Severity & Priority
    - High Severity & High Priority: Users cannot log in
    - Low Severity & High Priority: Another company's logo is being displayed instead of your own
    - High Severity & Low Priority: a feature that is broken that is not used by many users
    - Low Severity & Low Priority: Certain colors are not displaying as expected

# Software Testing Lifecycle
There are many different steps to the software testing lifecycle. You can think of this as the "test" phase in the software development lifecycle, which we have covered when talking about Agile and Scrum.

1. Requirement Analysis: determine what can/should be tested
    - Example:
        - 90% code coverage for the service layer
        - 50% code coverage for the DAO layer
        - E2E tests for login, registration, and basic user actions
2. Test Planning:
    - Senior QA will determine cost estimates and ahve a test plan created
3. Test-case development:
    - Create and develop test-cases and scripts for automated tests
4. Test environment setup:
    - We want to have consistent conditions (a certain OS, a certain browser, etc)
5. Test execution:
    - Execute the tests according to the test plan
    - Map defects to test cases in the RTM
    - Follow the defect lifecycle
6. Test cycle closure:
    - Testing team will meet and talk about how testing cycle went

# Miscellaneous Topics
- Verification & validation
    - Verification: Am I making the right application?
    - Validation: Have I made the right application?
- What should I test?
    - Bad answer: "everything"
        - Testing for testing's sake isn't strategic
        - Need to manage resources wisely
        - Focus on testing important features before anything else
    - Testing the requirements is the better answer

# TDD & BDD
- TDD: Test Driven Development
    - Creating tests first, writing code later for the application
    - Development depends on the tests
- BDD: Behavior Driven Development
    - Basing development around the user stories
    - Collaborations between the QA team, BA team, devs, and other non-technical members
    - BDD is a superset of TDD (which means it extends TDD), and helps to bridge the gap between technical and non-technical members by providing syntax that conforms to human spoken-language
        - Ex: Gherkin w/ Cucumber (the framework)
        - Cucumber will link our tests written using JUnit 4, or Jupiter, or TestNG with the business requirements written with Gherkin
- Cucumber: BDD framework that uses "Gherkin"
    - Gherkin: a "domain specific language" (DSL) that helps describe business behavior without needing to dive into implementation of programming logic
        - Very high level
        - Supports 70+ spoken languages
        - Used to create "feature files"
        - Given - When - Then approach
            - Given I am at the login page
            - When I enter a valid username
            - And enter a valid password
            - Then I should be navigated to the user profile page
    - Gluecode: Actual code to be inserted
        - Often called the "step file"
        - Each step will have a method that is the actual test "steps"
        - Use a framework such as JUnit 4, Jupiter, or TestNG to write tests within each of these methods
        - If doing an E2E test, utilize Selenium to interact w/ the browser
            - Selenium is just a browser automation tool
            - We use JUnit or TestNG to write test syntax and assert conditions
            - Cucumber is providing the "skeleton" for our tests

