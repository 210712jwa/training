import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { SwitchExampleComponent } from './switch-example/switch-example.component';
import { TableComponent } from './table/table.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    SwitchExampleComponent,
    TableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
