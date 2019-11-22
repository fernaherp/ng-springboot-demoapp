import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { UserModel } from '../../models/user.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: UserModel = new UserModel();
  message: string;

  constructor( private authService: AuthService, private router: Router ) { }

  ngOnInit() {
  }

  login( form: NgForm ) {
    this.authService.login( this.user ).subscribe( (resp) => {
      const redirect = this.authService.redirectUrl ? this.router.parseUrl(this.authService.redirectUrl) : '/protected/home';

      this.router.navigateByUrl(redirect);
    }, (err) => {
      this.user.password = '';
      this.message = 'Usuario o contraseña no valido';
    });
  }

}
