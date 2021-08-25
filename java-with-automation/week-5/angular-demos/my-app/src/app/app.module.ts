import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ExampleComponent } from './example/example.component';
import { AnotherComponentComponent } from './another-component/another-component.component';

@NgModule({
  declarations: [
    AppComponent,
    ExampleComponent,
    AnotherComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
