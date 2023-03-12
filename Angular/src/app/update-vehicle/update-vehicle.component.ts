import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VehicleService } from '../service/vehicle.service';
import { Vehicles } from '../vehicles';

@Component({
  selector: 'app-update-vehicle',
  templateUrl: './update-vehicle.component.html',
  styleUrls: ['./update-vehicle.component.css']
})
export class UpdateVehicleComponent implements OnInit {
  

    vehicles!:any;
    regNo:any;
  constructor(private vehicleService:VehicleService, private router: Router, private acRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.regNo= this.acRoute.snapshot.params['registrationNo'];
    this.vehicleService.selectByRegNo(this.regNo).subscribe(data=>{
      this.vehicles=data;
      console.log(this.vehicles);
      
    });

  }
  updateMessage:boolean=false;
  updateVehicle(){
    
    
    this.vehicleService.updateVehicle(this.vehicles, this.regNo).subscribe(data=>{
      console.log(this.vehicles);
      
      console.log("updated");
      
      this.updateMessage=true;
      
      
    })
  }
  back(){
    this.goToVehicleList();
    
  }

  goToVehicleList(){
    this.router.navigate(['/vehiclelist']);
  }


}