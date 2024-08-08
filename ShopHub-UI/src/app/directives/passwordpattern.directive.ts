import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS } from '@angular/forms';
import { CustomvalidationService } from '../service/customvalidation.service';

@Directive({
  selector: '[appPasswordPattern]',
  providers: [{provide: NG_VALIDATORS, useExisting:PasswordpatternDirective, multi:true}]
})
export class PasswordpatternDirective {

  constructor(private service:CustomvalidationService) { }

  validate(control:AbstractControl): {[key:string]: any} | null{
    return this.service.patternValidator()(control);
  }

}
