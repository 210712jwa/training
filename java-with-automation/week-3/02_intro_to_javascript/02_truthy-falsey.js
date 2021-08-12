"use strict";
/*

As we have already seen, JavaScript has a lot of type coercion features
(such as using == as opposed to === for comparison)

There is also the idea of coercing boolean values into numbers (true -> 1 or false -> 0)

We also have the other way around, which is probably the most concept with regards to booleans, 
in that we can treat other values as booleans

*/

/* Numbers are all treated as true except for 0 */
if (1) { // 1 is truthy
    console.log('1 is treated as true');
}

if (-10) { // -10 is truthy
    console.log('-10 is treated as true');
}

if (0) { // 0 is the only falsey number
    console.log('0 is treated as false, so we will never print this out');
}

/* NaN: Falsey */
if (NaN) {
    console.log('NaN is falsey, so this will not print out');
}

/* undefined: Falsey */
if (undefined) {
    console.log('undefined is falsey');
}

/* null: Falsey */
if (null) {
    console.log('null is falsey');
}

/* strings: '' is falsey */
if ('') {
    console.log('an empty string is falsey');
}

let firstName = 'test';
if (firstName) {
    console.log(`My name is ${firstName}`); // This is a string template literal. This feature was added in ES6
} else {
    console.log('no name defined');
}