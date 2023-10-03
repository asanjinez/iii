import {Component, Input, OnInit} from '@angular/core';
import {IReceta} from "../../models/IReceta";
import {animate, style, transition, trigger} from "@angular/animations";

@Component({
  selector: 'app-recetas-accordion',
  templateUrl: './recetas-accordion.component.html',
  styleUrls: ['./recetas-accordion.component.css'],
})
export class RecetasAccordionComponent implements OnInit {
  @Input() receta: IReceta|any;
  @Input() elementId: number = 0;
  constructor() { }

  ngOnInit(): void {
  }

}
