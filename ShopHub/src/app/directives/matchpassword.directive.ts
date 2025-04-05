import { Directive, Input } from '@angular/core';
import { Customvalidation } from '../service/customvalidation.service';
import { AbstractControl, FormGroup, NG_VALIDATORS, ValidationErrors } from '@angular/forms';

@Directive({
  selector: '[appMatchPassword]',
  providers: [{ provide: NG_VALIDATORS, useExisting: MatchPasswordDirective, multi: true }]
})
export class MatchPasswordDirective {

  @Input('appMatchPassword') MatchPassword: string[] = [];

  constructor(private customValidator: Customvalidation) { }

  validate(control:AbstractControl): ValidationErrors | null | undefined {    
    return this.customValidator.MatchPassword(this.MatchPassword[0], this.MatchPassword[1])(control);
  }

}
