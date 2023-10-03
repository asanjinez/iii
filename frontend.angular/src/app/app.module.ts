import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AppComponent } from './app.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { RecetariosListComponent } from './componentes/recetarios-list/recetarios-list.component';
import { RecetarioInfoModalComponent } from './componentes/recetario-info-modal/recetario-info-modal.component';
import { RecetarioEditModalComponent } from './componentes/recetario-edit-modal/recetario-edit-modal.component';
import {FormsModule} from "@angular/forms";
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { RecetasAccordionComponent } from './componentes/recetas-accordion/recetas-accordion.component';
import {AppRoutingModule} from "./app.routing.module";
import {IngredientesListComponent} from "./componentes/ingredientes/ingredientes-list/ingredientes-list.component";
import { IngredienteInfoModalComponent } from './componentes/ingredientes/ingrediente-info-modal/ingrediente-info-modal.component';
import { IngredienteEditModalComponent } from './componentes/ingredientes/ingrediente-edit-modal/ingrediente-edit-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    RecetariosListComponent,
    RecetarioInfoModalComponent,
    RecetarioEditModalComponent,
    RecetasAccordionComponent,
    IngredientesListComponent,
    IngredienteInfoModalComponent,
    IngredienteEditModalComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MdbFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
