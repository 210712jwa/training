import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-switch-example',
  templateUrl: './switch-example.component.html',
  styleUrls: ['./switch-example.component.css']
})
export class SwitchExampleComponent implements OnInit {

  someVariable: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  onButtonOneClick() {
    this.someVariable = 'first-case';
  }

  onButtonTwoClick() {
    this.someVariable = 'second-case';
  }

  onButtonThreeClick() {
    this.someVariable = 'third-case';
  }

}
