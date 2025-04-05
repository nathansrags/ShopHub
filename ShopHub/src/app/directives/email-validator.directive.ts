import { Directive } from '@angular/core';
import { Customvalidation } from '../service/customvalidation.service';
import { AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[appEmailValidator]',
  providers: [{ provide: NG_VALIDATORS, useExisting: EmailValidatorDirective, multi: true }]
})
export class EmailValidatorDirective {

  constructor(private service: Customvalidation) { }

  validate(control: AbstractControl): { [key: string]: any } | null {
    return this.service.emailValidator()(control);
  }

}
