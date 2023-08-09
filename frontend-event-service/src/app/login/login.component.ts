import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email = ''
  password = ''
  isInvalidCredentials = false

  constructor(private router: Router) {
  }

  handleLogin() {
    if(this.password === 'password') {
      this.router.navigate(['events'])
    }
    else {
      this.isInvalidCredentials = true;
    }

  }
}
