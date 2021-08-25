import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  firstName: string = "";
  lastName: string = "";
  imageLink: string = "";

  constructor() {}

  ngOnInit(): void {
  }

  onFirstNameInput(event: Event) {
    this.firstName = (event.target as HTMLInputElement).value;
  }

  onLastNameInput(event: Event) {
    this.lastName = (event.target as HTMLInputElement).value;
  }

  onImageLinkInput(event: Event) {
    this.imageLink = (event.target as HTMLInputElement).value;
  }

}
