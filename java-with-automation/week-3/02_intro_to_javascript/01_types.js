/*

JavaScript is a dynamically typed language.

Whenever you declare a variable, it can have any type that it wants to have.
We can have a variable store a string value, but then later assign a number value to it

There are several datatypes in JS:
1. boolean
2. string
3. number
4. null (object)
5. object
    - array
6. undefined
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
