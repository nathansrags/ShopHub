import { NgModule } from "@angular/core";
import { MatchPasswordDirective } from "./directives/matchpassword.directive";
import { PasswordpatternDirective } from "./directives/passwordpattern.directive";
import { EmailValidatorDirective } from "./directives/email-validator.directive";

@NgModule({
    declarations: [
        MatchPasswordDirective, PasswordpatternDirective, EmailValidatorDirective
    ],    
    exports: [MatchPasswordDirective, PasswordpatternDirective, EmailValidatorDirective]

})
export class DirectiveModule { }