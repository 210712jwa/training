# Java Syntax Practice

To improve your Java programming skills, practice typing out Java code syntax. Below you'll
find many different snippets to practice. We recommend copying the syntax down multiple times
to get comfortable and familiar with it. You should not rely on your IDE or a compiler
to know if your basic syntax is correct. The best way to improve your syntax is to PRACTICE!

Not only should you be able to read these snippets, you should be able to write their syntax
fluently. Think of writing code as muscle memory - just like in sports, you remember the correct
technique. In our case, the technique consists of different symbols, keywords, and operators.
Once you can write code like these snippets without copying it from somewhere else first or relying 
on your IDE to point out problems, then you know you are proficient at it.

### Main method

```java
public class MyClass {
    public static void main(String[] args) {
        // main method
    }
}
```

### Objects and Classes

Methods & Constructors:
```java
@SomeClassAnnotation // annotations can go on classes...
public class MyClass {
    private String encapsulatedString;

    public MyClass(String s) {
        // this is a constructor
        this.encapsulatedString = s;
    }
    @SomeMethodAnnotation // ... or on methods
    public void doStuff() {
        // this is a method
    }
}
```

Statements end with semicolons:
```java
Object o = new Object(); // this is a statement
doSomething(); // this is also a statement
new MyClass().someMethod(); // assignment to a variable is not required in a statement
stepOne(); stepTwo(); // we can even put multiple statements on one line
stepThree() // but excluding the semicolon is invalid and will not compile
```

Class members (i.e. things you can declare in a class):
* variables
* methods
* constructors
* initialization blocks

Statements that are NOT assignments to variables cannot appear directly inside a class.
```java
public class BadSyntax {
    String thisIs = "ok";
    public void thisIsAlsoValid() {}
    butDoNotDoThis();
    new ThisIsInvalid().andWillCause().compilationErrors();
}
```

### Variable declarations

```java
String literal = "this is a string literal";
String anotherStr = new String("this is a string created by using the String constructor");
int[] intArray = new int[3]; // declaring an array of ints of size 3
int[] intArray = {1,2,3}; // declaring an array of 3 ints with array literal - cannot be used for re-assigning variable
int[] intArray = new int[]{1,2,3}; // alternative array declaration
```

### Control Flow

Iterating over an array:
```java
int[] arr = new int[]{3,6,8,1};
for(int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]); // printing out the ith element of the array
}

// enhanced for loop
for (int element : arr) {
    System.out.println(element);
}

// using a while loop
int x = arr.length;
while(x >= 0) {
    System.out.println(arr[x]);
    x--;
}

// using a do-while loop
x = arr.length;
do {
    System.out.println(arr[x]);
    x--;
} while(x >= 0);
```

Switch statement:
```java
switch(someVariable) {
    case "first": System.out.println("a"); break;
    case "second": System.out.println("b"); // no break statement - falls through to next
    default: System.out.println("neither of the above");
}
```

### Operators

Pre/post increment & decrement:
```java
int a = 0;
a++; // increment a to 1
a--; // decrement a to 0
System.out.println(++a); // increment before printing (prints 1)
System.out.println(a++); // print, then increment (prints 1)
System.out.println(a); // prints 2
System.out.println(a--); // print, then decrement (prints 2)
System.out.println(--a); // decrement, then print (prints 0)
```

Assignment:
```java
int b = 4;
b += 2; // adds 2 to the value of b and assigns it to b
System.out.println(b); // prints 6
b -= 2; // subtracts 2 from the value of b and assigns it to b
System.out.println(b); // prints 4
b *= 4; // multiplies b by 4 and assigns it to b
System.out.println(b); // prints 16
b /= 4; // divides b by 4 and assigns it to b
System.out.println(b); // prints 4
b++; // b = 5 now
int c = b % 3; // modulus operator - divides b by 3 and returns the remainder
System.out.println(c); // prints 2 (explanation: 5 / 3 = 1 with a remainder of 2, so c=2)
```

Logical operators:
```java
boolean t = true;
boolean f = false;
System.out.println(!f); // true (! will invert the boolean from true to false or vice versa)
System.out.println(!t); // false
System.out.println(t && f); // true (logical AND operator - returns true only if BOTH sides evaluate to true)
System.out.println(t || f); // false (logical OR operator - returns true if EITHER side evalutes to true)
if (!f && t) { // we can combine logical operators in if conditions
  System.out.println("this will print");
} else {
  System.out.println("this never prints");
}
if (!t || f || !f) {
  System.out.println("this prints because the last argument is true");
}
```

### Exception Handling

Using try/catch block:
```java
public void readFile(String filePath) {
    try {
        String contents = readFileContents(filePath);
    } catch(IOException ioe) {
        System.err.println("something went wrong");
    }
    System.out.println("file contains: " + contents);
}
```

Ducking the exception:
```java
public void readFile(String filepath) throws IOException {
    String contents = readFileContents(filePath);
    System.out.println("file contains: " + contents);
}
```

Try-with-resources:
```java
public void readFile(String filePath) {
    try(AutoCloseable ac = getSomeResource()) {
        ac.callSomeMethod();
    } finally {
        System.out.println("always prints");
    }
}
```

Custom exception declaration:
```java
public class MyUncheckedException extends RuntimeException {}
public class MyCheckedException extends Exception {}
```

### Collections & Generics
Generics:
```java
List<String> mylist = new ArrayList<String>();
List<String> mylist = new ArrayList<>(); // alternative declaration using type inference
//  ^generic type                  ^^ diamond operator
```

Iterating any Collection (not a Map):
```java
Collection<Integer> coll = new HashSet<>(); // or any List or Queue
// populate the collection...
for (Integer num : coll) { // using an enhanced for loop
  System.out.println(num);
}
```

Iterating a Map:
```java
Map<String,Integer> map = new HashMap<>();
// add entries to the map...
for (Map.Entry<String,Integer> entry : map.entrySet()) { // using an enhanced for loop
  System.out.println("key: " + entry.getKey() + "; value:" + entry.getValue());
}
// alternatively, using a keyset...
Set<String> keys = map.keyset();
for (String key : keys) {
  System.out.println("key: " + key + "; value:" + map.get(key));
}
// alternatively, iterate over the values
Collection<Integer> values = map.values();
for (Integer val : values) {
  System.out.println("value:" + val);
}
```

### Interfaces

```java
public interface MyInterface {
    public abstract void doStuff();
}
public class MyClass implements MyInterface {
    public void doStuff() {
        // provide implementation here...
    }
}
```

### Threads

Create a thread - Option 1:
```java
public class MyCustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("running!");
    }
}
// elsewhere in the code...
Thread myThread = new MyCustomThread();
myThread.start();
```

Create a thread - Option 2:
```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("running");
    }
}
// elsewhere...
MyRunnable r = new MyRunnable();
Thread myThread = new Thread(r);
myThread.start();
```
Create a thread - Option 2 (alternative with lambda):
```java
Thread myThread = new Thread(() -> {
    System.out.println("running");
})
```
Create a thread - Option 3 (Thread pool):
```java
Runnable r1 = () -> {System.out.println("r1");}
Runnable r2 = () -> {System.out.println("r1");}
Runnable r3 = () -> {System.out.println("r1");}
ExecutorService pool = ExecutorService.newFixedThreadPool(3);
pool.execute(r1);
pool.execute(r2);
pool.execute(r3);
```