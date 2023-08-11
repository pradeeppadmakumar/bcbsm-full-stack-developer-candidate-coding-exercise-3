import { Component } from '@angular/core';
import { JwtAuthenticationService } from './../service/jwt-authentication.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {

  constructor( public jwtAuthenticationService: JwtAuthenticationService) {
    }

}
