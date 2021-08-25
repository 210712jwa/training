import { Component, OnInit } from '@angular/core';

import { Person } from '../../model/person';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  firstNameInputValue: string = "";
  lastNameInputValue: string = "";
  ageInputvalue: number = 0;

  people: Person[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  addRecord() {
    let person: Person = {
      'firstName': this.firstNameInputValue,
      'lastName': this.lastNameInputValue,
      'age': this.ageInputvalue
    }

    this.people.push(person);
  }

}
