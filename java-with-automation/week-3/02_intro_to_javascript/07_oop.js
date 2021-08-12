"use strict";

// In JavaScript, we have in general 2 ways of creating objects
//  1. We can use object literal syntax {}
//  2. We can use what is known as a function constructor
// 
// Underneath the hood, JS doesn't really have the idea of a class

// Object literal syntax to instantiate an object
let car1 = { 
    'make': 'Toyota', 
    'model': 'Camry', 
    'year': 2008 
};


// Function constructor
// This is a function that will set various properties for our object
function Car(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;

    // Do not define functions like this for your function constructors. Because if you have 100 car objects, you will have 100
    // of these duplicate functions. That will take up additional memory and add overhead
    // this.printCarInfo = function() {
    //     console.log(`This car is a ${this.year} ${this.make} ${this.model}`);
    // }
}

// Because functions are objects, we can actually access properties of that function and methods that belong to that function.
// There is a special property called the prototype property that every single object that is constructed from this function constructor
// will be able to make use of.

// prototype will be some sort of object itself, that will contain various properties and functions that any Car object should
// be able to access
Car.prototype = {
    'printCarInfo': function() {
        console.log(`This car is a ${this.year} ${this.make} ${this.model}`);
    }
};

let car2 = new Car('Honda', 'Accord', 2015); // Behind the scenes, this is creating a new object with no properties
// It is then invoking the Car function, where the 'this' keyword of the Car function will be this new object
car2.yetAnotherProperty = 'some other property';

let car3 = {}
Car.call(car3, 'Lexus', 'ES350', 2020); // This is sort of the equivalent to the above. Instead of using the new keyword syntax,
// we can understand it from the perspective of call, apply, bind, and how those help us to assign an object to be considered the 'this' keyword of the 
// function we want to invoke. However, in this way, we can only set properties and not borrow properties from the function constructor
// prototype
car3.__proto__ = Car.prototype; // I want car3 to inherit from the prototype property of the function constructor

console.log(car2);
console.log(car3);

car2.printCarInfo();
car3.printCarInfo();

// Prototypal inheritance
// Whenever I have a function constructor, and I create a new object using that function constructor through new Car(..., ..., ...),
// I am creating a blank new object, invoking the function with the 'this' keyword being treated as the blank object, and then having a reference
// to that newly created object

// What is also happening, is that the __proto__ property of this new object is being set to the Car.prototype property, which is also an object
// This new object, therefore, has an inheritance chain with the prototype property of the function constructor
// It will inherit all of the variables and methods of that object.

// We could do inheritance ourselves in the same way
let obj1 = {
    'someFunc': function() {
        console.log(this);
        console.log('This method is inherited');
    }
};

let obj2 = {};
obj2.__proto__ = obj1; // whatever __proto__ points to is the object you inherit from
obj2.someFunc();

let obj3 = {};
obj3.__proto__ = obj1;
obj3.someFunc();

/* ES6 Classes */
// Behind the scenes, the way that inheritance works for JS is through protoypal inheritance.
// This means objects directly inherit from other objects
// We don't really have the concept of classes inheriting from other classes like in Java

// ES6 did introduce the class keyword. However, classes in JavaScript are not real classes, they are really pretty much just like function
// constructors under the hood

// Classes are not hoisted. This means you must define your class first before instantiating objects
// Classes in JS are what is known as 'syntactical sugar'
class Person {

    // We have two parts to a class
    // 1. the constructor block where properties are set
    // 2. the various behaviors we want an object of that class to have
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    greet() {
        console.log(`Hello, ${this.firstName} ${this.lastName}`);
    }

}

const person1 = new Person('John', 'Doe');

console.log(person1);
person1.greet();

/* Other syntax associated w/ JS "classes" */

class Rectangle {

    constructor(width, height) {
        this._width = width;
        this._height = height;
    }

    // Getters and Setters in JavaScript (and other languages like C#) are treated differently than in Java
    // here they are treated as if they were variables.
    get area() {
        console.log('Invoking the area getter');
        return this._width * this._height;
    }

    set width(width) {
        console.log(`Setting width to ${width}`)
        this._width = width;
    }

    get width() {
        console.log('Invoking the width getter');
        return this._width;
    }

    set height(height) {
        this._height = height;
    }

    get height() {
        return this._height;
    }

}

let rectangle1 = new Rectangle(5, 10);
console.log(rectangle1.area);

rectangle1.width = 1000;
console.log(rectangle1.width);