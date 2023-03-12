import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../service/booking.service';

@Component({
  selector: 'app-get-booking-by-datetime',
  templateUrl: './booking-by-datetime.component.html',
  styleUrls: ['./booking-by-datetime.component.css']
})
export class BookingByDatetimeComponent implements OnInit {

  start!: Date;
  end!: Date;
  bookingbydate:any;
  noDataDisplay!:boolean;
  hideDiv!:boolean;

  constructor(private bookingservice:BookingService,  private route: Router) { }
  
  ngOnInit(): void {
  this.hideDiv=true;
  this.noDataDisplay=true;
  }
 searchByDate(){
  this.hideDiv=false;
  this.bookingservice.searchByDate(this.start, this.end).subscribe
  (
    
    data=>{
      this.bookingbydate = data;
      this.noDataDisplay= true;
      
      console.log(this.bookingbydate);
      if(this.bookingbydate==''|| this.bookingbydate==null){
        this.hideDiv= true;
        this.noDataDisplay = false;
      }
    },
    error=>{
      this.hideDiv=true;
      console.log("Data Not Found");
      this.noDataDisplay = false;
    }
  )
}
}
