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

  constructor(private authService: AuthService, private router: Router, private spinner: NgxSpinnerService) {

  }

  ngOnInit() {
    this.authService.isUserLoggedIn().subscribe(isin => {
      console.log(isin)
      this.isLoggedIn = isin;
    });
    this.authService.userProfile().subscribe(prof => {
      this.profile = prof;
    });
  }

  showSpinner() {
    this.spinner.show();
    setTimeout(() => {
      this.spinner.hide();
    }, 3000)
  }

  handleLogout() {
    this.showSpinner();
    this.authService.logOut();
    this.router.navigate(['/logout']);
  }

}
