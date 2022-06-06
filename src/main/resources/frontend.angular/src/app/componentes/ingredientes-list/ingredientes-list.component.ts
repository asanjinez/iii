import {Component, Input, OnInit} from '@angular/core';
import {IIngrediente} from "../../models/ingrediente";
import {animate, query, stagger, style, transition, trigger} from "@angular/animations";


@Component({
  selector: 'app-ingredientes-list',
  templateUrl: './ingredientes-list.component.html',
  styleUrls: ['./ingredientes-list.component.css'],
  animations: [
    trigger('animate', [
      transition(':enter', [
        style({ opacity: 0, transform: 'translateX(-10px)' }),
        animate('250ms', style({ opacity: 1, transform: 'translateX(0px)' }))
      ]),
      transition(':leave', [
        style({ opacity: 1 }),
        animate('250ms', style({ opacity: 0, transform: 'translateX(10px)' }))
      ])
    ])
  ]

})
export class IngredientesListComponent implements OnInit {
  showIngredientes = false;
  @Input() ingredientes: IIngrediente[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  toggleIngredientesVisibility() {
    this.showIngredientes = ! this.showIngredientes;
  }

}
