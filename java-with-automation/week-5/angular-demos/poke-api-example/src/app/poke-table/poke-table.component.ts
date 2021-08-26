import { Component, Input, OnInit } from '@angular/core';
import { Pokemon } from 'src/model/pokemon';

@Component({
  selector: 'app-poke-table',
  templateUrl: './poke-table.component.html',
  styleUrls: ['./poke-table.component.css']
})
export class PokeTableComponent implements OnInit {

  @Input()
  pokemon: Pokemon[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
