import {Injectable} from '@angular/core';

import {IRecetario} from "../models/IRecetario"
import {map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IRecetarioSerializado} from "../models/IRecetariosSerializados";
import {environment} from "../../environments/environment";
import {IIngrediente} from "../models/IIngrediente";
import {IIngredienteSerializado} from "../models/IIngredienteSerializado";

@Injectable({
  providedIn: 'root'
})

export class RecetariosService {
  private urlApi = "";

  constructor(private http: HttpClient) {
    this.urlApi = environment.baseUrl;
  }

  getAllRecetarios(): Observable<IRecetario[]> {
    return this.http.get<IRecetarioSerializado>(`${this.urlApi}/recetarios`).pipe(map(response => response._embedded.recetarioList));
  }

  putRecetario(id: number, objeto: IRecetario) {
    this.http.put<IRecetario>(`${this.urlApi}/recetarios/ ${id}`, objeto).subscribe();
  }

  postRecetario(objeto: IRecetario): Observable<IRecetario> {
    return this.http.post<IRecetario>(`${this.urlApi}/recetarios`, objeto);
  }

  deleteRecetario(objeto: IRecetario) {
    this.http.delete(`${this.urlApi}/recetarios/ ${objeto.id}`,).subscribe();
  }
}
