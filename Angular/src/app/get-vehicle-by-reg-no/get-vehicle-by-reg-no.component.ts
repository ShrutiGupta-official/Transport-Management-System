import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../service/vehicle.service';

@Component({
  selector: 'app-get-vehicle-by-reg-no',
  templateUrl: './get-vehicle-by-reg-no.component.html',
  styleUrls: ['./get-vehicle-by-reg-no.component.css']
})
export class GetVehicleByRegNoComponent implements OnInit {
  getvehiclebyno!:string;
  vehiclebyno:any;
  noDataDisplay!:boolean;
  hideDiv!:boolean;
  constructor(private vehicleService:VehicleService) { }
  ngOnInit(): void {
     this.hideDiv=true;
     this.noDataDisplay=true;
  }
  selectByRegNo(){
    this.hideDiv=false;
    this.vehicleService.selectByRegNo(this.getvehiclebyno).subscribe(
      (data)=>{
        this.vehiclebyno=data; 
        console.log(this.vehiclebyno)
        if(this.vehiclebyno==''|| this.vehiclebyno==null){
          this.hideDiv =true;
          this.noDataDisplay = false;
        }
      },
      error=>{
        this.hideDiv=true;
        console.log("Data Not Found");
        this.noDataDisplay = false;
      }
    );
  }
  

}