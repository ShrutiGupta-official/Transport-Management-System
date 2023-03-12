import { Component, OnInit } from '@angular/core';
import { DriverService } from '../service/driver.service';

@Component({
  selector: 'app-get-driver-by-vehicletype',
  templateUrl: './get-driver-by-vehicletype.component.html',
  styleUrls: ['./get-driver-by-vehicletype.component.css']
})
export class GetDriverByVehicletypeComponent implements OnInit {

  getdriverbytype!:any;
  driverbytype:any;
  noDataDisplay!:boolean;
  hideDiv!:any;

  constructor(private driverService:DriverService) { }
  ngOnInit(): void {
     this.hideDiv=true;
     this.noDataDisplay=true;
  }

  selectDriverType(){
    this.hideDiv=false;
    this.noDataDisplay=true;
    this.driverService.selectDriverType(this.getdriverbytype).subscribe(
      (data)=>{
        this.driverbytype=data; 
        console.log(this.driverbytype)
        if(this.driverbytype==''|| this.driverbytype==null){
          this.noDataDisplay = false;
          this.hideDiv=true;
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
