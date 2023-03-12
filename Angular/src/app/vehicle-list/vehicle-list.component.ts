import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Vehicles } from '../vehicles';
import {ActivatedRoute, Router } from '@angular/router';
import { VehicleService } from '../service/vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {
  vehicles:any;
  vehicle:any;

  //vehicleToUpdate = new Vehicles();
  uptovehiclelist = {
    registrationNo : " ",
    modelType : " ",
    vehicleType : " ",
    numberOfSeat : " ",
    acAvailable: " ",
  }

  constructor(private vehicleService:VehicleService, private router: Router) { }

  ngOnInit(): void {
    this.vehicleService.getAllVehicles().subscribe(
      (data)=>{
        this.vehicles=data;
      }
    );
    
  }
  deleteMessage:boolean=false ;
  deleteVehicle(Vehicle: { registrationNo: string; },registrationNo:number){
    this.vehicleService.deleteVehicle(Vehicle.registrationNo).subscribe(
      (resp)=>{
        console.log(resp);
        this.deleteMessage=true;
        this.ngOnInit();
        
      },
      error=>{
        console.log(error);
        this.ngOnInit();
      }     
    );
  }
  removeMessage(){
    this.deleteMessage= false;
    this.ngOnInit();
    // this.router.navigate(['/vehiclelist']);
  //window.location.reload();
  }

  
  
  updateVehicle(registrationNo:string){
    console.log(registrationNo);
    
    this.router.navigate(['/updatevehicle', registrationNo]);
    }

   
}



