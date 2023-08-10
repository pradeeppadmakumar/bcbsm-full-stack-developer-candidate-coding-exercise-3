import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JwtAuthenticationService {

  constructor(
      public http: HttpClient
    ) { }

  authenticate(email: string, password: string) {

    return this.http.post<any>(
      "http://localhost:8080/auth/login", { "username": email , "password" : password}
    ).pipe(
      map(
        data  => {
          sessionStorage.setItem('authenticatedUser', data.user.username);
          sessionStorage.setItem('authenticatedUserId', data.user.userId);
          sessionStorage.setItem('token', "Bearer " + data.jwt);
          return data;
        }
      )
    );
    /* if(password === 'password') {
      sessionStorage.setItem('authenticatedUser', email);
      return true;
    }

    return false; */
  }

  getAuthenticatedUser() {
      return sessionStorage.getItem("authenticatedUser")
    }

   getAuthenticatedToken() {
      if (this.getAuthenticatedUser())
        return sessionStorage.getItem('token')
      return null
    }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser');
    return user !== null;
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser');
  }
}
