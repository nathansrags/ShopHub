import { Component, OnInit } from '@angular/core';
import { FormGroup, FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { NgxSpinnerService } from 'ngx-spinner';
import { RegistrationService } from '../service/registration.service';
import { Customer } from '../model/user.model';
import { ApiResponse } from '../model/ApiResponse';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone:true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService, private spin: NgxSpinnerService,
    private regService: RegistrationService
  ) { }

  loginForm!: FormGroup;
  form = new LoginForm();
  isLoggedIn!: Observable<boolean>;
  loginMessage!: string;
  errorMessage!: string;
  show: boolean = false;
  profile!: Customer ;
  apiResponse !: ApiResponse;

  ngOnInit(): void {    
    this.authService.logOut();
    this.regService.successMessage$.subscribe(val => {
      this.loginMessage = val;
    });
    this.regService.errMessage$.subscribe(val => {
      this.errorMessage = val;
    })
    this.spin.hide();
    console.log('In Login Component')
  }

  register() {
    this.router.navigate(['/register']);
  }

  togglePassword() {
    this.show = !this.show;
  }

  onSubmit() {    
    this.profile = new Customer();
    this.profile.email = this.form.email;
    this.profile.password = this.form.password;
    return this.authenticate(this.profile);
  }

  ngOnDestroy() {
    this.loginMessage = '';
    this.errorMessage = '';
  }

  clearMessages(){
    this.ngOnDestroy();
  }

  authenticate(profile: Customer) {
    this.spin.show();
    let isAuthenticated = false;    
    this.authService.login(this.profile).subscribe(response => {
      console.log(response);
      this.apiResponse = response;
      this.profile = response.data as Customer;
      if (this.apiResponse.statusCode == "OK") {
        this.authService.registrationSuccessfullLogin(this.profile);
        this.authService.setUserProfile(this.apiResponse.data as Customer);
        this.authService.setUserId(this.apiResponse.data as Customer);        
        isAuthenticated = true;
        this.router.navigate(['/home']);
      } else {        
        this.spin.hide();
        this.authService.logOut();
        this.errorMessage = this.apiResponse.message;
      }
    }, (error) => {
      this.spin.hide();
      console.log(error);
      this.authService.logOut();
      this.errorMessage = 'Something went wrong'
    }
    );
    return isAuthenticated;
  }

}

export class LoginForm {
  email: string = "nathan@email.com";
  password: string = "Chennai@123";
}
