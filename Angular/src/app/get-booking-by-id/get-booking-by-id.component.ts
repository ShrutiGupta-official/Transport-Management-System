import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../service/booking.service';

@Component({
  selector: 'app-get-booking-by-id',
  templateUrl: './get-booking-by-id.component.html',
  styleUrls: ['./get-booking-by-id.component.css']
})
export class GetBookingByIdComponent implements OnInit {

  //id : string = '';
  getbookingbyid!: number;
  bookingidlist:any;
  hideDiv!: boolean;
  noDataDisplay!:boolean;

  constructor(private bookingservice:BookingService,  private route: Router) { }
  
  ngOnInit(): void {
    this.hideDiv= true;
    this.noDataDisplay=true;
  }

  searchById(){
    this.hideDiv=false;
    this.bookingservice.searchById(this.getbookingbyid).subscribe
    (
      data=>{
        this.bookingidlist = data;
        
        console.log(this.bookingidlist);
        if(this.bookingidlist==''|| this.bookingidlist==null){
          this.hideDiv=true;
          this.noDataDisplay = false;
        }
      },
      error=>{
        console.log("Data Not Found");
        this.hideDiv= true;
        this.noDataDisplay = false;
      }
    )
  }

  }