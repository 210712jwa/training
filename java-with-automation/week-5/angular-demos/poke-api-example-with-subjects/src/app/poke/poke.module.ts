import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokeTableComponent } from './poke-table/poke-table.component';
import { LatestPokeComponent } from './latest-poke/latest-poke.component';



@NgModule({
  declarations: [
    PokeTableComponent,
    LatestPokeComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PokeTableComponent,
    LatestPokeComponent
  ]
})
export class PokeModule { }
