import { Component, OnInit } from '@angular/core';
import { LogindataService } from '../services/logindata.service';
import { __values } from 'tslib';
import { ResolveStart, Router } from '@angular/router';

@Component({
  selector: 'app-agencymainpage',
  templateUrl: './agencymainpage.component.html',
  styleUrls: ['./agencymainpage.component.css']
})
export class AgencymainpageComponent implements OnInit {
  data: any
  id1 = sessionStorage.getItem("id");
  id: any = this.id1

  role: any = sessionStorage.getItem("role");
  userName: any = sessionStorage.getItem("userName")
  // str:any = parseInt(sessionStorage.getItem("memberId"))
  // memberId: any = this.str
  res: any = sessionStorage.getItem("memberId")
  memberId: any = parseInt(this.res)
  depositAmount: any
  creditAmount: any
  a: number = 0;
  b: number = 0;

  memberData: any;

  logout() {
    sessionStorage.removeItem("memberId")
    sessionStorage.removeItem("userName")
    sessionStorage.removeItem("role")
    sessionStorage.removeItem("accessToken")
    this.router.navigate(["/"])
  }

  constructor(private agencyData: LogindataService, private router: Router) {}
  ngOnInit(): void {

    if (this.role === "ROLE_ADMIN") {
      // get agency data by agencyId
      this.agencyData.getAgencyData(this.id).subscribe(data => {
        console.log(data);
        this.data = data;
      })

      //get total Credit amount by agencyId
      this.agencyData.getTotalCredit(this.id).subscribe(res => {
        this.creditAmount = res
        let { amount } = this.creditAmount
        this.a = amount
        console.log("credit amount : ", this.creditAmount)
      })

      //get total Deposit amount by depositId
      this.agencyData.getTotalDeposit(this.id).subscribe(res => {
        this.depositAmount = res
        let { amount } = this.depositAmount
        this.b = parseInt(amount);
        var c = this.b - this.a
        var s = String(c)
        sessionStorage.setItem("balance", s)
      })

      this.agencyData.getAllRecords(this.id).subscribe(res => {
        console.log("all members data : ", res)
        this.memberData = res
      })
    }
    else {
      this.agencyData.getAgencyData(this.id).subscribe(data => {
        console.log(data);
        this.data = data;
      })

      //get total Credit amount by memberId and agencyId
      this.agencyData.getTotalCreditByMemberId(this.memberId, this.id).subscribe(res => {
        this.creditAmount = res
        let { amount } = this.creditAmount
        this.a = amount
        console.log("credit amount : ", this.creditAmount)
      })

      //get total Deposit amount by depositId
      this.agencyData.getTotalDepositByMemberId(this.memberId, this.id).subscribe(res => {
        this.depositAmount = res
        let { amount } = this.depositAmount
        this.b = parseInt(amount);

      })

      this.agencyData.getAllRecordsByMebmerId(this.id, this.memberId).subscribe(res => {
        this.memberData = res
        console.log("all members data : ", this.memberData)
      })
    }
  }
}
