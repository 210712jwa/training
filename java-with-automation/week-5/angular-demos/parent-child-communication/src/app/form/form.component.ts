import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { Person } from '../../model/person';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  @Output('addPerson')
  addPerson: EventEmitter<Person> = new EventEmitter();

  firstNameInputValue: string = "";
  lastNameInputValue: string = "";
  ageInputvalue: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  addRecord() {
    let person: Person = {
      'firstName': this.firstNameInputValue,
      'lastName': this.lastNameInputValue,
      'age': this.ageInputvalue
    }

    this.addPerson.emit(person);
  }

}
