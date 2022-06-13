import {Component, Input, OnInit} from '@angular/core';
import {IIngrediente} from "../../models/ingrediente";
import {animate, query, stagger, style, transition, trigger} from "@angular/animations";
import {IReceta} from "../../models/receta";
import {IRecetario} from "../../models/recetario";


@Component({
  selector: 'app-recetario-info-modal',
  templateUrl: './recetario-info-modal.component.html',
  styleUrls: ['./recetario-info-modal.component.css'],
  animations: [
    trigger('animate', [
      transition(':enter', [
        style({ opacity: 1, transform: 'translateX(-10px)' }),
        animate('250ms', style({ opacity: 1, transform: 'translateX(0px)' }))
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate('250ms', style({ opacity: 1, transform: 'translateX(10px)' }))
      ])
    ])
  ]

})
export class RecetarioInfoModalComponent implements OnInit {
  showIngredientes = false;
  @Input() recetario: IRecetario|any;

  constructor() { }

  ngOnInit(): void {
  }

  toggleIngredientesVisibility() {
    this.showIngredientes = ! this.showIngredientes;
  }

}
