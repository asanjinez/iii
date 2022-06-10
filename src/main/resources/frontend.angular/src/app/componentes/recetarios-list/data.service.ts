import { Injectable } from '@angular/core';
import { IRecetario } from "../../models/recetario"
import {map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IRecetarioSerializado} from "../../models/recetariosSerializados";
import {IRecetarioWrapper} from "../../models/recetarioWrapper";

@Injectable({
  providedIn: 'root'
})

export class DataService {
  private urlApi = 'http://localhost:8080'

  constructor(private  http: HttpClient) { }

  getAllRecetarios(): Observable<IRecetarioWrapper>{
    return this.http.get<IRecetarioSerializado>(`${this.urlApi}/recetarios`).pipe(map(response => response._embedded));
  }
  putRecetario(id:number, objeto:IRecetario){
    this.http.put<IRecetario>(`${this.urlApi}/recetarios/ ${id}`,objeto).subscribe();
  }
}
