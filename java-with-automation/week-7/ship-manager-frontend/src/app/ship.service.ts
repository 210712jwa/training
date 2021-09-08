import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ship } from 'src/model/ship';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ShipService {

  constructor(private hc: HttpClient) { }

  getAllShips(): Observable<Ship[]> {
    return this.hc.get<Ship[]>(`${environment.backendUrl}/ship-manager/ship`, {
      withCredentials: true
    });
  }

}
