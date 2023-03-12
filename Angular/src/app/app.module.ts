import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthInterceptor } from './service/auth.interceptor';
import { AuthGuard } from './service/auth.guard';
import { LoginService } from './service/login.service';
import { BookingByDatetimeComponent } from './booking-by-datetime/booking-by-datetime.component';
import { UpdateVehicleComponent } from './update-vehicle/update-vehicle.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { GetDriverByVehicletypeComponent } from './get-driver-by-vehicletype/get-driver-by-vehicletype.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

// import { LoginService } from './service/loginservice.service';
// import { AuthGuard } from './service/auth.guard';
// import { AuthInterceptor } from './service/auth.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    routingComponents,
    HomeComponent,
    UpdateVehicleComponent,
    UpdateBookingComponent,
    GetDriverByVehicletypeComponent,
    HeaderComponent,
    FooterComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [DatePipe,LoginService,AuthGuard,[{provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
