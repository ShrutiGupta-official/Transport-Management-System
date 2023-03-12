import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../service/vehicle.service';


@Component({
  selector: 'app-get-vehicle-by-type',
  templateUrl: './get-vehicle-by-type.component.html',
  styleUrls: ['./get-vehicle-by-type.component.css']
})
export class GetVehicleByTypeComponent implements OnInit {

  getvehiclebytype!:string;
  vehiclebytype:any;
  noDataDisplay!:boolean;
  hideDiv!:boolean;
  constructor(private vehicleService:VehicleService) { }
  ngOnInit(): void {
     this.hideDiv=true;
     this.noDataDisplay=true;
  }

  selectVehicleType(){
    this.hideDiv=false;
    this.vehicleService.selectVehicleType(this.getvehiclebytype).subscribe(
      (data)=>{
        this.vehiclebytype=data; 
        console.log(this.vehiclebytype)
        if(this.vehiclebytype==''|| this.vehiclebytype==null){
          this.hideDiv=true;
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
