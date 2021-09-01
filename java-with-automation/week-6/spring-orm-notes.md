# Spring ORM
- Spring ORM is a module used to integrate data access code with Spring (Object relational mapping)
- Allows us to combine an ORM like Hibernate w/ Spring
- Benefits:
    - Less boiler plate code
        - We don't need to create a Transaction object ourselves, manually committing, etc.
        - Instead, we make use of the `@Transactional` annotation on our methods to treat everything inside of that method as a single database transaction
    - We can leverage DI throughout our different DAOs
    - Testing becomes easier

# Setup of Spring ORM
In order to get Spring ORM working, we need to configure/define 3 different Spring Beans

1. DataSource
    - This is the bean in which we specify
        - The database credentials
        - The driver class name
    - DataSource is an interface that defines what is known as a "connection pooler" object, which contains a pool of connections to the database that will be allocated to different Sessions
2. SessionFactory
    - Where we configure specific Hibernate properties
        - hibernate.dialect
        - hibernate.hbm2ddl.auto
        - hibernate.show_sql
    - We can then utilize DI to utilize the SessionFactory bean in our DAOs
3. TransactionManager
    - Utilized through the `@Transactional` annotation to take care of transactions for us

## How do these beans work together?
- The DataSource bean is injected into our SessionFactory bean
- The SessionFactory bean is injected into the TransactionManager bean
- We can inject the SessionFactory bean into our various DAOs as well

# Contextual Session
- A session that is managed throughout the scope of a Spring Managed Transaction (TransactionManager)

# @Repository
- Stereotype annotation for DAOs
- It also provides some additional configuration information to Spring ORM
    - Indicates to the PersistenceExceptionTranslationPostProcessor that exceptions thrown by DAOs should be interpreted as Spring Data Access Exceptions

# @Transactional
- Transactional is used to create a particular session and transaction for the currently executing method
- This helps us to not have to use `Transaction tx = session.beginTransaction()` and `tx.commit()` or `tx.rollback()
    - We don't have to do those anymore
    - All of it occurs behind the scenes with Spring ORM's transaction manager
- There are different transaction propagation strategies that can be used with this annotation:

REQUIRED (default)
- Same transaction will be used if one already exists
- Otherwise a new transaction will be opened

REQUIRES_NEW
- A new transaction will be opened, even if there is already an "outer" transaction
- Inner transaction can commit or rollback independently of the outer transaction

NESTED
- Inner and outer use the same transaction, but are separated by savepoints
- Inner can rollback or commit with the second

MANDATORY
- Existing transaction must already be open or the container will throw an IllegalTransactionException

NEVER
- An existing transaction cannot already be open. Exception will be thrown if there is
- Must execute this type of DAO operation non transactionally (meaning not modifying or adding any data, only querying)

SUPPORTS
- Executes within the scope of an existing transaction, but otherwise executes non-transactionally

NOT_SUPPORTED
- Executes outside any existing transaction, existing transaction will be paused