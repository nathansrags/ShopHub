import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Injectable()
export class Authinterceptor implements HttpInterceptor {

  constructor(private authService: AuthService, private router: Router) { }


  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.authService.isUserLoggedIn() && request.url.indexOf('basicauth') === -1) {
      const authReq = request.clone({
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Basic ${window.btoa(this.authService.getLoggedInUserName() + ":"
            + this.authService.getLoginCred())}`
        })
      });
      return next.handle(authReq);
    } else
      return next.handle(request);
  }
}
