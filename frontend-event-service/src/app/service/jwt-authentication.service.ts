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

  authenticate(username: string, password: string) {

    return this.http.post<any>(
      "http://localhost:8080/auth/login", { "username": username , "password" : password}
    ).pipe(
      map(
        data  => {
          sessionStorage.setItem('authenticatedUser', data.user.username);
          sessionStorage.setItem('authenticatedUserId', data.user.id);
          sessionStorage.setItem('token', "Bearer " + data.jwt);
          sessionStorage.setItem('role', JSON.parse(atob(data.jwt.split('.')[1])).roles);
          return data;
        }
      )
    );
  }

  register(username: string, password: string,  name: string, email: string) {

      return this.http.post<any>(
        "http://localhost:8080/auth/register", { "username": username , "password" : password, "email" : email, "name": name}
      );
    }

  getAuthenticatedUser() {
      return sessionStorage.getItem("authenticatedUser")
    }

   getAuthenticatedToken() {
      if (this.getAuthenticatedUser())
        return sessionStorage.getItem('token')
      return null
    }

   isAdminUser() {
      if (this.getAuthenticatedUser())
        return sessionStorage.getItem('role') === 'ADMIN';
      return false;
    }


  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser');
    return user !== null;
  }

  logout() {
    sessionStorage.clear();
  }
}
