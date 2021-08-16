"use strict";

let button = document.getElementById('btn1');
button.addEventListener('click', retrievePokemonDataWithFetchAsyncAwait);

/**
 * AJAX (Asynchronous JavaScript with XML)
 * (old way)
 * 
 * AJAX was created when JSON did not exist yet, the name just stuck over time, but AJAX now DOES support JSON
 * So, we are not using XML with AJAX here in this example. We can utilize JSON as well.
 */
function retrievePokemonDataWithAJAX() {
    const inputElement = document.querySelector('#pokemonId');
    const id = inputElement.value; // this will extract the inputted value to our input element, which is the id

    // 4 Steps to making an AJAX call
    // Step 1: Create an XMLHttpRequest object
    let xhttp = new XMLHttpRequest();

    // Step 2: Setup a callback function for the readystatechange event
    xhttp.addEventListener('readystatechange', onReadyStateChange);

    // Step 3: Open the request
    xhttp.open('GET', `https://pokeapi.co/api/v2/pokemon/${id}`);

    // Step 4: Send the request
    xhttp.send();

    function onReadyStateChange() {
        /**
         * There are different "ready states" of an XMLHttpRequest object
         * 
         * 0: UNSENT
         * 1: OPENED
         * 2: HEADERS RECEIVED
         * 3: LOADING
         * 4: DONE
         */

        // We are interested in readystate 4 because that's the moment we have received a response
        if (xhttp.readyState === 4) {
            if (xhttp.status === 200) {
                let response = xhttp.responseText; // This will be a JSON string or XML, whatever the response format is

                let pokemonObject = JSON.parse(response); // converts a JSON string into a JavaScript object

                populateData(pokemonObject);
            }
        }
    }
}

/**
 * Fetch API (modern way)
 */
function retrievePokemonDataWithFetch() {
    let inputElement = document.querySelector('#pokemonId');
    let id = inputElement.value;

    // The fetch function returns what is known as a 'Promise'
    fetch(`https://pokeapi.co/api/v2/pokemon/${id}`, {
        'method': 'GET'
        // ,
        // 'credentials': 'include' // Not required in this specific example, but if your application utilizes HttpSessions
        // (for example over on Javalin to keep track of who is logged in), you need to specify 'credentials': 'include'
        // in order for your browser to send the information contained in Cookies that it received from the backend
        // for each request. 
        // This is to specify that you are who you say you are and that you're actually logged in and authorized to perform
        // actions on that particular endpoint.
    }).then((data) => {
        return data.json(); // data.json() will return yet another promise
    }).then((pokemonObject) => {
        populateData(pokemonObject);
    }).catch((err) => {
        console.log(err);
    });
}

async function retrievePokemonDataWithFetchAsyncAwait() {
    let inputElement = document.querySelector('#pokemonId');
    let id = inputElement.value;

    try {
        let data = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`, {
            'method': 'GET'
        });

        let pokemonObject = await data.json();

        populateData(pokemonObject);
    } catch (err) {
        console.log(err);
    }

}

function populateData(data) {
    let tbody = document.querySelector('#pokemonTable tbody');

    let pokemonRow = document.createElement('tr');
    let id = data.id;
    let pokemonName = data.name;
    let pokemonType = data.types[0].type.name;
    let imageUrl = data.sprites.other['official-artwork'].front_default;

    let idTd = document.createElement('td');
    idTd.innerHTML = id;

    let nameTd = document.createElement('td');
    nameTd.innerHTML = pokemonName;

    let typeTd = document.createElement('td');
    typeTd.innerHTML = pokemonType;

    let imageTd = document.createElement('td');
    imageTd.innerHTML = `<img src="${imageUrl}" width="100" height="100">`;

    pokemonRow.append(idTd);
    pokemonRow.append(nameTd);
    pokemonRow.append(typeTd);
    pokemonRow.append(imageTd);

    tbody.append(pokemonRow);
}