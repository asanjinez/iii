import { Injectable } from '@angular/core';
import { IRecetario } from "../../models/recetario"
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})

export class DataService {
  private urlApi = environment.api;

  constructor(private  http: HttpClient) { }

  getAllRecetarios(): Observable<IRecetario[]>{
    return this.http.get<IRecetario[]>(this.urlApi)
  }
}
