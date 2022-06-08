import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {IRecetario} from "../../models/recetario";
import {RecetarioConcrete} from "../../models/recetarioConcrete";
import {parseJson} from "@angular/cli/utilities/json-file";
import {stringify} from "@angular/compiler/src/util";
import {IReceta} from "../../models/receta";
@Component({
  selector: 'app-recetario-form',
  templateUrl: './recetario-form.component.html',
  styleUrls: ['./recetario-form.component.css']
})

export class RecetarioFormComponent implements OnInit {
  @Input() recetarioEdit: IRecetario|any;
  recetarioBuilder: IRecetario|any;
  constructor() {
  }

  ngOnInit(): void {
    this.recetarioBuilder = Object.assign({}, this.recetarioEdit);
  }
  guardarCambios(){
    this.recetarioEdit = Object.assign(this.recetarioEdit, this.recetarioBuilder);

    alert(JSON.stringify(this.recetarioEdit))
  }

}
