# Two-way databinding

To achieve passing data from an input element to the component class using one-way databinding, we would've had to perform event binding on the `input` event, call a function defined over in the component class with the event object being passed to this function, and then getting the target element of that event and setting the value property of that target element to the variable we want to change over in our component class.

However, with two-way databinding, there are much fewer steps required in order to link input elements' values with variables defined in the component class. The way we can set this up is through importing the `FormsModule` and making that available to our components within our <module name>.module.ts file.

By default, whenever we generate components, they will belong to the AppModule itself. A module is a group of components that should be able to share functionalities from the different imports that are declared inside of the AppModule file.

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

Normally the AppModule would look something like the above. In this case, we have the default AppComponent and our own user defined FormComponent that belong to this module. We have available to us all of the functionalities that are inside of the BrowserModule, which as you can see is listed in the imports property of the @NgModule decorator.

To make use of two-way databinding, which is provided through the `[(ngModel)]` directive, we need to first of all gain access to this directive. It is part of the FormsModule, which we would need to import. So, making the appropriate changes to our AppModule file would allow for the AppComponent AND FormComponent to have access to this directive.

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

## Making use of ngModel
If we want to bind a variable in our component class with the input element's value, we just need to place the `[(ngModel)]` decorator on our input element and then set its value to the variable name

```html
<div>
  <label class="form-label">First Name</label>
  <input [(ngModel)]="firstName" type="text" class="form-control">
</div>
```

Over in our component class, we simply need to have a variable defined for that component object.

```typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  firstName: string = "";

  constructor() { }

  ngOnInit(): void {
  }

}
```