import {Injectable} from '@angular/core';
import {IRecetario} from "../../models/IRecetario"
import {map, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {IRecetarioSerializado} from "../../models/IRecetarioSerializado";
import {IIngrediente} from "../../models/IIngrediente";
import {IIngredienteSerializado, IIngredienteWrapper} from "../../models/IIngredienteSerializado";

@Injectable({
  providedIn: 'root'
})

export class DataService {
  private urlApi = 'http://localhost:8080'

  constructor(private http: HttpClient) {
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

//  -----------
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
