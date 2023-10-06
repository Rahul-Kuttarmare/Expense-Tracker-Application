import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AddagencyComponent } from './addagency/addagency.component';
import { AgencymainpageComponent } from './agencymainpage/agencymainpage.component';
import { AddrecordComponent } from './addrecord/addrecord.component';
import { AddmemberComponent } from './addmember/addmember.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { AdduserComponent } from './adduser/adduser.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }, {
    path: 'loginpage',
    component: LoginpageComponent
  }, {
    path: 'adduser',
    component: AdduserComponent
  },
  {
    path: 'addagency',
    component: AddagencyComponent
  },
  {
    path: 'agencymainpage',
    component: AgencymainpageComponent
  },
  {
    path: 'addrecord',
    component: AddrecordComponent
  },
  {
    path: 'addmember',
    component: AddmemberComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
