import {Component, OnInit} from '@angular/core';
import {animate, keyframes, query, stagger, style, transition, trigger} from "@angular/animations";
import {RecetariosService} from "../../servicios/RecetariosService";
import {IRecetario} from "../../models/IRecetario";

@Component({
  selector: 'app-list',
  templateUrl: './recetarios-list.component.html',
  styleUrls: ['./recetarios-list.component.scss'],
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

export class RecetariosListComponent implements OnInit {
  recetarios: IRecetario[] = [];

  constructor(private dataService: RecetariosService) {
  }

  agregarElemento() {
    let elemento: IRecetario = {
      id: 0,
      nombre: 'Recetario-' + this.randomInteger(1, 100),
      recetas: [],
      links: null
    }
    this.dataService.postRecetario(elemento).subscribe(recetarioResponse => Object.assign(elemento, recetarioResponse));
    this.recetarios.push(elemento);
  }

  eliminarElemento() {
    let deleteRecetario: IRecetario | any = this.recetarios.pop();
    this.dataService.deleteRecetario(deleteRecetario);
  }

  randomInteger(min: number, max: number) {
    return (Math.floor(Math.random() * (max - min + 1)) + min).toString();
  }

  ngOnInit(): void {
    this.obtenerRecetarios()
  }

  obtenerRecetarios():void {
    this.dataService.getAllRecetarios().subscribe(recetarios => this.recetarios = recetarios);
  }

}
