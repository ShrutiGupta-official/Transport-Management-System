import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bookinglist } from '../bookinglist';
import { BookingService } from '../service/booking.service';

@Component({
  selector: 'app-add-bookings',
  templateUrl: './add-bookings.component.html',
  styleUrls: ['./add-bookings.component.css']
})
export class AddBookingsComponent implements OnInit {

  vehicle: string = '';
  driver: string = '';
  fromLocation: string = '';
  toLocation: string = '';
  distance: string = '';
  type: string = '';
  tripfare: string = '';
  fuel: string = '';
  driverShare: string = '';
  remarks: string = '';
  startDate: string = '';
  endDate: string = '';



addtobooklist = new Bookinglist();
  constructor(private service:BookingService,  private _route: Router) { }

  ngOnInit(): void {
  }
  addMessage:boolean=false;
  addBooking(){
    this.service.addBookingToList(this.addtobooklist).subscribe
    (
      data=>{
        console.log(this.addtobooklist);
        this.addMessage=true;
        
      },
      error=>{
        console.log("booking not added");
      }
    )
  }
  back(){
    this._route.navigate(['/booking']);
  }
 
}
