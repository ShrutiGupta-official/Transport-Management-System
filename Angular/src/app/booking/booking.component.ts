import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';
//import {Bookinglist } from '../bookinglist';
import { BookingService } from '../service/booking.service';
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  bookinglist:any;

  constructor(private bookingService:BookingService, private router: Router) { }

  ngOnInit(): void {
    this.bookingService.getAllBooking().subscribe(
      (data)=>{
        this.bookinglist=data;
      }
    );
    
 }
 updateBooking(id:number){
  this.router.navigate(['/updatebooking',id]);
}

}
