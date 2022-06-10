import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {IRecetario} from "../../models/recetario";
import {DataService} from "../recetarios-list/data.service";
import {IReceta} from "../../models/receta";
import {IIngrediente} from "../../models/ingrediente";
@Component({
  selector: 'app-recetario-form',
  templateUrl: './recetario-form.component.html',
  styleUrls: ['./recetario-form.component.css']
})

export class RecetarioFormComponent implements OnInit {
  @Input() recetarioEdit: IRecetario|any;
  recetarioBuilder: IRecetario|any;
  gruposIngredientes = ["CARNES","CEREALES","FRUTAS","LACTEOS","LEGUMBRES","VEGETALES"];
  unidadesIngredientes = ["Unidades","Kg","Gr","L","Ml","Cantidad Necesaria"];
  constructor(private dataService: DataService) {
  }

  ngOnInit(): void {
    this.recetarioBuilder = Object.assign({}, this.recetarioEdit);
  }
  guardarCambios(){
    this.dataService.putRecetario(this.recetarioBuilder.id,this.recetarioBuilder);
    this.recetarioEdit = Object.assign(this.recetarioEdit, this.recetarioBuilder);

    alert(JSON.stringify(this.recetarioEdit))
  }

  agregarReceta(){
    let recetaNueva = {
      id: 0,
      nombre: "",
      ingredientes: [],
    }
    this.recetarioBuilder.recetas.push(recetaNueva);
    // console.log(recetaNueva)
  }
  agregarIngrediente(indexReceta:number){
    let ingredienteNuevo = {
        id: 0,
        tipo: "",
        nombre: "",
        calorias: 0,
        cantidad: "",
        unidad: 0
    }
    this.recetarioBuilder.recetas[indexReceta].ingredientes.push(ingredienteNuevo)
    console.log(this.recetarioBuilder)
  }

}
