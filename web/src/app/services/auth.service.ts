import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { UserModel } from '../models/user.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // store the URL so we can redirect after logging in
  redirectUrl: string;
  userToken: string;

  constructor( private http: HttpClient, private router: Router ) {
    this.readToken();
  }

  login(user: UserModel) {
    return this.http.post(
      'http://localhost:8080/demoapp/authenticate', user
    ).pipe(
      map( resp => {
        this.setSession( resp['token'], resp['expTime'] );
        return resp;
      })
    );
  }

  isLoggedIn(): boolean {
    if ( !localStorage.getItem('token') || !localStorage.getItem('tokenExpTime') ) {
      return false;
    } else {
      if ( Number(localStorage.getItem('tokenExpTime')) > new Date().getTime() ) {
        return true;
      } else {
        this.logout();
        return false;
      }
    }
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('tokenExpTime');
    this.router.navigate(['/login']);
  }

  private setSession( token: string, tokenExpTime: string ) {
  this.userToken = token;
  localStorage.setItem('token', token);
  localStorage.setItem('tokenExpTime', tokenExpTime);
  }

  private readToken() {
    if ( localStorage.getItem('token') ) {
      this.userToken = localStorage.getItem('token');
    } else {
      this.userToken = '';
    }

    return this.userToken;
  }
}
