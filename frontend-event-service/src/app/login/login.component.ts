import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HardCodedAuthenticationService } from './../service/hard-coded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email = ''
  password = ''
  isInvalidCredentials = false

  constructor(private router: Router, private hardCodedAuthenticationService: HardCodedAuthenticationService) {
  }

  handleSignIn() {
    this.router.navigate(['register'])
  }

  handleLogin() {
    if(this.hardCodedAuthenticationService.authenticate(this.email, this.password)) {
      this.router.navigate(['/'])
    }
    else {
      this.isInvalidCredentials = true;
    }

  }

  handleLogout() {

  }
}
