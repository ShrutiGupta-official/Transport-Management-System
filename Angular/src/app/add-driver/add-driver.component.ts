import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Drivers } from '../drivers';
import { DriverService } from '../service/driver.service';

@Component({
  selector: 'app-add-driver',
  templateUrl: './add-driver.component.html',
  styleUrls: ['./add-driver.component.css']
})
export class AddDriverComponent implements OnInit {

  drivers_licensenumber : string = '';
  drivers_name : string = '';
  drivers_age: string = '';
  drivers_vehicletype: string = '';



  addtodriverlist = new Drivers();
  constructor(private service:DriverService,  private _route: Router) { }

  ngOnInit(): void {
  }
  addMessage:boolean=false;
  addDriver(){
    this.service.addDriverToList(this.addtodriverlist).subscribe
    (
      data=>{
        console.log("Driver added succcessfully");
        this.addMessage=true;
        
      },
      error=>{
        console.log("Driver not added");
      }
    )
  }
  back(){
    this._route.navigate(['/driverlist']);
  }
 
}
