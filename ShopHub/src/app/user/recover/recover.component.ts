import { CommonModule, Location } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DirectiveModule } from '../../directive.module';
import { NgxSpinnerService } from 'ngx-spinner';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-recover',
  standalone: true,
  imports: [FormsModule, CommonModule, DirectiveModule, RouterModule],
  templateUrl: './recover.component.html',
  styleUrl: './recover.component.css'
})
export class RecoverComponent {
  constructor(private spinner: NgxSpinnerService,private _location:Location, private router: Router) { }
  successMessage!: string;
  errorMessage!: string;
  form= new  RecoveryForm();
  show: boolean = false;
  showC: boolean = false;  
  ngOnInit(): void {
  }

  onSubmit() { }


  togglePassword(filed: string) {
    if (filed === 'pass') {
      this.show = !this.show;
    } else if (filed === 'cpass') {
      this.showC = !this.showC;
    }
  }

  goBack(){
    this.errorMessage = '';
    this._location.back();
  }

}

export class RecoveryForm {
  email: string ='';
  password: string= '';
  confirmpassword: string= '';
}

