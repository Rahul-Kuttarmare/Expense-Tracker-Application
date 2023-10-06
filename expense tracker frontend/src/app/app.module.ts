import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { AddagencyComponent } from './addagency/addagency.component';
import { AgencymainpageComponent } from './agencymainpage/agencymainpage.component';
import { AddrecordComponent } from './addrecord/addrecord.component';
import { AddmemberComponent } from './addmember/addmember.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { AdduserComponent } from './adduser/adduser.component'; '@angular/common/HttpClient';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddagencyComponent,
    AgencymainpageComponent,
    AddrecordComponent,
    AddmemberComponent,
    LoginpageComponent,
    AdduserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSelectModule,
    NoopAnimationsModule,
    HttpClientModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
