const buttonElement = document.querySelector('#btn');
const bodyElement = document.querySelector('body');

buttonElement.addEventListener('click', () => {
    setTimeout(() => {
        const pElement = document.createElement('p');
        pElement.innerHTML = 'This is the p element that appears 5 seconds later';
        bodyElement.appendChild(pElement);
    }, 5000);
});