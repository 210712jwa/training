module.exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',
    capabilities: {
        'browserName': 'chrome',
        'shardTestFiles': true,
        'maxInstances': 2
    },

    framework: 'jasmine',
    specs: [
        './specs/spec1.js'
    ],

    jasmineNodeOpts: {
        defaultTimeoutInterval: 30000
    }
};