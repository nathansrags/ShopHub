import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ApiResponse } from '../model/ApiResponse';
import { Customer } from '../model/user.model';
import { auth_server } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private _registrationServer = auth_server.url + '/signup';
  private _passreset = auth_server.url + 'resetpassword';

  constructor(private http: HttpClient) { }

  private _errorMessage:BehaviorSubject<string> = new BehaviorSubject<string>("");
  public readonly errMessage$ : Observable<string> = this._errorMessage.asObservable();

  private _successMessage:BehaviorSubject<string> = new BehaviorSubject<string>("");
  public readonly successMessage$ : Observable<string> = this._successMessage.asObservable();

  setError(message:string){
    this._errorMessage.next(message);
  }

  setSuccessMessage(message:string){
    this._successMessage.next(message);
  }

  public async registerUser(user: Customer){
    console.log(user);
    return this.http.post<ApiResponse>(`${this._registrationServer}`,user);
  }

  public async registerPassword(user: Customer){
    console.log(user);
    return this.http.post<ApiResponse>(`${this._passreset}`,user);
  }
}
