import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ShopHub-ui';
  dashboardScreen = 'ShopHub'
  isLoggedIn: boolean =false;

  constructor(private router:Router, private authService: AuthService){

  }

  handleLogout(){
    this.authService.logOut();
  }
}
