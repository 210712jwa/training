# Angular Components
Components are the basic building blocks for any Angular application. They provide for a way to segment different parts of the UI (user interface) into separate files for easier organization as well as providing the structure for the single page application. Components also contain the programming logic (TypeScript) associated with a particular component.

## Component Principles
- Angular apps are made up of multiple different components
- Components are intended to implement a single feature for the application that is visible on the screen
- Components wrap all of the HTML and TypeScript code to make the "widget" work correctly
- Components can be used multiple times
- Components can be nested inside of other components
- All Angular applications have an `app` component, which should be the most parent component
- Every component has the following files:
    - `app.component.html`: contains the HTML elements that belong to that particular component
    - `app.component.css`: contains the CSS styling for that particular component (very importantly, the styling does not cascade across to the nested components)
    - `app.component.ts`: contains the logic (behavior) of the component
    - `app.component.spec.ts`: contains the unit tests associated with this component

## @Component decorator
Inside of the `<component name>.component.ts` file, we will find the usage of a decorator called the component decorator.

```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
}
```
- selector: tells Angular that whenever it encounters the `<app-root>` tag, to render a component in place of that tag
- templateURL: specifies the relative location of the HTML template associated with this component
- styleUrls: specifies all of the CSS files that contain the styling for the HTML template