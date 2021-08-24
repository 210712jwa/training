
function onLoad(event) {
    fetch('http://localhost:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 401) {
            window.location.href = '/index.html'
        } else if (response.status === 200) {
            return response.json();
        }
    }).then((user) => {
        return fetch(`http://localhost:7000/user/${user.id}/ship`, {
            'method': 'GET', 
            'credentials': 'include'
        });
    }).then((response) => {
        return response.json()
    }).then((ships) => {
        populateShips(ships);
    })
}

function populateShips(shipArray) {
    let tbody = document.querySelector('#ships tbody');

    for (const ship of shipArray) {
        /*
        <th>Ship ID</th>
                    <th>Ship Name</th>
                    <th>Ship Age</th>
                    <th>Ship Owner First Name</th>
                    <th>Ship Owner Last Name</th>
                    <th>Ship Status</th>
        */

        let tr = document.createElement('tr');

        let shipIdTd = document.createElement('td');
        shipIdTd.innerHTML = ship.id;

        let shipNameTd = document.createElement('td');
        shipNameTd.innerHTML = ship.name;

        let shipAgeTd = document.createElement('td');
        shipAgeTd.innerHTML = ship.age;

        let shipOwnerFirstName = document.createElement('td');
        shipOwnerFirstName.innerHTML = ship.owner.firstName;

        let shipOwnerLastName = document.createElement('td');
        shipOwnerLastName.innerHTML = ship.owner.lastName;

        let shipStatus = document.createElement('td');
        shipStatus.innerHTML = ship.status.status;

        tr.appendChild(shipIdTd);
        tr.appendChild(shipNameTd);
        tr.appendChild(shipAgeTd);
        tr.appendChild(shipOwnerFirstName);
        tr.appendChild(shipOwnerLastName);
        tr.appendChild(shipStatus);

        tbody.appendChild(tr);
    }
}

window.addEventListener('load', onLoad);
