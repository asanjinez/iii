import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { ListComponent } from './componentes/recetarios-list/list.component';
import { IngredientesListComponent } from './componentes/ingredientes-list/ingredientes-list.component';
import { RecetarioModalComponent } from './componentes/recetario-modal/recetario-modal.component';
import { RecetarioEditModalComponent } from './componentes/recetario-edit-modal/recetario-edit-modal.component';
import { RecetarioFormComponent } from './componentes/recetario-form/recetario-form.component';
import {FormsModule} from "@angular/forms";
// import {MatSelectModule} from '@angular/select'

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    // MatSelectModule,
    IngredientesListComponent,
    RecetarioModalComponent,
    RecetarioEditModalComponent,
    RecetarioFormComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
