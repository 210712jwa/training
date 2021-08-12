// This is an example of asynchronous JavaScript

function onButtonClick(event) {
    console.log('Button was clicked');
    console.log(event);
}

// We add an event listener that will listen for click events on the button
// and when that occurs, it will place our onButtonClick function
// Into what is known as the 'callback queue'
// When the call stack is empty, the "Event Loop" will take the function
// in the callback queue, place it into the call stack, and then it will
// execute
let buttonElement = document.getElementById('button');
buttonElement.addEventListener('click', onButtonClick);

// Callback functions are not necessarily specific to asynchronous
// operations like what we have above
// In this example below, the callback functions are purely synchronous
function printHello() {
    console.log('Hello');
}

function printHi() {
    console.log('Hi');
}

// A callback function is just a function that you want to pass into 
// some other logic to call later
function callbackDemo(callbackFunction1, callbackFunction2) {
    for (let i = 0; i < 1000; i++) {
        if (i % 2 == 0) {
            callbackFunction1();
        } else {
            callbackFunction2();
        }
    }
}

callbackDemo(printHello, printHi);