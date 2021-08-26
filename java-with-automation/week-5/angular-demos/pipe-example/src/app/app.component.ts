import { Component } from '@angular/core';

import { Car } from '../model/car';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  cars: Car[] = [];

  formComponentShouldBeDisplayed: boolean = true;

  onToggleButtonClick() {
    this.formComponentShouldBeDisplayed = !this.formComponentShouldBeDisplayed;
  }

  onAddCar(event: Car) {
    this.cars.push(event); // This event object will be a Person object
  }
}
