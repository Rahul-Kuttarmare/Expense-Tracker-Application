import { Component, OnInit } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import { FormGroup, FormControl } from '@angular/forms'
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  users: any;
  // data:{} ={};

  loginForm = new FormGroup({
    id: new FormControl('')
  });

  constructor(private userdata: LogindataService, private router: Router) { }

  ngOnInit(): void {
    this.userdata.agencyData().subscribe((data) => {
      this.users = data
      console.log(data)
    })
  }

  // onSubmit(val: any){
  //   this.data = val;
  //   console.log("id",this.data)
  //   sessionStorage.setItem("id" , val.id )
  //   this.router.navigate(["agencymainpage"])
  // }

  onSubmit() {
    let id = Object.values(this.loginForm.value);
    let id1 = String(id[0])
    sessionStorage.setItem("id", id1)
    this.router.navigate(["loginpage"])
  }
}
