# Component to Component Communication

Before this point, we only discussed passing data from the template to the class of a single component. However, in an application with many different components all interacting with each other, we need a way to pass data from one component to another. We can break down this component to component communication in the following ways:
1. parent-to-child
2. child-to-parent

## Parent-to-child
If our parent component has some data that we would like to pass to the child, we would need to utilize the `@Input()` decorator in order to have a variable inside of our child component behave as an "attribute".

```typescript
import { Component, Input, OnInit } from '@angular/core';

import { Person } from '../../model/person';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input('myPeople')
  myPeople: Person[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
```

From the perspective of the parent component, whenever we reference this TableComponent in the example above, there is an attribute of the `<app-table>` tag that is called myPeople. If we think back to the idea of one-way databinding, the way that we can bind information from a component to an element within that component's template is through property binding. So, we can perform property binding on this myPeople attribute as well.

So, inside of our app.component.html, where we are displaying the table component, we can bind a variable from our app component class to this attribute. This effectively binds the people variable that exists in the parent (app component) to the myPeople variable in the child component (table component)
```html
<app-table [myPeople]="people"></app-table>
```

## Child-to-parent
If our child component has some data that we would like to pass to a parent component, we would need to utilize the `@Output()` decorator in order to emit an event whose event object contains that data.

In our child component's class file:

```typescript
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Person } from '../../model/person';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output('addPerson')
  addPerson: EventEmitter<Person> = new EventEmitter();

  firstNameInputValue: string = "";
  lastNameInputValue: string = "";
  ageInputvalue: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  addRecord() {
    let person: Person = {
      'firstName': this.firstNameInputValue,
      'lastName': this.lastNameInputValue,
      'age': this.ageInputvalue
    }

    this.addPerson.emit(person);
  }

}
```

Examining the above code, we can see that we have a variable called addPerson with a decorator `@Output('addPerson')` being placed above it. The addPerson variable should be of the EventEmitter type, with a generic that specifies what type the event object that will be emitted should be. In our case, we want the event object to be a Person object.

Whenever the addRecord function is invoked (in this case, by pressing a button), it will leverage the `emit(...)` function that belongs to the EventEmitter object in order to emit an event called `addPerson`, with the event object being a Person object.

In the parent class's HTML template:

```html
<app-form (addPerson)="onAddPerson($event)" *ngIf="formComponentShouldBeDisplayed"></app-form>
```
- The important line here is the `(addPerson)="onAddPerson($event)"`
- We are binding an event called addPerson, such that whenever it occurs, it will invoke the onAddPerson function defined in our parent class
- The `$event` argument is referring to the event object itself, which happens to be a Person object