# One-way Data Binding

At this point, we have already established the structure of components. Components consist of 3 different files that specify
- The structure of that component (<name>.component.html)
- The styling of that component (<name>.component.css)
- The logic of that component (<name>.component.ts)

**Data binding** is the process whereby communication occurs between our component and the DOM. The way that data binding occurs is through binding data
- From the component HTML template to the component class
- From the component class to the HTML template

There are two ways of performing data binding:
1. One-way data binding
2. Two-way data binding

We will examine the 3 different types of ONE-WAY data binding:
1. String interpolation (Component class to HTML template)
2. Property binding (Component class to HTML template)
3. Event binding (HTML template to the component class)

## String Interpolation
String interpolation is the process whereby data can be passed from the component class to the HTML template. This is accomplished using double curly brace syntax `{{ }}`

Example: If we have inside our our app.component.ts file a variable called `username` with the value `user12345`

```typescript
export class AppComponent {
    username = "user12345";
}
```

We can pass the value of the `username` variable over to the template to be rendered whenever that component is displayed.

```html
<p>{{ username }} is logged in.</p>
```

## Property Binding
Property binding is also a process whereby data is passed from the component class to the template. Where it is different than property binding is that property binding is used to bind values to the attributes of HTML elements.

What is an HTML attribute again? It is any property that is defined for a particular HTML element that usually has a corresponding value (not always). For example, the `<img>` tag will usually have an associated `src` attribute to specify an image file to display. Other common attributes include `href`, `id`, `class`, `name`, etc. 

Example: inside of the app.component.ts file, we might have a variable containing the link to an image

```typescript
export class AppComponent {
    image = "http://somewebsite.com/myimage.jpg";
}
```

Inside of the app.component.html file, we can have the `src` attribute of the img tag binded to the image variable.

```html
<h1>Property binding</h1>
<img [src]="image">
```

## Event Binding
Event binding, as opposed to string interpolation and property binding, is a way to pass data from the HTML template to the component class. In this case, we bind DOM events such as keystrokes, clicks, mouseovers, etc. to some function that is defined in the component class. This function will then be executed whenever this event occurs (on some element)

For example, if we have an input element that we are typing into, we can bind the `change` event to detect when the value of the input element is changed. This will allow us to grab the value property of the input element and update a variable defined in the component class, for example.

```html
<input type="text" (change)="onChange($event)">
```
- Here we bind the change event such that the onChange function will be invoked
- The $event argument is a special argument in Angular that will pass the event object itself over to the function when it is invoked in the component class

```typescript
export class AppComponent {

    text = "";

    onChange(event) {
        this.text = event.target.value;
    }
}
```