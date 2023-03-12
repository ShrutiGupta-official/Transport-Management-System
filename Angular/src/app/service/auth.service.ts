import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicles } from '../vehicles';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl ="";

  constructor(private httpClient: HttpClient) { }

  getVehicleList(): Observable<Vehicles[]>{
    return this.httpClient.get<Vehicles[]>('${this.baseUrl}');
}
}
