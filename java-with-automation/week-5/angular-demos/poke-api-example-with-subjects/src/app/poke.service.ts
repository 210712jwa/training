import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from '../model/pokemon';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokeService {

  private subject: Subject<Pokemon>

  constructor(private http: HttpClient) {
    this.subject = new Subject();
  }

  getPokemonById(id: number): void {
    this.http.get<Pokemon>(`https://pokeapi.co/api/v2/pokemon/${id}`).subscribe((pokemon) => {
      this.subject.next(pokemon); // Here we are publishing the pokemon to the subject
      // Any subscriber to the subject will be able to receive this pokemon data
    });
  }

  getSubject(): Subject<Pokemon> {
    return this.subject;
  }

}
