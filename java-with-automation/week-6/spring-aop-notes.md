# AOP - Aspect Oriented Programming
- Breaking down program logic into "cross-cutting-concerns"
    - Cross-cutting-concerns: some functionality used throughout the entire application (it "cuts" across different layers, classes, methods, etc.)
    - Examples: logging, security, caching, validation, etc.
- Break down these concerns into units that are known as "Aspects"
    - An `Aspect` is a class that contains different `Advice` (structured as methods)
- We can annotate our class with @Aspect to address a particular concern
    - `@Aspect` is from the AspectJ library, which is a full AOP framework, but Spring AOP can also utilize AspectJ annotations
- We write code within our Aspect class, that will be intercepting code in other locations of our codebase

## AOP Ecosystem
- AspectJ: Fully fledged ORIGINAL AOP framework that provided the ability to write AOP code in an annotation based format
    - More functionality than Spring AOP
    - Harder to use
- Spring AOP: Spring's implementation of AOP
    - This is what we will be using
    - But, to make use of annotations, Spring AOP understands AspectJ annotations
        - So we will be utilizing the AspectJ dependency just to gain access to these annotations
    - Less functionality than AspectJ
    - Easier to use
    - Uses Runtime-weaving: the process where code is "wrapped" during runtime

# Join Points
- A join point is the location that is intercepted by advice code
- a JoinPoint is represented by method execution
- So when some method is invoked, the advice will intercept it

# PointCut
- A pointcut is a predicate (similar to regular expressions) that indicates WHAT we want to intercept

# Advice
- The actual code that will run during interception of a join point (that is specified by the pointcut expression)
- Many different types of advice:
    - @Before
        - Advice that will execute before the JoinPoint that is to be intercepted
    - @After
        - Advice that will execute after the JoinPoint (regardless of whether an exception was thrown by the joinpoint method or returned successfully)
    - @AfterReturning
        - Advice that will execute after a method returns successfully
    - @AfterThrowing
        - Advice that will execute after a method throws an exception
    - @Around
        - Allows for this advice to intercept a method both before and after
        - Most powerful type of advice, and can do things like stopping the execution of the joinpoint method, stopping an exception from propagating, etc.
- Advice are associated with PointCuts and run at matching JoinPoints
- JoinPoint interface
    - gives us access to the target object
    - allows us to gain access to information such as the method signature, method arguments, etc.
- ProceedingJoinPoint
    - used to handle @Around advice
    - gives access to the .proceed() method that will actually execute the JoinPoint method

# Types of PointCut Expressions
- execution
    - Most common, and specifies which methods to have as our JoinPoints
    - `execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)`
        - modifiers-pattern: public, private, protected
        - return-type: void, String, int, boolean, com.revature.model.Animal
        - declaring-type-pattern: class name that the method belongs to
            - `com.revature.dao.ShipDao`
        - Example: `execution(public Ship com.revature.dao.ShipDao.getShipById(int))`
    - Parameter pattern wildcards
        - (): matches a method with no arguments
        - (*): matches a method with 1 argument of any type
        - (..): matches a method with 0 or more arguments of any type
    - Reuse pointcut expressions
        - `@PointCut` to specify a pointcut "template"
    - Combine pointcuts
        - && (And)
        - || (Or)
        - ! (Not)

# Terminology Summary
- Aspect: the class that contains advice
- Advice: the code that will execute during interception of a Join Point
- Join Point: the actual method that we are intercepting
- Pointcut: an expression that indicates what is actually the join point