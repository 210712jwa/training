# Angular Modules

Every Angular application requires at least one module. This root module is known as the App module. Modules are classes that are decorated with the `@NgModule` decorator, which contains metadata that describes the components, directives,a nd pipes that belong to that module.

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
- declarations: contains the coponents, directives, and pipes that belong to the module
- imports: contains modules from which we want to make use of certain components, directives, pipes, services, etc. from
- providers: list of service providers that the application requires
- bootstrap: contains the root component of the application that should be started up and rendered whenever we initialize the application

# Angular Application Startup Process (Bootstrapping)
It is important to understand the steps Angular takes in order to render the various components that make up our single page application.

- The `main.ts` file is the entry point for our Angular application
    - This file makes reference to the AppModule
- Within the AppModule, there is a `bootstrap` property within the `@NgModule` decorator that will specify that AppComponent should be bootstrapped
- Angular will instantiate AppComponent, and find that the `selector` property within the `@Component` decorator is defined as `app-root`
- The index.html that initially contains the `<app-root></app-root>` tag will then be replaced with whatever AppComponent has within its template
- Angular will then inspect for any child components that are referred to within the AppComponent template, and render those
- This will continue until all components that should be currently rendered at startup are actually rendered

## Practical Steps for bootstrapping:
1. Angular loads up each component and inspects the `selector` property located within the `@Component` decorator
2. Angular inspects the HTML document for the appropriate tag corresponding the `selector` property
3. Angular then replaces the tag with the template corresponding to the appropriate component
4. This process is repeated for other components that should be rendered at that time