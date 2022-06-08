import {Component, Input, OnInit, NgModule} from '@angular/core';
import {IRecetario} from "../../models/recetario";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-recetario-edit-modal',
  templateUrl: './recetario-edit-modal.component.html',
  styleUrls: ['./recetario-edit-modal.component.css']
})
export class RecetarioEditModalComponent implements OnInit {
  @Input() recetario: IRecetario|any;
  constructor() { }

  ngOnInit(): void {
  }

}
