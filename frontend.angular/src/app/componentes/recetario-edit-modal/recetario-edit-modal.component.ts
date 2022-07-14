import {Component, Input, OnInit, NgModule} from '@angular/core';
import {IRecetario} from "../../models/IRecetario";
import {RecetariosService} from "../../servicios/RecetariosService";
import {GRUPOSINGREDIENTES, INGREDIENTESTYPE, UNIDADESINGREDIENTES} from "../../models/Constants";

@Component({
  selector: 'app-recetario-edit-modal',
  templateUrl: './recetario-edit-modal.component.html',
  styleUrls: ['./recetario-edit-modal.component.scss']
})
export class RecetarioEditModalComponent implements OnInit {
  @Input() recetario: IRecetario | any;
  @Input() elementId: number = 0;
  gruposIngredientes = GRUPOSINGREDIENTES;
  unidadesIngredientes = UNIDADESINGREDIENTES;
  ingredientesType = INGREDIENTESTYPE;

  constructor(private dataService: RecetariosService) {

  }

  ngOnInit(): void {
  }

  guardarCambios() {
    this.dataService.putRecetario(this.recetario.id, this.recetario);

  }
}
