import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/model/user';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  showErrorMessage: boolean = false;
  errorMessage: string = '';

  constructor(private ls: LoginService, private router: Router) {
  }

  ngOnInit(): void {
    this.checkIfAlreadyLoggedIn();
  }

  login() {
    this.ls.login(this.username, this.password).subscribe((data: User) => {
      // This callback function is invoked if logging in was successful (2XX status code)
      this.router.navigate(['view-ships']);
    },
    (err: HttpErrorResponse) => {
      // This callback is invoked if logging in was not successful (4XX or 5XX status code)
      this.showErrorMessage = true;
      this.errorMessage = err.error.message;
    });
  }

  checkIfAlreadyLoggedIn() {
    this.ls.checkIfLoggedIn().subscribe((data) => {
      // if we have a 2xx status code, it will invoke this callback function
      // therefore, we would know that we are logged in, because currentuser returns 200
      // if we are indeed logged in already
      this.router.navigate(['view-ships']);
    });

  }

}
