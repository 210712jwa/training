# RxJS Observables and Subjects

## Observables
Observables are from the RxJS library, which the developers of Angular simply decided to utilize within the Angular framework. Therefore this preference of the Angular developers is what led to the fact that we deal with Observables instead of Promises when it comes to the HttpClient (unlike with fetch).

- Similar to promises, observables require some callback function for the data to passed into once the data is made available
    - Where they differ is in the fact that observables can have multiple values instead of one, OVER TIME
- You can have multiple subscribers to an observable, while you can only have a single subscriber to a promise
- Observables can be cancelled, Promises cannot
- Overall, however, promises and observables are pretty similar
    - You can actually convert from an observable to a Promise
    - But, this should only be done if you are expecting only a single value from the Observable (such as when you utilize HttpClient)
        - Because HttpClient will send a single request, and receive a single response

## Subjects
- Subjects follow the pattern of pub-sub (publisher - subscriber)
- We can publish values to a subject (using .next(<value>))
- Any subscriber to the subject will then receive that "update"
    - An analogy would be a weather channel where we publish weather updates to all viewers and listeners
