module.exports.pubSub = pubSub;

function pubSub() {
    
    const subscribers = {}; // the subscribers object will contain properties whose values are arrays
    // each property is the channelName, and the array is composed of subscriber elements (callbacks)

    function publish(channelName, data) {
        if(!Array.isArray(subscribers[channelName])) {
            return;
        }

        subscribers[channelName].forEach((subscriber) => {
            subscriber(data);
        });
    }

    function subscribe(channelName, subscriber) {
        if(!Array.isArray(subscribers[channelName])) {
            subscribers[channelName] = [];
        }

        subscribers[channelName].push(subscriber);
    }

    return { publish, subscribe };
};