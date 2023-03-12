import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicles } from '../vehicles';
import { VehicleService } from '../service/vehicle.service';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

  vehicle_registrationNo : string = '';
  vehicle_modelType : string = '';
  vehicle_vehicleType : string = '';
  vehicle_numberOfSeat : string = '';
  vehicle_acAvailable: string = '';


  addtovehiclelist = new Vehicles();
  constructor(private service:VehicleService,  private _route: Router) { }

  
  ngOnInit(): void {
  }
  addMessage:boolean=false;
  addVehicle(){
    this.service.addVehicleToList(this.addtovehiclelist).subscribe
    (
      data=>{
        console.log("Vehicle added succcessfully");
        this.addMessage=true;
        
      },
      error=>{
        console.log("Vehicle not added");
      }
    )
  }
  back(){
    this._route.navigate(['/vehiclelist']);
  }

  
}
