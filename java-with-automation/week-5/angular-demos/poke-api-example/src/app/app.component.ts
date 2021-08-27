import { Component } from '@angular/core';
import { Pokemon } from 'src/model/pokemon';
import { PokeService } from './poke.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  showPokeTableComponent: boolean = true;

  arrowFunction = (data: Pokemon) => {
    this.pokemonArr.push(data);
  };

  pokemonArr: Pokemon[] = [];

  // Angular automatically figures out when it needs to instantiate the AppComponent,
  // that it also needs to provide a PokeService object
  // To provide this object, Angular also first needs to instantiate a PokeService
  // object and then keep track of that object
  constructor(private pokeService: PokeService) {
  }

  ngOnInit(): void {
    this.pokeService.getPokemonById(1).subscribe(this.arrowFunction);
    this.pokeService.getPokemonById(2).subscribe(this.arrowFunction);
    this.pokeService.getPokemonById(3).subscribe(this.arrowFunction);

    this.pokeService.getPokemonById(4).toPromise().then((data) => {
      this.pokemonArr.push(data);
    });
  }

  onSearch(event: number) {
    // getPokemonById(...) is returning the observable that was returned from the get(...)
    // method.

    // Whenever a response is received, the Observable will "publish" the response
    // to the subscriber

    // const arrowFunction = (data: Pokemon) => {
    //   this.pokemonArr.push(data);
    // };
    // This arrow function is the subscriber, that will received the published
    // data, and then perform some operations on that data

    this.pokeService.getPokemonById(event).subscribe(this.arrowFunction);
  }

}
