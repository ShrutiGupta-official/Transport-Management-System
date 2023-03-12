import { Component, OnInit } from '@angular/core';
import { Drivers } from '../drivers';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
import { DriverService } from '../service/driver.service';



@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.css']
})
export class DriverListComponent implements OnInit {
  drivers:any;
  
  constructor(private driverService:DriverService, private router: Router) { }

  ngOnInit(): void {
    
    this.driverService.getAllDrivers().subscribe(
      (data)=>{
        this.drivers=data;
      }
    );
}
deleteMessage:boolean=false ;
deleteDriver(Driver: { licensenumber: number; },licensenumber:number){

  this.driverService.deleteDriver(Driver.licensenumber).subscribe(
    (resp)=>{
      console.log(resp);
      this.deleteMessage=true;
      this.ngOnInit();
      // window.location.reload();
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
  // this.router.navigate(['/driverlist']);
  //window.location.reload();
}


}