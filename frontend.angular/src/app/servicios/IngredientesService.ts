import {Injectable} from '@angular/core';

import {map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {IIngrediente} from "../models/IIngrediente";
import {IIngredienteSerializado} from "../models/IIngredienteSerializado";

@Injectable({
  providedIn: 'root'
})

export class IngredientesService {
  private urlApi = "";

  constructor(private http: HttpClient) {
    this.urlApi = environment.baseUrl;
  }
  getAllIngredientes(): Observable<IIngrediente[]> {
    return this.http.get<IIngredienteSerializado>(`${this.urlApi}/ingredientes`).pipe(map(response => response._embedded.ingredienteList));
  }

  // putIngrediente(id: number, objeto: IIngrediente) {
  //   this.http.put<IIngrediente>(`${this.urlApi}/recetarios/ ${id}`, objeto).subscribe();
  // }
  //
  // postIngrediente(objeto: IIngrediente): Observable<IIngrediente> {
  //   return this.http.post<IIngrediente>(`${this.urlApi}/recetarios`, objeto);
  // }
  //
  // deleteIngrediente(objeto: IIngrediente) {
  //   this.http.delete(`${this.urlApi}/recetarios/ ${objeto.id}`,).subscribe();
  // }

}
