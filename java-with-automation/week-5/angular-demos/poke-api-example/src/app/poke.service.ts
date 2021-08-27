import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from 'src/model/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  constructor(private http: HttpClient) {
  }

  getPokemonById(id: number): Observable<Pokemon> {
    return this.http.get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${id}`);
    // this.http.get<...>(...) returns an "Observable"
    // Observables are pretty similar to Promises
  }

}
