import { Component } from '@angular/core';
import {LogindataService} from './services/logindata.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'frontendAngular';

  constructor( private router: Router) {}

  changeRoute(){
    this.router.navigate(["addmember"])
  }
}
