import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-get-driver-list-by-id',
  templateUrl: './get-driver-list-by-id.component.html',
  styleUrls: ['./get-driver-list-by-id.component.css']
})
export class GetDriverListByIdComponent implements OnInit {

  vehicletype: string = '';


  constructor() { }

  ngOnInit(): void {
  }

  selectVehicle() {
  console.log(this.vehicletype)
  }
}
