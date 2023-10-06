import { Component } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import { FormGroup, FormControl } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent {
  addMemberForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl(''),
    address: new FormControl(''),
    age: new FormControl('')
  })

  get userName() { return this.addMemberForm.get('userName') }
  get password() { return this.addMemberForm.get('password') }
  get role() { return this.addMemberForm.get('role') }
  get address() { return this.addMemberForm.get('address') }
  get age() { return this.addMemberForm.get('age') }


  error: String = ""

  agencyId: any = sessionStorage.getItem("id");
  data: {} = { agencyId: this.agencyId };

  constructor(private memberService: LogindataService, private router: Router) { }

  addUser(data: Object) {
    console.log(data)
    this.memberService.addUserData(data).subscribe((res) => {
      console.log(res)
      this.error = ""
      this.changeRoute()
    },error=>{
      console.log(error)
      this.error = error.error.message
    })
  }

  onSubmit() {
    // console.log(this.addMemberForm.value)
    Object.assign(this.data,this.addMemberForm.value )
    this.addUser(this.data);
  }

  changeRoute() {
    this.router.navigate(["loginpage"])
  }

}
