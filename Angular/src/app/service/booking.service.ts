
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bookinglist } from '../bookinglist';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  booking: any;

  constructor(private http: HttpClient) { }
    getAllBooking(){

      return this.http.get("http://localhost:8087/GetAllBookings");
    }
    public addBookingToList(addBookingList: Bookinglist) {
      console.log("addBookingList="+addBookingList);
      return this.http.post<any>("http://localhost:8087/AddBooking", addBookingList);
    }
    public searchByDate(start: Date, end:Date){
      return this.http.get("http://localhost:8087/GetBookingsByDateTime/" + start+ "/"+end);
    }
    public searchById(searchById:number){
      return this.http.get("http://localhost:8087/GetBookingById/"+searchById);
    }
    public updateBookings(bookings:Bookinglist, id:number):Observable<Object>{
      const url ="http://localhost:8087/UpdateBooking/"+id;
      return this.http.put(url, bookings);}
}
