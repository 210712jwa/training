/**
 * Events in HTML propagate through the DOM
 * 
 * There are 2 phases during propagation: 
 *  1. capturing
 *  2. bubbling
 * 
 * When we add event listeners to elements, we can have the
 * callback function triggered on the event in either phase
 * 
 * This allows us to define the order that some event listeners 
 * are executed (to a certain extent)
 * 
 * With event listeners in the bubbling phase, the innermost 
 * element occurs first, followed by the outer elements
 * 
 * With event listeners in the capturing phase, the outermost
 * element will occur first, followed by inner elements
 * 
 * When an event is triggered, the event always starts out 
 * in the outermost element in the capturing phase. It then
 * makes its way to the target element (the one that actually
 * got clicked), and then bubbles back up to the top of the DOM
 */

// The addEventListener function has a third optional parameter,
// which accepts a boolean
// The default value of this parameter is false
// false corresponds to "bubbling"
// true corresponds to "capturing"
// This parameter will determine in which phase 
// the callback function will actually be invoked for the event

let capturing = true;
let bubbling = false;

// Bubbling event listeners
document.getElementById('inner').addEventListener('click', () => {
    alert('INNER - BUBBLING');
}, bubbling);

document.getElementById('middle').addEventListener('click', (e) => {
    alert('MIDDLE - BUBBLING');
    // We can use a stopPropagation() method
    // and stopImmediatePropagation() method
    // to prevent this event from further propagating through the DOM

    // stopPropagation() will prevent the event from hitting any listeners
    // from other elements

    // stopImmediatePropagation() does the same but stops any other listeners on this same element (stop ties)
    
    // e.stopPropagation();
}, bubbling);

document.getElementById('outer').addEventListener('click', () => {
    alert('OUTER - BUBBLING');
}, bubbling);

// Capturing event listeners
document.getElementById('inner').addEventListener('click', () => {
    alert('INNER - CAPTURING');
}, capturing);

document.getElementById('middle').addEventListener('click', () => {
    alert('MIDDLE - CAPTURING');
}, capturing);

document.getElementById('outer').addEventListener('click', () => {
    alert('OUTER - CAPTURING');
}, capturing);

/**
 * On the target element, if there are event listeners on both the capturing and bubbling phase, then 
 * technically they could occur at the same time
 * 
 * The specific browser's implementation will decide which one happens first
 * 
 * Google Chrome will execute them 'capturing' first, 'bubbling' after.
 */