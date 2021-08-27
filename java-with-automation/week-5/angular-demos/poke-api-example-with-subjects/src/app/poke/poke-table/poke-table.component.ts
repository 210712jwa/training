import { Component, OnInit } from '@angular/core';
import { PokeService } from 'src/app/poke.service';
import { Pokemon } from 'src/model/pokemon';

@Component({
  selector: 'app-poke-table',
  templateUrl: './poke-table.component.html',
  styleUrls: ['./poke-table.component.css']
})
export class PokeTableComponent implements OnInit {

  pokemonArr: Pokemon[] = [];

  constructor(private pokeService: PokeService) { }

  ngOnInit(): void {
    const subject = this.pokeService.getSubject();

    subject.subscribe((pokemon) => {
      this.pokemonArr.push(pokemon);
    });
  }

}
