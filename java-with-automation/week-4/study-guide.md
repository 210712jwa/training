# Week 4 Study Guide

# Hibernate
- What is Hibernate?
    - Object Relational Mapper (ORM)
    - Maps objects to their representation in a relational database
    - This allows you to abstract away the conversion between the way objects are structured and the way relational data is structured
- Advantages and Disadvantages of Hibernate
- JPA (Java Persistence API) standard
    - Hibernate is an extension of JPA
    - JPA annotations
        - @JoinColumn
        - @Column
        - @Entity
        - @Table
        - @GeneratedValue
        - @Id
        - @OneToOne
        - @OneToMany
        - @ManyToOne
        - @ManyToMany
- Hibernate interfaces/classes
    - Configuration (class): used to configure and build a SessionFactory object
    - SessionFactory (interface): used to create Session objects
    - Session (interface): used to interact w/ the database (in an abstract way)
    - Transaction (interface): used to define a transaction (and commit or rollback the transaction)
    - Query (interface) (not type safe): What we can execute
        - getResultList()
        - getSingleResult()
        - etc.
    - Criteria (Criteria API, type safe way of retrieving data from the databases using Hibernate)
- Hibernate configuration
    - XML v. Java Annotations v. Java Programmatic
    - SQL dialect
    - hbm2ddl.auto: validate, create, create-drop, update
    - show_sql
- Mapping objects to database tables
- Eager v. Lazy loading
- HQL (Hibernate Query Language)
- JPQL (Java Persistence Query Language)
- Caching
    - L1 v. L2 caching
    - L1: scoped to a Session object
        - Always on and cannot turn this off
    - L2: scoped to a SessionFactory object
        - We need to configure ourselves if we want to use it
    - Caching provides performance benefits whenever we request data often from Hibernate
        - It will sometimes cache the data in memory instead of hitting the database each time
- NamedQuery
- Native SQL
- Object States
    - Transient
    - Persistent
    - Detached
- Proxy objects: proxies lazy load all data
    - session.load(User.class, 1) to get a User proxy object
        - Does not contain actual data
        - Whenever we call a getter, it will grab that information at that moment from the database
- Automatic dirty checking
    - Whenever a transaction is committed or the session is flushed (using session.flush()), any persistent objects being tracked by that session will be synchronized with the database

# Agile/Scrum
- SDLC
    1. Requirements phase
    2. Analysis phase
    3. Design phase
    4. Development phase
    5. Testing phase
    6. Deployment & Maintenance phase
- SDLC Methodologies
    - Waterfall
        - Planning up front
        - Big emphasis on documentation
        - Cannot go back to previous stages
        - Clear milestones
    - Agile
        - Iterative model
        - Requirements may change
        - Emphasis on "failing fast" and gathering feedback
        - "Delivering value faster"
- Agile v. Waterfall
    - Pros and cons
    - Where waterfall might be used
    - Where agile might be used
- Agile principles
    - Individual interactions over processes and tools
    - Working software over comprehensive documentation
    - Customer collaboration over contract negotation
    - Responding to change over following a plan
- Agile frameworks
    - We looked at Scrum
    - There is also
        - eXtreme Programming (XP)
        - Kanban
- Scrum ceremonies
    - Sprint planning meeting
    - Daily standup
    - Sprint review
    - Sprint retrospective
- Agile Artifacts
    - Product backlog
    - Sprint backlog
    - Burndown/burnup charts
- Agile terminology
    - Minimum viable product (MVP)
    - User acceptance testing (UAT)
    - Sprint (1 - 4 weeks, usually 2 weeks)
    - User stories
    - Epics
    - Definition of Done
    - Story pointing (estimate of difficulty of a user story)
        - fibonacci numbers
        - t-shirt sizes (XS, S, M, L, XL)

# Behavior Driven Development
- Super-set of Test Driven Development (TDD)
- BDD is used to bridge the gap between business and development teams
- Feature files written with Gherkin
    - Gherkin: English-like syntax
        - Given
        - When
        - Then
    - Business analysts can help to develop user stories and acceptance criteria, and translate them into Gherkin
- Testers can take the feature files and link them with "gluecode" (also known as step definition files)
    - These are the actual code files that will be where the tests are written
- Developers will then develop the application to pass these tests

## Terminologies
- Feature file: A file with a .feature extension that contains Gherkin
- Glue code: Actual code implementation for our feature files
    - Step definitions: our actual automation steps / test steps
- Test runner: a class that contains configuration regarding which feature files and gluecode files to link together and runs the tests based on, for exampmle, JUnit, Jupiter, or TestNG

# Selenium
- Used to automate web browsers
    - What you do with that ability is up to you
- In general, as developers/testers, we utilize Selenium to perform E2E tests
- Types of tests (recap)
    - Unit tests
    - Integration tests
    - E2E tests
- WebDriver API
    - WebDriver (interface): represents the driver that we can use to interact with the browser
        - .findElement(By)
    - WebElement (interface): represents the HTML element
    - WebDriverWait (class): useful for explict waits
        - ExpectedConditions: to specify common conditions we need to explicitly wait for
- Design patterns
    - Page Object Model
        - each page corresponds to a single class
        - used to organize our pages and elements on each page
    - Page Factory
        - uses `PageFactory.initElements(driver, this)`
        - Use `@FindBy` on our WebElement fields to quickly and conveniently find elements
        - less flexible than traditional ways of finding elements, so you might not always do this one
- Integrate Selenium w/ JUnit 4, Jupiter, or TestNG to actually perform E2E tests