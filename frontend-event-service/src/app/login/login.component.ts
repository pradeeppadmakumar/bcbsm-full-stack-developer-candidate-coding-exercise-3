import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtAuthenticationService } from './../service/jwt-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email = ''
  password = ''
  isInvalidCredentials = false

  constructor(private router: Router, private jwtAuthenticationService: JwtAuthenticationService) {
  }

  handleSignIn() {
    this.router.navigate(['register'])
  }

  handleLogin() {
       this.jwtAuthenticationService.authenticate(this.email, this.password)
          .subscribe(
            data => {
              console.log(data)
              this.router.navigate(['/'])
              this.isInvalidCredentials = false
            },
            error => {
              console.log(error)
              this.isInvalidCredentials = true
            }
          )
  }

  handleLogout() {

  }
}
