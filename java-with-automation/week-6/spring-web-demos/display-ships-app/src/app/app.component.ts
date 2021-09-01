import { Component } from '@angular/core';
import { ShipService } from './ship.service';
import { Ship } from '../model/ship';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  ships: Ship[] = [];

  constructor(private shipService: ShipService) {}

  ngOnInit() {
    this.shipService.getShips().subscribe((data) => {
      this.ships = data;
    });
  }

}
