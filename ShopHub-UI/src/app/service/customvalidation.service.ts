import { Injectable } from '@angular/core';
import { AbstractControl, FormGroup, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CustomvalidationService {

  constructor() { }

  patternValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      if (!control.value) {
        return null;
      }
      const regex = new RegExp('^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$');
      const valid = regex.test(control.value);
      return valid ? null : { invalidPassword: true }
    };
  }

  MatchPassword(password: string, cpassword: string) {
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[password];
      const confirmpasswordControl = formGroup.controls[cpassword];

      if (!passwordControl || !confirmpasswordControl) {
        return null;
      }
      if (!passwordControl.errors && !confirmpasswordControl.errors?.['passwordMismatch']) {
        return null;
      }
      if (!passwordControl.value != confirmpasswordControl.value) {
        confirmpasswordControl.setErrors({ passwordMismatch: true });
        return null;
      } else {
        confirmpasswordControl.setErrors(null);
        return;
      }
    }
  }

  userNameValidator(userControl: AbstractControl) {
    return new Promise(resolve => {
      setTimeout(() => {
        if (this.validateUserName(userControl.value)) {
          resolve({ userNameNotAvailable: true });
        } else {
          resolve(null);
        }
      }, 1000)
    })
  }

  validateUserName(userName: string) {
    const userList = ['Gopi']
    return (userList.indexOf(userName) > -1);
  }
}
