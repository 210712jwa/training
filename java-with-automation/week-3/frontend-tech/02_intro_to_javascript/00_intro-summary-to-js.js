"use strict";
// Although JavaScript has the name "Java" in it, it is NO WAY related to Java. 
// JavaScript is a totally different programming language from Java. They do share some similarities in syntax, but under the hood they are
// definitely way different than each other.

// Line comment

/*
    Block comments
*/

/* Functions */
function helloLog() {
    console.log('Hello from helloLog!');
}

function logMessage(message) { // Notice how the parameter, 'message', does not require any type
    // Variables in JavaScript are dynamically typed. This means a variable can take on any sort of value of any type
    console.log(message);
    console.log(typeof(message)); // typeof allows us to see what the type is of the data currently stored or referenced by the message variable
}

// Therefore, JavaScript is a DYNAMICALLY typed language, while Java is a static typed language

helloLog(); // invoking a function

/* dynamic / loose typing */
logMessage('Hello from the logMessage argument!'); // string
logMessage(12345); // number
logMessage(20 / 5); // number
logMessage(20 - 'a'); // This logs out NaN, which is of the number type. (yet NaN means 'not a number')

// == v. ===
// == is a "loose equality operator", which does what is called type coercion, which means if it is possible, it will coerce one value into another value's type, and then compare them
// === is a "strict equality operator", so there is no type coercion
logMessage(8 == '8'); // true (type coercion)
logMessage(8 === '8'); // false (no type coercion)

logMessage(null); // null is an object because it represents the absence of an object

var m; // undefined is the value of a variable before a value has been assigned to that variable
logMessage(m); // undefined is of the type undefined

// Summary of Data types:
// We have:
// 1. string (primitive in JavaScript unlike in Java)
// 2. number (represents both whole numbers and floating point numbers)
// 3. boolean
// 4. null (technically an object)
// 5. undefined
// 6. object
// 7. Symbol

/*
    Objects
*/

// Unlike in Java, we don't need to have a blueprint (class) in order to create an object
// An object can be created on the fly by using 'object literal' syntax
var obj = {
    'id': 1,
    'name': 'Revature',
    'favoriteColor': 'orange',
    'isObject': true
};

// This looks really similar to JSON. 
// JSON (JavaScript Object Notation)

// Arrays: in JavaScript, used to store elements. We can add more elements or remove elements from an Array. This is different than in Java 
// Where Arrays have a fixed size
var arr = [1, 'Revature', true, undefined, null, { 'someProperty': 'someValue' }];

console.log(obj);
console.log(arr);

console.log(typeof(obj) + ', ' + typeof(arr));
// An Array is also an object. It's a built in object type in JavaScript

// Objects can also have 'behaviors'
var obj2 = {
    'firstName': 'Hello',
    'lastName': 'World',
    'fullName': function() {
        console.log(this.firstName + ' ' + this.lastName);
    }
};

obj2.fullName(); // inside of the fullName() function, 'this' is referring to obj2 itself

var obj3 = {
    'firstName': 'Bach',
    'lastName': 'Tran'
};

obj3.y = obj2.fullName; // I'm adding a new property called y to obj3, which at the moment only had firstName and lastName
// this property happened to be a function called fullName from obj2

// So, now I can actually invoke y by doing obj3.y()
obj3.y(); // Even though I'm borrowing a function from obj2 for obj3 to use, the 'this' keyword is based on what object is before the .<method name>();

/* Scopes & Hoisting */
console.log(globalVar);

var globalVar = 'I\'m a global scoped variable';

// Hoisting: Function declarations and specifically var variable declarations are 'hoisted' to the top of your function scope
// globalVar is not being defined inside of a function, so it gets hoisted to the top of the global scope

function myFunction() {
    var functionVar = 'I\'m a function scoped variable';

    /* ES6 added block scope */
    // let variables and const variables are block scoped
    if (true) {
        // var declared variables can ONLY be global scoped or function scoped
        var a = 'some string'; // var declared variables are "hoisted" to the top of the function
        // so a is not actually a block scoped variable, it is a function scoped variable

        let blockVar = 'I\'m a block scoped variable';
        const blockConst = 'I\'m a block scoped variable (constant) as well';

        // let v. const?
        // blockConst = 'new value'; // cannot change the value of a const

        blockVar = 'new value';
    }

    a = 'new value';
    console.log(a);
    // Because I am in strict mode, this would complain that there is no variable declared called funcitonVar
    // I mispelled the variable name intentionally
    // funcitonVar = 'Changed value of functionVar'; 

    console.log(functionVar);
}

myFunction();

// myObj is a const variable pointing to an object in the heap
// This doesn't mean that I can't change the properties of the object
const myObj = {
    'name': 'Test'
};

console.log(myObj);
myObj.name = 'New Name';
console.log(myObj);

// is there another way to access the name property instead of myObj.name?
var propertyName = 'name';
// myObj['name']
console.log(myObj[propertyName]);

// Unlike in Java, you can add properties to objects on the fly
myObj.newProperty = 'My new property';
myObj.abc = 'Yet another property';

console.log(myObj);

/*
    Strict mode
*/
// x = "Hello"; // if "use strict" is defined at the top of the .js file, this will throw an error in the console
// This is mainly to avoid issues where we think we are changing the value of an already existing variable, but 
// it turns out we misspelled something
// So it will always check to see if the variable has been declared or not yet
// If strict mode is not enabled, it will not do that.

/*

Fizzbuzz: Write a program that counts from 1 through 50. 
Any time the number is divisible by 3, it should be replaced with the word "Fizz." 
Any time the number is divisible by 5, it should be replaced with the word "Buzz." 
If it is divisible by both, it should be replaced by "Fizzbuzz."

*/


// The reason we have the weird behavior with var and it being hoisted either to the top of the global scope or function scope
// is that we have this idea of function hoisting.
// So because function hoisting is a feature in JavaScript, variable hoisting also occurred as a side-effect (artifact)
// variable hoisting is not really useful, it's just a side effect
// but function hoisting is useful

myHoistedFunction(); // Even though myHoistedFunction is not being declared before I invoke it, it is still possible to invoke 
// the function before declaring it because of function hoisting.

function myHoistedFunction() {
    console.log('Hi from myHoistedFunction()');
}