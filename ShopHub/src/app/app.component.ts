import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { AuthService } from './service/auth.service';
import { CommonModule } from '@angular/common';
import { AdminMenuComponent } from "./admin/admin-menu/admin-menu.component";
import { UserPanelComponent } from "./user/user-panel/user-panel.component";
import { MaterialModule } from './material/material.module';
import { NgxSpinnerModule } from 'ngx-spinner';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, AdminMenuComponent, UserPanelComponent, MaterialModule,NgxSpinnerModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ShopHub';
  dashboardScreen = 'ShopHub'
  isLoggedIn: boolean =false;
  loggedInUsername!:string;
  cartTotal !:number;
  

  constructor(private router:Router, private authService: AuthService){
    this.authService.isUserLoggedIn().subscribe(loggedIn => {
      this.isLoggedIn = loggedIn;
    })
    this.authService.getLoggedInUserName().subscribe(name => {
      this.loggedInUsername = name
    })
  }
  
  onSearch(){}

}
