"use strict";

// 3 ways to define functions
// 1. Normal function declaration: function myFunc() {}
// 2. Anonymous function: function() {}
// 3. Arrow function: () => {}

let x = function() {
    console.log('Hi from an anonymous function');
}; // this function does not have a name, x is simply a variable referring to the function
// functions are first-class citizens in JavaScript, so they are treated just like any other variable values and can be passed around
// as arguments and parameters

x(); // we're not invoking a function named x, we're retrieving the function the variable x is referring to and then invoking it

// There is also this idea of immediately invoked function expressions
(function() {
    var y = 10;

    console.log('Another anonymous function')

    console.log(y);
})();


// Closures are the idea that you can have an inner function defined within an outer function
// The outer function can then return the inner function 

// Array Destructuring (we also have the concept of object destructuring, 
// so be aware of these 2 convenient ways of processing through arrays and objects)
let [myGetNameFunc, mySetNameFunc] = (function() {
    let name = 'John';

    function getName() {
        return name;
    }

    function setName(newName) {
        name = newName;
    }

    return [getName, setName];
})();

// console.log(myFuncs[0]());
// myFuncs[1]('Jane');
// console.log(myFuncs[0]());

console.log(myGetNameFunc());
mySetNameFunc('Jane');
console.log(myGetNameFunc());