import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { JwtAuthenticationService } from './../service/jwt-authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

    constructor(private router: Router, private jwtAuthenticationService: JwtAuthenticationService) {
      }

    username = ''
    name = ''
    email = ''
    password = ''
    ableToRegister = true


    registerUser() {
         this.jwtAuthenticationService.register(this.username, this.password, this.name, this.email)
          .subscribe(
            data => {
              console.log(data)
              this.router.navigate(['/login'])
              this.ableToRegister = true
            },
            error => {
              console.log(error)
              this.ableToRegister = false
            }
          )
    }
}
