import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardCodedAuthenticationService {

  constructor() { }

  authenticate(email: string, password: string) {
    if(password === 'password') {
      sessionStorage.setItem('authenticatedUser', email);
      return true;
    }

    return false;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser');
    return user !== null;
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser');
  }
}
