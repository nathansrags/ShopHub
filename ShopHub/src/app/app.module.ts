import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { NgxSpinnerModule } from 'ngx-spinner';
import { HTTP_INTERCEPTORS, HttpClient, HttpClientModule, provideHttpClient } from '@angular/common/http';


import { MatchPasswordDirective } from './directives/matchpassword.directive';
import { PasswordpatternDirective } from './directives/passwordpattern.directive';
import { Authinterceptor } from './interceptors/authinterceptor.interceptor';
import { AuthGuard } from './interceptors/authguard.interceptor';
import { MaterialModule } from './material/material.module';
import { AppRoutingModule } from './app.routes';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DirectiveModule } from './directive.module';

@NgModule({
  declarations: [   
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule,
    CommonModule, // add here if necessasry
    RouterLinkActive,// add here if necessasry
    RouterOutlet, // add here if necessasry
    RouterLink,// add here if necessasry
    AppRoutingModule,
    AppRoutingModule, NgxSpinnerModule,
    FormsModule,  MaterialModule, DirectiveModule
  ],
  exports: [],
  providers: [Title, provideHttpClient(), AuthGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: Authinterceptor,
    multi: true
  }],
  bootstrap: []
})
export class AppModule { }
