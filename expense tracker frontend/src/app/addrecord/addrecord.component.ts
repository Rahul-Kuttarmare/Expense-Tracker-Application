import { Component, OnInit } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import { Router, Routes } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms'

// const routes: Routes = [
//   {
//     path:"addmember",
//     component:AddmemberComponent
//   }
// ]

@Component({
  selector: 'app-addrecord',
  templateUrl: './addrecord.component.html',
  styleUrls: ['./addrecord.component.css']
})
export class AddrecordComponent implements OnInit {


  addRecordForm = new FormGroup({
    memberId: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required, Validators.minLength(4)]),
    transactionType: new FormControl('', Validators.required),
    amount: new FormControl('', Validators.required)
  })

  get transactionType() { return this.addRecordForm.get('transactionType') }
  get description() { return this.addRecordForm.get('description') }
  get amount() { return this.addRecordForm.get('amount') }
  get memberId() { return this.addRecordForm.get('memberId') }

  // @Output() event= new EventEmitter<String>();
  id: any = sessionStorage.getItem("id");
  id1: number = parseInt(this.id)
  data2: Object = { agencyId: this.id1 }
  data: any;
  error: String = ""
  b: any = sessionStorage.getItem("balance");
  balance: number = parseInt(this.b)
  a: any = 0;

  constructor(private memberService: LogindataService, private router: Router) { }


  ngOnInit(): void {
    this.memberService.getMemberData(this.id).subscribe((res) => {
      this.data = res;
      console.log(res)
    })
  }

  addRecord(data: object) {
    this.memberService.addNewRecord(data).subscribe((res) => {
      console.log(res)
      this.error = ""
      this.changeRoute()

    }, error =>{
      console.log(error)
      this.error = error.error.message
    } )
  }

  onSubmit() {

    console.log(this.balance)

    Object.assign(this.data2, this.addRecordForm.value)
    this.a = this.addRecordForm.value.amount;
    console.log(this.data2)
        if(this.balance < this.a && this.addRecordForm.value.transactionType === "credit"){
      console.log("value must be less than ", this.balance)
      this.error = "value must be less than or equal to "+this.balance
      }
      else{
        this.error = ""
        this.addRecord(this.data2)
      } 
  }

  changeRoute() {
    console.log("change Route Method called")
    this.router.navigate(["agencymainpage"])
  }
}