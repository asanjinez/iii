import {Component, Input, OnInit} from '@angular/core';
import {IIngrediente} from "../../../models/IIngrediente";

@Component({
  selector: 'app-ingrediente-edit-modal',
  templateUrl: './ingrediente-edit-modal.component.html',
  styleUrls: ['./ingrediente-edit-modal.component.css']
})
export class IngredienteEditModalComponent implements OnInit {
  @Input() ingrediente: IIngrediente | any;

  constructor() {
  }

  ngOnInit(): void {
  }

}
