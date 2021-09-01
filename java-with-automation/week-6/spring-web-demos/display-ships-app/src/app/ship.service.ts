import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ship } from '../model/ship';

@Injectable({
  providedIn: 'root'
})
export class ShipService {

  constructor(private http: HttpClient) { }

  getShips(): Observable<Ship[]> {
    return this.http.get<Ship[]>('http://localhost:8080/spring-mvc-with-orm-demo/ship');
  }

}
