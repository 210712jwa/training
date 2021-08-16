# JS Study Guide

# Basics
- Benefits, features, and drawbacks of JS
    - Loosely / dynamically typed
    - High-level
    - Multi-paradigm (functional, object-oriented, procedural)
    - DOM manipulation (browser)
    - Single-threaded asynchronous
    - Server-sided code with Node.js
- Data types
    - null
    - object
    - undefined
    - string
    - number
    - symbol
    - boolean
- Variable scopes
    - function
    - global
    - block (ES6 w/ let and const)
- Control flow
    - for
        - for (let i = 0; i < 100; i++) {}
        - for - of
        - for - in
    - while
    - do-while
    - switch
- Type coercion
    - `==` v. `===`
- Functions
    - Types
        - Regular functions
            - `function someFunc() {}`
        - Anonymous functions
            - `let x = function() {}`
        - Arrow functions
            - `() => {}`
            - Borrows the `this` from the scope the arrow function was declared within
    - Conceptual knowledge
        - Self-invoking functions (IIFE)
            - `(function() { })();`
        - Callback functions
- Hoisting
    - Regular functions are hoisted to the top of their scope
        - Not true for anonymous functions or arrow functions
    - var variables are hoisted to the top of their scope as well
        - Not true for `let` and `const`
- "strict" mode
- `this` keyword
- Objects
    - a collection of properties
        - key-value pairs
        - Bracket v. dot syntax
            - `obj.someProperty` v. `obj['someProperty']`
    - Object literal syntax
    - Constructor functions
    - Classes (syntactical sugar)
- OOP in JavaScript
    - Prototypal inheritance
    - __proto__ property will point to the object that you want to inherit
    - for constructor functions, we define a `.prototype` property that will automatically be referred to by the `__proto__` properties of objects constructed from this constructor function using the `new` keyword
- Arrays
    - Dynamic in JavaScript
    - Methods
        - push
        - pop
        - unshift
        - shift
        - filter
        - map
        - forEach

# DOM and Events
- DOM: Document Object Model
- DOM hierarchy
    - Tree structure
- `window` object
- `document` object
    - Querying and retrieving elements from the DOM
        - `document.getElementById('someId')`
        - `document.getElementsByClassName('someClass')`
        - `document.querySelector('#someId h2')`
        - etc.
    - Modify CSS styling
    - Inserting DOM elements
        - `const newh1 = document.createElement('h1')`
        - `someElement.appendChild(newh1)`
- Events & Listeners
    - Setting event listeners
    - Bubbling / capturing
    - Event object & methods
        - `e.stopPropagation()`
        - The event object contains some useful information that you might want to access
        - For example, when you press a key and that emits some sort of event, you would be able to see what key was actually pressed within one of the event object's properties

# ES6+
- ES6
    - `let` and `const` keywords
    - Arrow functions
    - Template literals
    - Default parameters
    - Spread operator
    - Destructuring
    - Promises
- ES7
    - async/await

# AJAX
- Benefits and drawbacks of AJAX
    - Asynchronous (non-blocking)
    - Could run into "callback hell" because AJAX doesn't have support for promises
- AJAX workflow
    - Create the XMLHttpRequest xhr object
    - Call xhr.open() w/ the http method and url
    - Set an event listener for the xhr object for the `readystatechange` event
        - Inside the callback function, check for a ready state of 4 and status code between 200-299
    - Send the request via xhr.send()

# Fetch API
- Modern way of sending HTTP requests
- Utilizes promises, which help to avoid "callback hell"
- Know how to utilize fetch
    - `fetch('someurlhere').then((res) => { return res.json(); }).then((data) => { })`

# JSON and JavaScript
- `JSON.parse()` and `JSON.stringify()`
- Converting JSON to a JS object v. Converting a JS object into a JSON string