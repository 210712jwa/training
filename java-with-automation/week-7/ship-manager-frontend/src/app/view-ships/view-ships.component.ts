import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ship } from 'src/model/ship';
import { LoginService } from '../login.service';
import { ShipService } from '../ship.service';

@Component({
  selector: 'app-view-ships',
  templateUrl: './view-ships.component.html',
  styleUrls: ['./view-ships.component.css']
})
export class ViewShipsComponent implements OnInit {

  ships: Ship[] = [];

  constructor(private loginService: LoginService, private shipService: ShipService, private router: Router) { }

  ngOnInit(): void {
    this.getAllShips();
  }

  getAllShips() {
    this.shipService.getAllShips().subscribe((data: Ship[]) => {
      this.ships = data;
    }, (err: HttpErrorResponse) => {
      // If not logged in, navigate back to the login screen
      if (err.status === 401) {
        this.router.navigate([''])
      }
    });
  }

  logout() {
    this.loginService.logout().subscribe((data) => {
      this.router.navigate(['']);
    });
  }

}
