const { pubSub } = require('./pubsub');

const { publish, subscribe } = pubSub();

subscribe('weather', (data) => {
    console.log(data);
});

subscribe('weather', (data) => {
    console.log(data);
});

subscribe('weather', (data) => {
    console.log(data);
});

subscribe('investing', (data) => {
    console.log(data);
});

subscribe('investing', (data) => {
    console.log(data);
});

publish('weather', 'Today is cloudy with a 50% chance of rain');
publish('investing', 'The SP500 is up 1% today');
publish('someOtherChannel', 'some other data');