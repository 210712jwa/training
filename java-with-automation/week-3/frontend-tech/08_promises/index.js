/*
    The Promise object represents the eventual completion (resolving) or failure (rejection) 
    of some operation

    Promises were added in ES6
*/

function fakeFetch() {
    let myPromise = new Promise((resolve, reject) => {

        // Pretend that this is the fetch API that is part of the browser and doing
        // some sort of HTTP operations

        // Once you send a request... you receive the response some time later
        // This response can then be resolved
        let response = Math.floor(Math.random() * 9) + 1;

        if (response <= 5) {
            resolve(response);
        } else {
            reject('Failed to retrieve data');
        }

    });

    return myPromise;
}

/**
 * Traditional .then, .catch for utilizing a promise
 */

// fakeFetch().then((data) => {
//     console.log(data);
// }).catch((err) => {
//     console.log(err);
// });

/**
 * Async/await
 * Promises were introduced in ES6, but in ES8, async/await made dealing with promises even easier
 * 
 * Instead of needing to do .then((response) => {...}), we could instead use await to get the resolved value of a promise
 */

// The await keyword can be used to get the value from a promise once it has been resolved
async function myAsyncFunction() {

    console.log('We are inside the async function');
    try {
        let data = await fakeFetch(); // await can only be used inside an async function
        console.log(data);
    } catch(err) {
        console.log(err);
    }

}

myAsyncFunction();
console.log('This is my own code printing out');

// ...