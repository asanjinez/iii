import {Component, Input, OnInit} from '@angular/core';
import {IRecetario} from "../../models/recetario";

@Component({
  selector: 'app-recetario-modal',
  templateUrl: './recetario-modal.component.html',
  styleUrls: ['./recetario-modal.component.css']
})
export class RecetarioModalComponent implements OnInit {
  @Input() recetario:IRecetario|any;
  constructor() { }

  ngOnInit(): void {
  }

}
