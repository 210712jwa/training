/**
 * DOM Manipulation
 */


// innerHTML, textContent, innerText
let elementsWithClassBtn = document.getElementsByClassName('btn');
console.log(elementsWithClassBtn);

elementsWithClassBtn[0].innerHTML = 'Button';

let spanElements = document.getElementsByTagName('span');
console.log(spanElements[0].textContent);
console.log(spanElements[0].innerText);

// Table Manipulation
let tableSection = document.getElementById('table') // Not plural like the rest because an id should only belong to a single element

let tableSectionButton = document.querySelector('#table button'); // querySelector is a powerful way to select elements
// using a variety of CSS selector strategies
tableSectionButton.innerHTML = 'Create Table';

tableSectionButton.addEventListener('click', createTable);

function createTable() {
    tableSectionButton.removeEventListener('click', createTable);

    let tableDiv = document.querySelector('#tableDiv'); // or getElementById('tableDiv');
    let table = tableDiv.querySelector('table');
    let thead = table.querySelector('thead');
    let tbody = table.querySelector('tbody');

    let numberOfRows = (Math.floor(Math.random() * 20) + 1);
    let numberOfCols = (Math.floor(Math.random() * 9) + 1);

    for (let i = 0 ; i < numberOfRows; i++) {
        let tr = document.createElement('tr'); // Creating an element that we will later add to the DOM structure
        
        for (let j = 0; j < numberOfCols; j++) {
            let data;
            if (i == 0) {
                data = document.createElement('th');
            } else {
                data = document.createElement('td');
            }

            data.innerHTML = '1';
            tr.appendChild(data);
        }

        if (i == 0) {
            thead.appendChild(tr);
        } else {
            tbody.appendChild(tr);
        }
    }

    tableSectionButton.innerHTML = 'Remove table';
    tableSectionButton.className = 'btn btn-danger';
    tableSectionButton.addEventListener('click', removeTable);
}

function removeTable() {
    let thead = document.querySelector('#tableDiv table thead');
    let tbody = document.querySelector('#tableDiv table tbody');
    thead.innerHTML = '';
    tbody.innerHTML = '';

    tableSectionButton.removeEventListener('click', removeTable);
    tableSectionButton.addEventListener('click', createTable);
    tableSectionButton.innerHTML = 'Create Table';
    tableSectionButton.className = 'btn btn-primary';
}