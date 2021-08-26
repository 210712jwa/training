import { Component } from '@angular/core';

import { Person } from '../model/person';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  people: Person[] = [];

  formComponentShouldBeDisplayed: boolean = true;

  onToggleButtonClick() {
    this.formComponentShouldBeDisplayed = !this.formComponentShouldBeDisplayed;
  }

  onAddPerson(event: Person) {
    this.people.push(event); // This event object will be a Person object

    console.log(this.people);
  }
}
