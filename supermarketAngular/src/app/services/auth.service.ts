import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private URL = 'http://localhost:8080/auth';
  constructor(private _http: HttpClient, private router: Router) {}
  signUpUser(user: any) {
    return this._http.post<any>(this.URL + '/login', user);
  }

  signInUser(user: User) {
    return this._http.post<any>(this.URL + '/signin', user);
  }

  loggedIn() {
    return !!localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/tasks']);
  }

  getToken() {
    return localStorage.getItem('token');
  }
}
