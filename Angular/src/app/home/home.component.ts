import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private loginservice:LoginService, private router:Router) { }

  ngOnInit(): void {
    let token = this.loginservice.getToken();
    //console.log("this is my token "+token);
  }
  logOutUser(){
    this.loginservice.logout();
    this.router.navigate(['/']);
  }
  
}
