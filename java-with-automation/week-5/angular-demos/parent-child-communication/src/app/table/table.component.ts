import { Component, Input, OnInit } from '@angular/core';

import { Person } from '../../model/person';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input('myPeople')
  myPeople: Person[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
