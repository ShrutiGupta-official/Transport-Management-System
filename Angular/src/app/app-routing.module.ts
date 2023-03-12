import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { GetVehicleByRegNoComponent } from './get-vehicle-by-reg-no/get-vehicle-by-reg-no.component';
import { GetVehicleByTypeComponent } from './get-vehicle-by-type/get-vehicle-by-type.component';
import { GetBookingByIdComponent } from './get-booking-by-id/get-booking-by-id.component';
import { GetDriverListByIdComponent } from './get-driver-list-by-id/get-driver-list-by-id.component';
import { AddBookingsComponent } from './add-bookings/add-bookings.component';
import { AddDriverComponent } from './add-driver/add-driver.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { BookingByDatetimeComponent } from './booking-by-datetime/booking-by-datetime.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { UpdateVehicleComponent } from './update-vehicle/update-vehicle.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { DriverListComponent } from './driver-list/driver-list.component';
import { BookingComponent } from './booking/booking.component';
import { AuthGuard } from './service/auth.guard';
import { GetDriverByVehicletypeComponent } from './get-driver-by-vehicletype/get-driver-by-vehicletype.component';


const routes: Routes = [
  { 
    path: '', 
    component: LoginComponent 
},
  { 
    path: 'home', 
    component: HomeComponent ,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'getvehiclelistbyregno', component: GetVehicleByRegNoComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'getvehiclebytype', component: GetVehicleByTypeComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'getbookingbyid', component: GetBookingByIdComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'getdriverbyid', component: GetDriverListByIdComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'addbookings', component: AddBookingsComponent,
     pathMatch: 'full',
     canActivate: [AuthGuard]
  },
  {
    path: 'addvehicle', component: AddVehicleComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'adddriver', component: AddDriverComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  // {
  //   path: 'getbookingbydatetime', component: GetBookingByDatetimeComponent,
  //   pathMatch: 'full',
  //   canActivate: [AuthGuard]
  // },
  {
    path: 'updatebooking/:id', component: UpdateBookingComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'updatevehicle/:registrationNo', component: UpdateVehicleComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'vehiclelist', component: VehicleListComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'driverlist', component: DriverListComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'booking', component: BookingComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'getbookingbydatetime', component: BookingByDatetimeComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'getdriverbyvehicletype', component: GetDriverByVehicletypeComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  }






];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, GetVehicleByRegNoComponent, GetVehicleByTypeComponent,
  GetBookingByIdComponent, GetDriverListByIdComponent, AddBookingsComponent, AddVehicleComponent,
  AddDriverComponent, BookingByDatetimeComponent, UpdateBookingComponent, UpdateVehicleComponent,
  VehicleListComponent, DriverListComponent, BookingComponent, GetDriverByVehicletypeComponent]
