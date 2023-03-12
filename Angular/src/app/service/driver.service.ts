import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Drivers } from '../drivers';

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  driver: any;

  constructor(private http: HttpClient) {}
    getAllDrivers() {

    return this.http.get("http://localhost:8088/Drivers");
  }
  public addDriverToList(addDriverList: Drivers) {
    console.log("addDriverList="+addDriverList);
    return this.http.post<any>("http://localhost:8088/AddDriver", addDriverList);
  }
  public selectDriverType(selectDriverType:string){
    return this.http.get("http://localhost:8088/DriversByVehicleType/" + selectDriverType)
  }
  public deleteDriver(licensenumber : number) {
    return this.http.delete<any>("http://localhost:8088/deleteDriver/" + licensenumber);
  }


}
