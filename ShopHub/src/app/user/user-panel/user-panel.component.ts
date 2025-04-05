import { Component, Input } from '@angular/core';
import { Customer } from '../../model/user.model';
import { AuthService } from '../../service/auth.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../../material/material.module';

@Component({
  selector: 'app-user-panel',
  standalone: true,
  imports: [RouterModule, CommonModule, MaterialModule],
  templateUrl: './user-panel.component.html',
  styleUrl: './user-panel.component.css'
})
export class UserPanelComponent {

  @Input() username!: string;
  @Input() cartTotal!: number;
  isLoggedIn: boolean = false;
  profile !: Customer;  

  constructor(private authService: AuthService, private router: Router, private spin: NgxSpinnerService) {
    
    this.authService.isUserLoggedIn().subscribe(isin => {
      console.log(isin)
      this.isLoggedIn = isin;
    });
    this.authService.userProfile().subscribe(prof => {
      this.profile = prof;
    });
  }

  ngOnInit() {
    this.authService.getLoggedInName.subscribe(name => {
      console.log(name);
      this.isLoggedIn =true;
      this.username = name;      

    });
    this.authService.isUserLoggedIn().subscribe(isin => {
      console.log(isin)
      this.isLoggedIn = isin;
    });
    
  }
  

  handleLogout() {    
    this.isLoggedIn =false;
    this.authService.logOut();
    this.router.navigate(['/logout']);
  }

}
