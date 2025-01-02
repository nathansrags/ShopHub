import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { AuthService } from './service/auth.service';
import { CommonModule } from '@angular/common';
import { AdminMenuComponent } from "./admin/admin-menu/admin-menu.component";
import { UserPanelComponent } from "./user/user-panel/user-panel.component";
import { MaterialModule } from './material/material.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, AdminMenuComponent, UserPanelComponent, MaterialModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ShopHub';
  dashboardScreen = 'ShopHub'
  isLoggedIn: boolean =false;
  cartTotal !:number;
  loggedInUsername !:string;

  constructor(private router:Router, private authService: AuthService){
    this.authService.getLoggedInName.subscribe(name => this.changeName(name));
  }

  private changeName(name: string): void {
      this.loggedInUsername = name;  
  }

  onSearch(){}

  handleLogout(){
    this.authService.logOut();
  }
}
