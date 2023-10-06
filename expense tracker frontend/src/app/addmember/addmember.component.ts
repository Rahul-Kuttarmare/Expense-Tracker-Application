import { Component } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import {FormGroup,FormControl} from '@angular/forms';

import { Router } from '@angular/router';

@Component({
  selector: 'app-addmember',
  templateUrl: './addmember.component.html',
  styleUrls: ['./addmember.component.css']
})
export class AddmemberComponent {

  addMemberForm = new FormGroup({
    userName: new FormControl(''),
    address: new FormControl(''),
    age: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl('')
  })

  get userName(){ return this.addMemberForm.get('userName')}
  get address(){ return this.addMemberForm.get('address')}
  get age(){ return this.addMemberForm.get('age')}
  get password(){ return this.addMemberForm.get('password')}
  get role(){ return this.addMemberForm.get('role')}


  error:String = ""
  
  agencyId: any = sessionStorage.getItem("id");
  data:{} = {agencyId : this.agencyId};

  constructor(private memberService:LogindataService, private router: Router){}

  addMember(data: object){
    this.memberService.addMember(data).subscribe((res)=>{
      console.log(res)
      this.error = ""
      this.changeRoute()
    },error=>{
      this.error = error.error.message
    })
  }

  // onSubmit(value: any){
  //   if(value.memberName == "" || value.address == "" || value.age == ""){
  //     if(value.memberName == ""){
  //       var ele = document.getElementsByClassName("memberName");
  //       // var list = ele.ClassList
  //       this.error = "member Name is mandatory"
  //     }
  //     if(value.address = ""){
  //       this.error = "Address is mandatory"
  //     }
  //     if(value.age == ""){
  //       this.error = "age is mandatory"
  //     }
  //     return;
  //   }
  //   console.log(value.name)
  //   Object.assign(this.data,value)
  //   console.log(this.data)
  //   this.addMember(this.data);
  // }

  onSubmit(){
    console.log(this.addMemberForm.value)
    Object.assign(this.data,this.addMemberForm.value)
    console.log(this.data)
    this.addMember(this.data);
  }

  changeRoute(){
    this.router.navigate(["addrecord"])
  }

}
