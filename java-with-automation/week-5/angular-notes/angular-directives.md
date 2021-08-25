# Directives

Directives are a construct of Angular. In particular, they "direct" elements within our component templates on what to do. There are 3 different types of directives:
1. Component: components are technically directives themselves, because they do indeed "direct" what should be rendered on the DOM
2. Structural Directives: used to manipulate and change the **structure** of the DOM
3. Attribute Directives: used to change the look of elements

## Structural Directives
As stated previously structural directives manipulate the actual structure of the DOM. We can control when elements get displayed, how many of them get displayed, and switch to what gets displayed based on different conditions.

- *ngIf: used for conditional rendering. If an element with this directive evaluates to false, the element will not be displayed
- *ngFor: used to render a certain block of HTML multiple times. We can iterate over different data structures and populate the data according to what is contained in each iteration.
- ngSwitch
    - [ngSwitch]: attribute directive which controls
        - *ngSwitchCase: structural
        - *ngSwitchDefault: structural

## Attribute Directives
Attribute directives are used to change the attributes of the DOM elements. There are two built-in attribute directives
- ngClass
- ngStyle

### ngClass
ngClass is used for adding or removing the CSS classes from an HTML element. This allows us to apply classes dynamically based on a certain expression

```html
<div [ngClass]="<value>"></div>
```
- The value that can go inside of the double quotes `" "` can be
    - A string: `<div [ngClass]="'class-one class-two class-three'"></div>`
    - An array: `<div [ngClass]='['class-one', 'class-two', 'class-three']'></div>`
    - Object: `<div [ngClass]='{ 'class-one': aVariable === 'someStringValue', 'class-two': true, 'class-three': true }'></div>`

### ngStyle
ngStyle is used when we want to dynamically change the style of an HTML element based on a certain expression

