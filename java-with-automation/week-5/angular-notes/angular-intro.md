# Angular

Angular is an open-source framework developed by Google, intended to be used to create **single page applications** (SPAs) using TypeScript as the programming language.

## TypeScript
TypeScript is a superset of JavaScript, meaning that all JavaScript is valid TypeScript. TypeScript adds additional functionality and features on top of JavaScript.

TypeScript is developed by Microsoft and supports
- Strong typing / static typing (unlike JavaScript, hence the word Type)
- Classes
- Interfaces
- Decorators

TypeScript is **transpiled** into JavaScript
- Transpilation v. Compilation
    - Transpilation: Transform source code from one language into another (with a similar level of abstraction)
    - Compilation: Transform source code into lower level code (binary, bytecode, assembly, etc.)
- TypeScript files are saved with a `.ts` extension instead of `.js`
- JavaScript is what the browser understands, so that is why we need to convert from TS to JS

## Single Page Application (SPA)
A single page application is a frontend web application that operates from a single page. Whenever we visit a website that hosts a single page application, all of the associated code (HTML, CSS, JavaScript) are loaded all at once. Whenever we navigate to another "page", elements are added, removed, or changed through **DOM Manipulation**.

Single page application advantages
- Fast and responsive
- Caching capabilities

Single page application disadvantages
- Poor search engine optimization (SEO)
- Data is frontloaded (because all of the JavaScript, HTML, CSS is loaded at once)

## Versions (History of Angular)
Angular has many different versions, the latest being Angular 12. Although Angular is open-source, Google has a dedicated team responsible for updating Angular on a regular basis, adding new features or creating bug fixes and enhancements.

It is important to distinguish between AngularJS and what is more commonly known as Angular 2. AngularJS is an entirely different framework from Angular 2+. AngularJS is an entirely different framework from Angular 2 and onwards. In summary, we have

- AngularJS / Angular 1 (October 2010)
    - Completely different framework than the newer version of Angular
    - So if you find tutorials and documentation on AngularJS, DON'T USE THEM
- Angular 2 (September 2016)
    - Newer framework
    - Up Angular 12 (May 2021)
    - This is the modern Angular

Whenever you look up documentation and tutorails on how to accomplish something in Angular, please distinguish between AngularJS and Angular 2+. Whatever tutorial you find for AngularJS WILL NOT work for Angular 2+.

## Revisiting Node.js
Remember in week 3 that I said Node.js was a runtime environment for JavaScript, intended for backend applications, such as REST API servers written using JavaScript. Angular, however, is a frontend framework for developing single page applications which run in the browser. 

So, why do we need Node.js? Node is required for obtaining and running all of the build and development tools that we need to use, such as
- npm (node package manager): very important in helping us manage dependencies, similar to one of the purposes of Maven
- npm provides us with access to Angular CLI (command line interface), which allows us to easily create new Angular projects, modules, components, pipes, services, etc. Angular CLI also helps us to run tests, to build our project, and also to start up a development server
    - This development server runs within the node environment for us to host our application locally while developing it

## Node Package Manager
Similar to how we can utilize Maven as a dependency manager, node package manager (npm) allows us to manage dependencies for a JavaScript application. Whenever we generate a new Angular project using `ng new <project name>`, it is also generating a new file within the root directory of the project called the `package.json` file.

The package.json file contains metadata to identify our project such as the project description, version, licensing information, etc. It contains a list of the required project dependencies as well. The dependencies are split into two different categories: `dependencies` and `devDependencies`.
- `dependencies` lists all of the dependencies necessary for running the final application
- `devDependencies` lists all of the dependencies that are only necessary during development. An example would be dependencies such as Karma, which is used for running tests

# Using Angular CLI
Angular CLI is a command line interface that assists developers in getting started with creating Angular applications. Angular CLI generates a basic Angular project structure containing
- The default app module
- The default app component
- The basic files necessary for "bootstrapping" an Angular application
    - index.html
        - The file served whenever someone visits the website
        - When we build the Angular application using the CLI, it automatically adds the `<link>` and `<script>` tags (through Webpack)
    - Main.ts: contains the initial logic that starts up our Angular application
- TypeScript transpiler property files
- package.json
- etc.

In order to have access to Angular CLI, we need to install it using npm by running `npm install -g @angular/cli`.

## Creating a project
Once Angular CLI is installed, we simply run `ng new <project name>` in order to create a new Angular app with the specified project name. This will create a project that utilizes
- TypeScript for the programming language
- Webpack to bundle all of our code (HTML, CSS, JavaScript) together into a small number of files whenever we build our Application
- Karma for writing and running unit tests
- Protractor for end-to-end testing

## Webpack
Webpack is a powerful module bundler that will bundle all of the JavaScript modules and required dependencies together into a single file to be executed by the browser. This is what Angular utilizes behind the scenes when we actually build our project. It will bundle together all of the component HTML files, CSS files, and JavaScript (TypeScript gets converted into JS) into a single HTML file, a single CSS file, and a small number of JS files that are linked to this HTML file through the `<script>` tag.