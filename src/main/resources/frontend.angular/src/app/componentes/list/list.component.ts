import { Component, OnInit } from '@angular/core';
import {animate, keyframes, query, stagger, style, transition, trigger} from "@angular/animations";
import {DataService} from "./data.service";
import {IRecetario} from "../../models/recetario";
import {IRecetarioSerializado} from "../../models/recetariosSerializados";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
  animations: [
    trigger('listAnimation',[
      transition('* => *', [
        query(':enter', style({ opacity: 0 }), {optional: true}),
        query(':enter', stagger('300ms', [
          animate('1s ease-in', keyframes([
            style({opacity: 0, transform: 'translateY(-75%)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)',  offset: 0.3}),
            style({opacity: 1, transform: 'translateY(0)',     offset: 1.0}),
          ]))]), {optional: true}),
        query(':leave', stagger('300ms', [
          animate('1s ease-in', keyframes([
            style({opacity: 1, transform: 'translateY(0)', offset: 0}),
            style({opacity: .5, transform: 'translateY(35px)',  offset: 0.3}),
            style({opacity: 0, transform: 'translateY(-75%)',     offset: 1.0}),
          ]))]), {optional: true})
      ])
    ])
  ]
})

export class ListComponent implements OnInit {
  recetarios : IRecetario[] = [];
  prueba: string[] = [];

  constructor(private dataService: DataService) {
  }
  agregarElemento(){
    let elemento:IRecetario = {
      id: 999,
      titulo: "NuevoPrueba",
      recetas: [],
      links: null
    }
    this.recetarios.push(elemento)
  }




  eliminarElemento(){
    this.recetarios.pop();
  }
  ngOnInit(): void {
    this.showTodos()
  }

  showTodos(){
    this.dataService.getAllRecetarios().subscribe(recetario => this.recetarios= recetario.recetarioList);
  }



}
