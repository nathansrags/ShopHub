import { Injectable } from '@angular/core';
import { AbstractControl, FormGroup, ValidatorFn } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class Customvalidation {

  constructor() { }


  patternValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      if (!control.value) {
        return null;
      }
      const regex = new RegExp('^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$');
      const valid = regex.test(control.value);
      console.log(valid ? null : { invalidPassword: true });
      return valid ? null : { invalidPassword: true }
    };
  }

  emailValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      if (!control.value) {
        return null;
      }
      const regex = new RegExp('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$');
      const valid = regex.test(control.value);
      console.log(valid);
      return valid ? null : { invalidEmail: true }
    };
  }

  MatchPassword(p: string, c:string): ValidatorFn {
    return (controls: AbstractControl): { [key: string]: any } | null => {
      const passwordC = controls.get(p);
      const confirmpasswordC = controls.get(c);
      if (!passwordC?.value || !confirmpasswordC?.value) {
        return null;
      }
      console.log(passwordC.value);
      console.log(passwordC?.value === confirmpasswordC?.value ? null : { passwordMismatch: true })
      return passwordC?.value === confirmpasswordC?.value ? null : { passwordMismatch: true };
    }
  }

  // MatchPassword(password: string, cpassword: string) {
  //   console.log(password + " == " + cpassword);
  //   return (formGroup: FormGroup) => {
  //     const passwordControl = formGroup.controls[password];
  //     const confirmpasswordControl = formGroup.controls[cpassword];
  //     console.log(passwordControl.value + " == " + confirmpasswordControl.value);
  //     if (!passwordControl || !confirmpasswordControl) {
  //       return null;
  //     }
  //     if (!passwordControl.errors && !confirmpasswordControl.errors?.['passwordMismatch']) {
  //       return null;
  //     }

  //     if (!passwordControl.value != confirmpasswordControl.value) {
  //       confirmpasswordControl.setErrors({ passwordMismatch: true });
  //       return null;
  //     } else {
  //       confirmpasswordControl.setErrors(null);
  //       return;
  //     }
  //   }
  // }

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
