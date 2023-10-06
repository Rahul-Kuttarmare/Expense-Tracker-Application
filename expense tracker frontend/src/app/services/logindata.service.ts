import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class LogindataService {

  url: string = environment.apiUrl + "/api/v1/agency"
  url2: string = environment.apiUrl + "/api/v2/member"
  url3: string = environment.apiUrl + "/api/v3/record"
  url4: string = environment.apiUrl + "/api/summary/credit/"
  url5: string = environment.apiUrl + "/api/summary/deposit/"
  url6: string = environment.apiUrl + "/auth/login"
  url7: string = environment.apiUrl + "/auth/adduser"
  url8: string = environment.apiUrl + "/login"
  // url9: string = environment.apiUrl + "/ap"

  constructor(private http: HttpClient) { }

  createAuthorizationHeader(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  // add new user
  addUserData(data: Object) {
    return this.http.post(this.url7, data)
  }

 headers = new HttpHeaders().set('Authorization', 'Bearer ' + sessionStorage.getItem("accessToken"));


  // login user with username and password
  getSecuredData(data: any) {
    let userName = data.userName
    let password = data.password
    let credentials = { userName, password }

    // console.log(credentials)
    console.log(data)
    return this.http.post(this.url6,data)
  }

  // for fetching agency data for dropdown
  agencyData() {
    return this.http.get(this.url);
  }

  // for gettng agency data by userid
  getAgencyData(id: number) {
    return this.http.get(`${this.url}/${id}`);
  }

  // for adding new agency
  addAgency(data: object): Observable<object> {
    return this.http.post(`${this.url}`, data);
  }

  // for adding new memeber
  addMember(data: object) {
    return this.http.post(this.url2, data,{'headers':this.headers});
  }

  // for fetching member data for dropdown
  getMemberData(id: number) {
    return this.http.get(`${this.url2}/${id}`,{'headers':this.headers});
  }

  // for adding new Record
  addNewRecord(data: object) {
    return this.http.post(this.url3, data,{'headers':this.headers});
  }

  // for getting all records with agencyId
  getAllRecords(agencyId: number) {
    return this.http.get(`${this.url3}/${agencyId}`,{'headers':this.headers})
  }

  // for getting total credit amount of specific agency
  getTotalCredit(agencyId: number) {
    console.log("agency Id : ", agencyId)
    return this.http.get(`${this.url4}${agencyId}`,{'headers':this.headers})
  }

  // for getting total deposit amout of specic agency
  getTotalDeposit(agencyId: number) {
    return this.http.get(`${this.url5}${agencyId}`,{'headers':this.headers})
  }

  getTotalCreditByMemberId(memberId: number, id: number) {
    return this.http.get(`${this.url4}${memberId}/${id}`,{'headers':this.headers})
  }

  getTotalDepositByMemberId(memberId: number, id: number) {
    return this.http.get(`${this.url5}${memberId}/${id}`,{'headers':this.headers})
  }

  getAllRecordsByMebmerId(id: number, memberId: number) {
    return this.http.get(`${this.url3}/${id}/${memberId}`,{'headers':this.headers})
  }
}
