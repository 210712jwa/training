import { setSyntheticLeadingComments, StringLiteralLike } from "typescript";

console.log('Hello TypeScript!');

/**
 * As we know, there are many basic datatypes in JavaScript:
 * 1. Undefined
 * 2. Null
 * 3. Object
 * 4. Symbol
 * 5. String
 * 6. Number
 * 7. Boolean
 */

// Within TypeScript, we can provide types for our variables.
// So you can think of TypeScript as a strongly typed version of JavaScript (with some other additional features)

// The main purpose of TypeScript is to help us avoid bugs regarding the potential misassignment of 
// values to certain variables. When we transpile from TypeScript to JavaScript, we are able to catch these issues
// early because the transpiler will complain to us that we are trying to assign a string to a number variable, for
// example

// There are no speed or performance benefits when using TypeScript
//  - It simply makes our lives easier as developers
//  - Especially for those of us who come from Java backgrounds

// ULTIMATELY, the goal of TypeScript is to catch typing issues early instead of when the app is running

let a: string;
a = `2 + 2 is: ${2 + 2}`;

console.log(a);

// Type Inferencing
let b = 'What type is b?'; // If you declare a variable and assign it a value on the same line,
// the type of the variable will be the type of the value

// Will this work?
// b = 123; // NO!

let c; // c is of type any, which means you can assign any type of value to this variable
c = 'What type is c?';

c = 123;

let d: any = 100; // If I want to have the variable be of type any while also assigning a value on the same line,
// I need to explicitly declare that the variable is of type 'any'
d = 'A string';
d = 3.1415;
d = { "firstName" : "Billy", "lastName" : "Bob" };

// Another reason to use TypeScript (besides strong typing)

// Because modern code editors are smart, if we have types for our variables, objects, etc., we can utilize
// code editor 'intellisense' features to see what functions are available for certain variables

let sentence = "This is a sentence"; // the sentence variable is guaranteed to be of type String
console.log(sentence.includes('is a')); // true
// strings always have the includes function available for them, so the intellisense will bring it up as a suggestion

let notGuaranteedToBeAString: any = "This is a sentence";
// notGuaranteedToBeAString = 100; // If I changed the variable to the value 100, the below code would break
notGuaranteedToBeAString.includes('is a'); // In this case, I don't have the luxury of intellisense because
// this variable could be a string, or a number, or a boolean, or any type. We have no guarantee that .includes(...)
// will work for this variable

/**
 * Functions in TypeScript
 */

const add = (a: number, b: number) => {
    return a + b;
}; // We can specify the types for the parameters. Notice we're not specifying the return type
// because TypeScript infers that this should return a number based on the result of a + b;

// If we wanted to add a return type explicitly, we could do so as well
const sub = (a: number, b: number): number => {
    return a - b;
};

function myFunc(a: number, b: number): number {
    return a / b;
}

const myAnonFunc = function(a: number, b: number): number {
    return a * b;
}

/**
 * Objects
 */

let post = {
    'title': 'Some news title here',
    'body': 'This is some news... blah blah blah'
};

// Type inferencing works in the above example as well
// So the post variable can only refer to objects with a title and body property

// We could also explicitly specify the object structure that a variable can point to
let post2: { title: string, body: string } = {
    'title': 'some title',
    'body': 'some body'
};

/**
 * Interfaces: added with TypeScript
 * 
 * If we have a lot of properties to deal with, we can create an Interface that defines a particular type
 * that is reusable and clean
 */

interface Post {
    title: string,
    body: string
};

let post3: Post;
post3 = {
    'title': 'title3',
    'body': 'lorem ipsum...'
};

const printPost = (post: Post) => {
    console.log(`Title ${post.title}, Body ${post.body}`);
}

printPost(post3);

/**
 * TypeScript classes
 */

class Car {

    // Unlike in JavaScript, in TS we can define various types for our intended properties
    color: string;
    year: number;
    make: string;
    model: string;
    horsepower: number;

    constructor(color: string, year: number, make: string, model: string, horsepower: number) {
        this.color = color;
        this.year = year;
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    drive() {
        console.log(`Driving the ${this.year} ${this.color} ${this.make} ${this.model} with ${this.horsepower} HP`);
    }
}

let myCar: Car = new Car('red', 2010, 'Hyundai', 'Genesis Coupe', 306);
myCar.drive();

/**
 * Public and Private
 * 
 * public: we can access outside of the class
 * private: we can only access from within the class, using methods for example
 * protected: we can access from within the class or subclasses
 */

class Person {
    private name: string;

    constructor(name: string) {
        this.name = name;
    }

    getName() {
        return this.name;
    }
}

let p1 = new Person('John');
console.log(p1.getName());

// There is a shortcut for how you can define your constructors
class Pirate {

    // This is a shortcut for defining properties and assigning values when invoking the constructor
    constructor(private name: string, public age: number) {
    }

    getName() {
        return this.name;
    }

    getAge() {
        return this.age;
    }

}

let pirate = new Pirate('Blackbeard', 50);
console.log(pirate.age);
console.log(pirate.getName());

/**
 * Decorators are something that you will see all the time in Angular
 * For example, the @Component decorator or the @NgModule decorator
 * 
 * These look similar to annotations in Java, but they actually work completely differently
 * 
 * Decorators can be a complex topic, but here we will just show a really simple example
 * 
 * A decorator can be simplified to "a function that executes whenever our class is utilized"
 */

const Component = (target: any) => {
    console.log(target);
}

@Component
class Ship {

    constructor(public name: string) {
    }

}

// [Function: Ship] is going to be printed out from the decorator function being invoked
// The decorator gets invoked during the "first scan" of the our TypeScript code

/**
 * Strict mode in TypeScript: strict mode prevents
 *  - having undefined values for typed variables
 *  - parameters with no explicitly defined type
 */

/**
 * Classes + Interfaces
 * 
 * We can combine interfaces with classes using "implements"
 */

interface Driveable {
    speed: number;
    drive(): void;
}

class Bicycle implements Driveable {
    speed: number;

    constructor(speed: number) {
        this.speed = speed;
    }

    drive(): void {
        console.log(`Riding the bicycle at a speed of ${this.speed}`);
    }
    
}

/**
 * Generics
 */

// Class generics
class MyWrapper<TypeOfProperty> {

    value: TypeOfProperty;

    constructor(value: TypeOfProperty) {
        this.value = value;
    }
}

let numberWrapper = new MyWrapper<number>(10);
let stringWrapper = new MyWrapper<string>('some string');

// Function generics
const myFunction = <T>(value: T): T[] => {
    return [value];
}

let numArray: number[] = myFunction<number>(10)
numArray.push(30);
console.log(numArray);