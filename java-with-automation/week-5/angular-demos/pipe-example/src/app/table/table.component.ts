import { Component, Input, OnInit } from '@angular/core';

import { Car } from '../../model/car';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input('myCars')
  myCars: Car[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
