let obj1 = {
    'firstName': 'John',
    'lastName': 'Doe',
    'greet': function(greetWord, endingPunctuation) {
        console.log(`${greetWord}, ${this.firstName} ${this.lastName}${endingPunctuation}`);
    }
};

let obj2 = {
    'firstName': 'Jane',
    'lastName': 'Doe'
};

/* Call and Apply */

// Call allows us to borrow a method from another object without specifying a new property in our object
// So let's say we want to borrow the function defined for the greet property from obj1 for obj2 to use
obj1.greet.call(obj2, 'Hey', '!!!');

// Apply does the same thing, but instead of varargs for parameters, we pass in a single array of parameters
let parameters = ['Greetings', '.'];
obj1.greet.apply(obj2, parameters);

/* Bind */

// Bind allows us to "bind" a function's this keyword to a particular object
let myBindedGreet = obj1.greet.bind(obj2);

// myBindedGreet is now a standalone function that is intricately binded in terms of the this keyword with obj2
myBindedGreet('Hello', '...');
obj2.lastName = 'Smith';
myBindedGreet('Hi', '!');