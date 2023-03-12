import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service"; 

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private loginservice:LoginService){}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let newReq = req;
        let token = this.loginservice.getToken();
        //console.log("Interceptor ",token)
        if(token!=null)
        {
            // adds Bearer + token to the requested list
            newReq = newReq.clone({setHeaders:{Authorization:`Bearer ${token}`}});
            
        }

        return next.handle(newReq);

    }
    
}