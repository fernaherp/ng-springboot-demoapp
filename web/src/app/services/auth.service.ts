import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { UserModel } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor( private http: HttpClient ) { }

	login( user: UserModel ) {
		return this.http.post('http://localhost:8080/demoapp/login', user);
	}
	
	logout() {
		
	}
}
