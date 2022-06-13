import {Component, Input, OnInit, NgModule} from '@angular/core';
import {IRecetario} from "../../models/recetario";
import {DataService} from "../recetarios-list/data.service";

@Component({
  selector: 'app-recetario-edit-modal',
  templateUrl: './recetario-edit-modal.component.html',
  styleUrls: ['./recetario-edit-modal.component.css']
})
export class RecetarioEditModalComponent implements OnInit {
  @Input() recetario: IRecetario|any;
  gruposIngredientes = ["CARNES","CEREALES","FRUTAS","LACTEOS","LEGUMBRES","VEGETALES"];
  unidadesIngredientes = ["Unidades","Kg","Gr","L","Ml","Cantidad Necesaria"];
  constructor(private dataService:DataService) { }

  ngOnInit(): void {
  }
  guardarCambios(){
    this.dataService.putRecetario(this.recetario.id,this.recetario);

  }
}
