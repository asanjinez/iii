import {Component, Input, OnInit} from '@angular/core';
import {IReceta} from "../../models/receta";

@Component({
  selector: 'app-recetas-accordion',
  templateUrl: './recetas-accordion.component.html',
  styleUrls: ['./recetas-accordion.component.css']
})
export class RecetasAccordionComponent implements OnInit {
  @Input() receta: IReceta|any;
  constructor() { }

  ngOnInit(): void {
  }

}
