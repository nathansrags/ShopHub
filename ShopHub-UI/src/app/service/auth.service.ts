import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiResponse } from '../model/ApiResponse';
import { BehaviorSubject, Observable } from 'rxjs';
import { Customer } from '../model/user.model';
import { auth_server } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }
  apiResponse !: ApiResponse;

  private _loginSuccess$ = new BehaviorSubject<boolean>(false);
  private _loginUserName$ = new BehaviorSubject<string>('');
  private _loginUserId$ = new BehaviorSubject<number>(0);
  profile = new Customer;
  private _loginProfile$ = new BehaviorSubject<Customer>(this.profile);

  USER_NAME_SESSION_ATTRIBUTE = 'authenticatedUser'
  public get loginSuccess(): Observable<boolean> {
    return this._loginSuccess$;
  }

  public userProfile(): Observable<Customer> {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE);
    if (user != null) {
      let p: Customer = JSON.parse(user);
      this._loginProfile$.next(p);
    }
    return this._loginProfile$;
  }

  public registrationSuccessfullLogin(profile: Customer) {
    console.log(profile);
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE, JSON.stringify(profile));
  }

  logOut() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE);
  }

  isUserLoggedIn(): Observable<boolean> {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE);
    this._loginSuccess$.next(user == null);
    return this._loginSuccess$;
  }

  public getLoggedInUserName(): Observable<string> {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE);
    if (user != null) {
      let p: Customer = JSON.parse(user);
      this._loginUserName$.next(p.firstName + '' + p.lastName);
    }
    return this._loginUserName$;
  }

  public loggedInUserId(): Observable<number> {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE);
    if (user != null) {
      let p: Customer = JSON.parse(user);
      this._loginUserId$.next(Number(p.customerId));
    }
    return this._loginUserId$;
  }

  public getLoginCred(){
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE);
    let cred !: string;
    if (user != null) {
      let p: Customer = JSON.parse(user);
      cred = p.password;
    }
    return cred;
  }

  setLoginSuccess(val: boolean) {
    this._loginSuccess$.next(val);
  }

  setUserProfile(profile: Customer) {
    this._loginProfile$.next(profile);
  }

  setUserId(profile: Customer) {
    if (profile != null) {
      this._loginUserId$.next(Number(profile.customerId));
    }
  }

  private _loginServer = auth_server.url + '/login';

  public login(creds : Customer){
    this._loginSuccess$.next(false);
    return this.httpClient.post<ApiResponse>(this._loginServer, creds);
  }



}
