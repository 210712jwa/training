// "use strict";

let obj1 = {
    'firstName': 'John',
    'lastName': 'Doe',
    'greet': function() {
        console.log(`Hello, ${this.firstName} ${this.lastName}`);
    }
};

obj1.greet();

// Now let's say you were trying to be experimental and use an arrow function instead:
let obj2 = {
    'firstName': 'John',
    'lastName': 'Doe',
    'greet': () => {
        console.log(`Hello, ${this.firstName} ${this.lastName}`)
    }
};

obj2.greet(); // You might have thought that this would print out Hello, John Doe
// But in fact it printed out Hello, undefined undefined

// That is because arrow functions treat 'this' completely differently than normal functions
// The way arrow functions treat this, is that it "borrows" the this from the global execution context that the arrow function was defined in
console.log(this); // The this that we print here is the same as the this for the arrow function


let obj3 = {
    'firstName': 'John',
    'lastName': 'Doe',
    'greet': function() {

        console.log(this);

        let x = () => {
            console.log(`Hello, ${this.firstName} ${this.lastName}`);
        };

        x();

    }
}

obj3.greet();

// Arrow functions v. Regular functions
// The main important distinction is how arrow functions treat the this keyword v. regular functions
// Arrow functions use the same 'this' as the scope they were defined in
// The value of 'this' for regular functions depends on what invoked the function.

let obj4 = {
    'firstName': 'Nick',
    'lastName': 'Hailey'
};

obj4.borrowedFunction = obj3.greet;

obj4.borrowedFunction();