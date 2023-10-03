import { Component, OnInit } from '@angular/core';
import {animate, keyframes, query, stagger, style, transition, trigger} from "@angular/animations";
import {IRecetario} from "../../../models/IRecetario";
import {RecetariosService} from "../../../servicios/RecetariosService";
import {IIngrediente} from "../../../models/IIngrediente";
import {IngredientesService} from "../../../servicios/IngredientesService";

@Component({
  selector: 'app-ingredientes-list',
  templateUrl: './ingredientes-list.component.html',
  styleUrls: ['./ingredientes-list.component.scss'],
  animations: [
    trigger('listAnimation', [
      transition('* => *', [
        query(':enter', style({opacity: 0}), {optional: true}),
        query(':enter', stagger('300ms', [
          animate('1s ease-in', keyframes([
            style({opacity: 0, transform: 'translateY(-75%)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)', offset: 0.3}),
            style({opacity: 1, transform: 'translateY(0)', offset: 1.0}),
          ]))]), {optional: true}),
        query(':leave', stagger('300ms', [
          animate('1s ease-in', keyframes([
            style({opacity: 1, transform: 'translateY(0)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)', offset: 0.3}),
            style({opacity: 0, transform: 'translateY(-75%)', offset: 1.0}),
          ]))]), {optional: true})
      ])
    ])
  ]
})
export class IngredientesListComponent implements OnInit {
  ingredientes: IIngrediente[] = [];

  constructor(private ingredientesService: IngredientesService) {
  }

  agregarElemento() {
    // let elemento: IRecetario = {
    //   id: 0,
    //   nombre: 'Recetario-' + this.randomInteger(1, 100),
    //   recetas: [],
    //   links: null
    // }
    // this.recetariosService.postRecetario(elemento).subscribe(recetarioResponse => Object.assign(elemento, recetarioResponse));
    // this.recetarios.push(elemento);
  }

  eliminarElemento() {
    // let deleteRecetario: IRecetario | any = this.recetarios.pop();
    // this.recetariosService.deleteRecetario(deleteRecetario);
  }

  randomInteger(min: number, max: number) {
    return (Math.floor(Math.random() * (max - min + 1)) + min).toString();
  }

  ngOnInit(): void {
    this.obtenerRecetarios()
  }

  obtenerRecetarios():void {
    this.ingredientesService.getAllIngredientes().subscribe(ingredientes => this.ingredientes = ingredientes);
  }

}
