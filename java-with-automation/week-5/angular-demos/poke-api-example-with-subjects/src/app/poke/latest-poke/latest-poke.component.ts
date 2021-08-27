import { Component, OnInit } from '@angular/core';
import { PokeService } from 'src/app/poke.service';
import { Pokemon } from 'src/model/pokemon';

@Component({
  selector: 'app-latest-poke',
  templateUrl: './latest-poke.component.html',
  styleUrls: ['./latest-poke.component.css']
})
export class LatestPokeComponent implements OnInit {

  latestPokemon!: Pokemon;

  constructor(private pokeService: PokeService) {}

  ngOnInit(): void {
    const subject = this.pokeService.getSubject();

    subject.subscribe((pokemon) => {
      this.latestPokemon = pokemon;
    });
  }

}
