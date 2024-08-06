import { NgModule } from '@angular/core';
import { BrowserModule, Title } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MaterialModule } from 'src/material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthGuard } from './interceptors/authguard.interceptor';
import { Authinterceptor } from './interceptors/authinterceptor.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule, 
    AppRoutingModule,
    FormsModule, HttpClientModule, MaterialModule
  ],
  providers: [Title, HttpClientModule, AuthGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: Authinterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
