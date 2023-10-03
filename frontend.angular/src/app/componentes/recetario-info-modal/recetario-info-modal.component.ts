import {Component, Input, OnInit} from '@angular/core';
import {IRecetario} from "../../models/IRecetario";


@Component({
  selector: 'app-recetario-info-modal',
  templateUrl: './recetario-info-modal.component.html',
  styleUrls: ['./recetario-info-modal.component.css'],

})
export class RecetarioInfoModalComponent implements OnInit {
  @Input() recetario: IRecetario | any;

  constructor() {
  }

  ngOnInit(): void {
  }

}
