import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class CarService {

  constructor(private http: HttpClient) { }

  getCars(): Observable<any> {
    return this.http.get('http://localhost:8090/cars');
  }

  getCarById(id: number):Observable<any> {
    return this.http.get('http://localhost:8090/cars/'+id);
  }
}
