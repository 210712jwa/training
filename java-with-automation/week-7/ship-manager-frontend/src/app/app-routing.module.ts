import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewShipsComponent } from './view-ships/view-ships.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'view-ships', component: ViewShipsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
