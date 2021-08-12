"use strict";
/*

JavaScript is a dynamically typed language.

Whenever you declare a variable, it can have any type that it wants to have.
We can have a variable store a string value, but then later assign a number value to it

There are several datatypes in JS:
1. boolean
2. string
3. number
4. null (object)
5. undefined
6. object
    - array
7. symbol

*/

logType("Josh"); // We are able to invoke logType because the function declaration gets hoisted to the top

// Regular Function declaration
function logType(input) {
    console.log(input);
};

// Anonymous function: we can pass around functions like variables, so we can store functions in a variable
// in this case, called anonymousFunction

// In JavaScript, you can pass around functions as values
// This means I can assign a function to a variable
// This function does NOT have a name
// Rather, we have a variable with the name anonymousFunction that stores a function with no name in it
// So function() {} is an example of an anonymous function
var anonymousFunction = function() {
    console.log('Hi from anonymous function');
}
// Anonymous functions will not get hoisted

anonymousFunction(); // So I can invoke this function from below the point it was created, because it is NOT hoisted.

// var vs. let and const
// var is the original way to declare variables
// var declared variables only have two scopes:
//  1. global scope
//  2. function scope
// So, even if a var variable was declared in a block, it would either get hoisted up to the top of the global scope
// or hoisted to the top of the function scope, depending on if it was declared somewhere inside a function or not inside of a function

// let and const, on the other hand, have three scopes:
//  1. global scope
//  2. function scope
//  3. block scope
// let and const are NEVER hoisted

console.log(z); // undefined, z gets hoisted to the top because it is var
var z = 10;

// console.log(y); // this will give me an error, because y is not yet defined (let variables and const variables never get hoisted)
let y = 10;
console.log(y); // possible because we defined y before printing it out.

// Demonstrating that var declared variables are function scoped if defined anywhere inside a function:
function scopeTest() {

    if (true) {
        var a = 123;
    }

    console.log(a);
}

scopeTest();

function blockScopeTest() {

    if (true) {
        let a = 100;

        console.log(a);
    }

}

blockScopeTest();

/* Undefined */
// any variable that is declared without first assigning a value is undefined
let h;
console.log(h);

h = 100;
console.log(h);
h = undefined; // you can actually set a variable's value to undefined yourself
console.log(h);

/* Null */
// This simply means "nothing" is there
let i = null; // null is technically an object
console.log(i);

/* Objects */

// In JavaScript, curly braces are used for object literals
let obj1 = {}; // When you see this syntax, { propertyName: value, ... }
// You are actually instantiating an object
// The object with no properties above is in the heap
// The variable obj1 is in the stack, and it is pointing to the location of the object

let obj2 = {};

console.log(obj1 == obj2); // obj1 points to a different object than obj2, so false

obj2 = obj1;
console.log(obj1 == obj2); // now obj1 and obj2 are pointing to the same object, so true

obj1.name = 'John Doe';
obj2.name = 'Jane Doe';

console.log('obj1: ' + JSON.stringify(obj1)); // JSON.stringify(obj) can be used to create a JSON string representation of an object

let person1 = {
    'firstName': 'Billy',
    'lastName': 'Smith',
    'age': 23
};

console.log(person1.firstName);
console.log(person1['firstName']); // The reason this way of accessing a property is powerful, is that we can pass in a string value
// instead of having the property hardcoded

const personProperty = 'firstName';
console.log(person1[personProperty]);

person1['yetAnotherProperty'] = 3.1415;

console.log(person1);

/* JavaScript Objects and JSON */

// We can convert an object into JSON
const person1JSON = JSON.stringify(person1); // person1JSON has a string value corresponding to the JSON
console.log(person1JSON);

// We can convert JSON into an object
const person2 = JSON.parse(person1JSON);
console.log(person2);

console.log(person1 == person2);

/* == v. === */
// == has type coercion
console.log('8' == 8);

// === is strict equality (no type coercion)
console.log('8' === 8);

// to get types 
console.log(typeof(null));

/* Arrays in JS are dynamic unlike in Java. In JS, we can add more elements or remove elements */
const myArr = [1, 2, 3];
console.log(typeof(myArr));

// Push and pop: add/remove elements from the end of the array
myArr.push(4);
console.log(myArr);
console.log(myArr.pop());
console.log(myArr);

// Unshift and Shift: add/remove elements from the front
myArr.unshift(0);
console.log(myArr);
console.log(myArr.shift());
console.log(myArr);

console.log(myArr.length);

console.log('===================')
for (let i of myArr) { // If you use for loop notations such as for ... in or for ... of, make sure to know the difference so that
    // you don't run into any issues.
    // for ... in is used to iterate over property names (such as in the case of objects) (for arrays these would be the indices)
    // for ... of is used to iterate over property values (such as in the case of objects) (for arrays these would be the actual elements)
    console.log(i);
}
console.log('===================')



/* Weird stuff about JS with regards to datatypes */
console.log(1 / 0); // Infinity
console.log(-1 / 0); // -Infinity

console.log(1 / -Infinity); // -0
console.log(1 / Infinity); // 0

console.log(Infinity / -Infinity); // NaN

console.log(typeof(5 + '5')); // string
console.log(5 + +'5'); // 10, +string is a quick shortcut to go from a string to a number

console.log({} == {}); // false
console.log({} === {}) // false

console.log(false + true); // 0 + 1 = 1
console.log(true + true); // 1 + 1 = 2;

console.log(null == {}); // false
console.log(null == []); // false
console.log(null == ''); // false
console.log(null == 0); // false

console.log(null == undefined); // true
console.log(null === undefined); // false

console.log(null == null); // true
console.log(null === null); // true