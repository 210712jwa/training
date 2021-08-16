"use strict";
/*

There are 2 main scopes in JavaScript:
    - Global Scope
    - Function scope

We saw this with the idea of hoisting, where functions and var variables are hoisted to the top of their scope

The global scope is the outermost level, or the same level that this comment is in. Anything else inside a function will be of the function scope.

As of ES6, we were introduced with let and const. These brought to us a third scope known as the block scope

Now (ES6),
    - Global Scope
    - Function Scope
    - Block Scope

*/

console.log(c);
var c = 'I am a global scoped variable';
console.log(c);

let b = 'I am a global scoped variable'; // let or consts' scopes will depend on the scope they are defined in
// Importantly, there is no hoisting for let and const
console.log(b);

function outer() {
    let a = 'I am a function scoped variable';
    let number = 10;

    inner();

    function inner() {
        let obj = {
            'someProperty': 'some string value'
        };

        console.log(a);
        console.log(number);
        console.log(obj);
        console.log(c);
    }
}

outer();

function myFunc() {

    var i = 100;

    for (let i = 1; i < 10; i++) { // because I'm using let, I don't overwrite the value of var i in the function scope
        console.log(i);
    }

    console.log('i outside of for loop: ' + i); // so this prints out 100 as I might expect. But if I used var i = 1 in the for loop, this value
    // would have been 10.
}

myFunc();