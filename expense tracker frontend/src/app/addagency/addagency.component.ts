import { Component, OnInit } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import {FormGroup,FormControl} from '@angular/forms'

import { Router } from '@angular/router';

@Component({
  selector: 'app-addagency',
  templateUrl: './addagency.component.html',
  styleUrls: ['./addagency.component.css']
})
export class AddagencyComponent implements OnInit {

addAgencyForm = new FormGroup({
  name: new FormControl(''),
  description: new FormControl('')
});

get name(){return this.addAgencyForm.get('name')}
get description(){return this.addAgencyForm.get('description')}

error:String = ""

  constructor(private agencyData:LogindataService,
    private router: Router){}

  ngOnInit() {}
  
  // data: {} = {};

  saveAgency(data: object){
    this.agencyData.addAgency(data).subscribe((res)=>{
      console.log(res)
      this.error = ""
      this.goToLoginAgency();
    },error=>{
      this.error = "agency with same name already exist"
    })
  }

  goToLoginAgency(){
    this.router.navigate(['/'])
  }
  
  // onSubmit(val: any) {
  //   this.data = val
  //   console.log(this.data)
  //   this.saveAgency(this.data);
  // }

  onSubmit(){
    // console.log(this.addAgencyForm.value )
    console.log(this.addAgencyForm.value)
    this.saveAgency(this.addAgencyForm.value)
  }
}
