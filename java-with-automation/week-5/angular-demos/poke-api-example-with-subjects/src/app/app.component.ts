import { Component } from '@angular/core';
import { PokeService } from './poke.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  pokemonIdInput: number = 0;

  constructor(private pokeService: PokeService) {}

  onGetPokemonClick() {
    this.pokeService.getPokemonById(this.pokemonIdInput);
  }

}
