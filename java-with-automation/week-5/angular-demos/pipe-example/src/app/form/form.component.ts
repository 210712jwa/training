import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Car } from '../../model/car';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output('addCar')
  addCar: EventEmitter<Car> = new EventEmitter();

  makeInputValue: string = "";
  modelInputValue: string = "";
  yearInputvalue: number = 0;
  priceInputvalue: number = 0;
  topSpeedInputvalue: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  addRecord() {
    let car: Car = {
      'make': this.makeInputValue,
      'model': this.modelInputValue,
      'year': this.yearInputvalue,
      'price': this.priceInputvalue,
      'topSpeed': this.topSpeedInputvalue
    }

    this.addCar.emit(car);
  }

}
