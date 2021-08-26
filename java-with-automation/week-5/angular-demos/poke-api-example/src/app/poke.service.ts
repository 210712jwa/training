import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from 'src/model/pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  getPokemonById(id: number): Observable<Pokemon> {
    return this.http.get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${id}`)
  }

}
