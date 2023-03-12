import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../service/booking.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-update-booking',
  templateUrl: './update-booking.component.html',
  styleUrls: ['./update-booking.component.css']
})
export class UpdateBookingComponent implements OnInit {


  id:any;
  bookings!:any;

  constructor(private bookingService:BookingService, private router:Router, public datepipe:DatePipe, private acRoute:ActivatedRoute) { }
  // constructor(private bookingService:BookingService, private router:Router, private acRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.acRoute.snapshot.params['id'];
    this.bookingService.searchById(this.id).subscribe(data=>{
      this.bookings=data;
      console.log(this.bookings);
      
    })
  }
  updateMessage:boolean=false;
  updateBookings(){
    this.bookingService.updateBookings(this.bookings, this.id).subscribe(data=>{
      this.updateMessage=true;
      
    })
    
  }
  back(){
    this.goToBookingList();
    
  }
  goToBookingList()
  {
    this.router.navigate(['/booking'])
  }


}