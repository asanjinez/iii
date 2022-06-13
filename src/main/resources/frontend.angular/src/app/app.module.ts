import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { ListComponent } from './componentes/recetarios-list/list.component';
import { RecetarioInfoModalComponent } from './componentes/recetario-info-modal/recetario-info-modal.component';
import { RecetarioEditModalComponent } from './componentes/recetario-edit-modal/recetario-edit-modal.component';
import { RecetarioFormComponent } from './componentes/recetario-form/recetario-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { RecetasAccordionComponent } from './componentes/recetas-accordion/recetas-accordion.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatSelectModule} from "@angular/material/select";
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    // MatSelectModule,
    RecetarioInfoModalComponent,
    RecetarioEditModalComponent,
    RecetarioFormComponent,
    RecetasAccordionComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MdbCheckboxModule,
    MdbFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
