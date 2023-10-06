import { Component } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import { FormGroup, FormControl } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent {
  addMemberForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl('')

  })

  get userName() { return this.addMemberForm.get('userName') }
  get password() { return this.addMemberForm.get('password') }
  get role() { return this.addMemberForm.get('role') }




  error: String = ""

  agencyId: any = sessionStorage.getItem("id");
  data: any = { agencyId: this.agencyId };


  constructor(private memberService: LogindataService, private router: Router) { }

  addMember(send: any) {
    console.log(send)
    this.memberService.getSecuredData(send).subscribe((res: any) => {
      console.log(res)
      sessionStorage.setItem("accessToken", res.accessToken)
      sessionStorage.setItem("memberId", res.userName)
      this.error = ""
      this.changeRoute()
    }, error => {
      console.log(error.error.message)
      this.error = error.error.message
    })
  }

  onSubmit() {
    // console.log(this.addMemberForm.value)

    Object.assign(this.data, this.addMemberForm.value)
    // console.log(this.data)
    this.addMember(this.data);
  }

  changeRoute() {
    sessionStorage.setItem("role", this.data.role)
    sessionStorage.setItem("userName", this.data.userName)
    this.router.navigate(["agencymainpage"])
  }

}
