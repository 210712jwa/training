import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnotherExampleComponent } from './app/another-example/another-example.component';
import { ExampleComponent } from './app/example/example.component';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'example', component: ExampleComponent },
  { path: 'anotherexample', component: AnotherExampleComponent },
  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
