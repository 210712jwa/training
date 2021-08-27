const { browser } = require('protractor');

// This is Jasmine syntax for writing tests in JavaScript
// You can think of Jasmine as being similar to JUnit for Java
describe('this will be for a collection of tests', function() {
    it('this is test 1', function() {
        // browser is coming from protractor, which is similar to Selenium
        browser.get('https://angular.io');
    });

    it('this is test 2', function() {
        browser.close();
    });
})