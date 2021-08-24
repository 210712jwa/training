"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
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
var a;
a = "2 + 2 is: " + (2 + 2);
console.log(a);
// Type Inferencing
var b = 'What type is b?'; // If you declare a variable and assign it a value on the same line,
// the type of the variable will be the type of the value
// Will this work?
// b = 123; // NO!
var c; // c is of type any, which means you can assign any type of value to this variable
c = 'What type is c?';
c = 123;
var d = 100; // If I want to have the variable be of type any while also assigning a value on the same line,
// I need to explicitly declare that the variable is of type 'any'
d = 'A string';
d = 3.1415;
d = { "firstName": "Billy", "lastName": "Bob" };
// Another reason to use TypeScript (besides strong typing)
// Because modern code editors are smart, if we have types for our variables, objects, etc., we can utilize
// code editor 'intellisense' features to see what functions are available for certain variables
var sentence = "This is a sentence"; // the sentence variable is guaranteed to be of type String
console.log(sentence.includes('is a')); // true
// strings always have the includes function available for them, so the intellisense will bring it up as a suggestion
var notGuaranteedToBeAString = "This is a sentence";
// notGuaranteedToBeAString = 100; // If I changed the variable to the value 100, the below code would break
notGuaranteedToBeAString.includes('is a'); // In this case, I don't have the luxury of intellisense because
// this variable could be a string, or a number, or a boolean, or any type. We have no guarantee that .includes(...)
// will work for this variable
/**
 * Functions in TypeScript
 */
var add = function (a, b) {
    return a + b;
}; // We can specify the types for the parameters. Notice we're not specifying the return type
// because TypeScript infers that this should return a number based on the result of a + b;
// If we wanted to add a return type explicitly, we could do so as well
var sub = function (a, b) {
    return a - b;
};
function myFunc(a, b) {
    return a / b;
}
var myAnonFunc = function (a, b) {
    return a * b;
};
/**
 * Objects
 */
var post = {
    'title': 'Some news title here',
    'body': 'This is some news... blah blah blah'
};
// Type inferencing works in the above example as well
// So the post variable can only refer to objects with a title and body property
// We could also explicitly specify the object structure that a variable can point to
var post2 = {
    'title': 'some title',
    'body': 'some body'
};
;
var post3;
post3 = {
    'title': 'title3',
    'body': 'lorem ipsum...'
};
var printPost = function (post) {
    console.log("Title " + post.title + ", Body " + post.body);
};
printPost(post3);
/**
 * TypeScript classes
 */
var Car = /** @class */ (function () {
    function Car(color, year, make, model, horsepower) {
        this.color = color;
        this.year = year;
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }
    Car.prototype.drive = function () {
        console.log("Driving the " + this.year + " " + this.color + " " + this.make + " " + this.model + " with " + this.horsepower + " HP");
    };
    return Car;
}());
var myCar = new Car('red', 2010, 'Hyundai', 'Genesis Coupe', 306);
myCar.drive();
/**
 * Public and Private
 *
 * public: we can access outside of the class
 * private: we can only access from within the class, using methods for example
 * protected: we can access from within the class or subclasses
 */
var Person = /** @class */ (function () {
    function Person(name) {
        this.name = name;
    }
    Person.prototype.getName = function () {
        return this.name;
    };
    return Person;
}());
var p1 = new Person('John');
console.log(p1.getName());
// There is a shortcut for how you can define your constructors
var Pirate = /** @class */ (function () {
    // This is a shortcut for defining properties and assigning values when invoking the constructor
    function Pirate(name, age) {
        this.name = name;
        this.age = age;
    }
    Pirate.prototype.getName = function () {
        return this.name;
    };
    Pirate.prototype.getAge = function () {
        return this.age;
    };
    return Pirate;
}());
var pirate = new Pirate('Blackbeard', 50);
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
var Component = function (target) {
    console.log(target);
};
var Ship = /** @class */ (function () {
    function Ship(name) {
        this.name = name;
    }
    Ship = __decorate([
        Component
    ], Ship);
    return Ship;
}());
var Bicycle = /** @class */ (function () {
    function Bicycle(speed) {
        this.speed = speed;
    }
    Bicycle.prototype.drive = function () {
        console.log("Riding the bicycle at a speed of " + this.speed);
    };
    return Bicycle;
}());
/**
 * Generics
 */
// Class generics
var MyWrapper = /** @class */ (function () {
    function MyWrapper(value) {
        this.value = value;
    }
    return MyWrapper;
}());
var numberWrapper = new MyWrapper(10);
var stringWrapper = new MyWrapper('some string');
// Function generics
var myFunction = function (value) {
    return [value];
};
var numArray = myFunction(10);
numArray.push(30);
console.log(numArray);
