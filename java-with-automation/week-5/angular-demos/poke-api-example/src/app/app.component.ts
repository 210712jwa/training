import { Component } from '@angular/core';
import { Pokemon } from 'src/model/pokemon';
import { PokeService } from './poke.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  pokemon: Pokemon[] = [];

  constructor(private pokeService: PokeService) {}

  onSearch(event: number) {
    this.pokeService.getPokemonById(event).subscribe((data) => {
      this.pokemon.push(data);
    });
  }

}
