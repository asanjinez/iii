import {Component, Input, OnInit} from '@angular/core';
import {IIngrediente} from "../../../models/IIngrediente";

@Component({
  selector: 'app-ingrediente-info-modal',
  templateUrl: './ingrediente-info-modal.component.html',
  styleUrls: ['./ingrediente-info-modal.component.css']
})
export class IngredienteInfoModalComponent implements OnInit {
  @Input() ingrediente: IIngrediente | any;

  constructor() { }

  ngOnInit(): void {
  }

}
