import { Component, OnInit } from '@angular/core';
import { LoginForm } from '../login.component';
import { MatchPasswordDirective } from 'src/app/directives/matchpassword.directive';

@Component({
  selector: 'app-recovery',
  templateUrl: './recovery.component.html',
  styleUrls: ['./recovery.component.css']
})
export class RecoveryComponent implements OnInit {

  constructor() { }
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

}

export class RecoveryForm {
  email: string ='';
  password: string= '';
  confirmpassword: string= '';
}
