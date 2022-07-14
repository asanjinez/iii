import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { AppComponent } from './app.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { RecetariosListComponent } from './componentes/recetarios-list/recetarios-list.component';
import { RecetarioInfoModalComponent } from './componentes/recetario-info-modal/recetario-info-modal.component';
import { RecetarioEditModalComponent } from './componentes/recetario-edit-modal/recetario-edit-modal.component';
import {FormsModule} from "@angular/forms";
import { RecetasAccordionComponent } from './componentes/recetas-accordion/recetas-accordion.component';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import {APP_INITIALIZER} from "@angular/core";
import {ConfigService} from "./servicios/config.service";

export function loadConfiguration(configService:ConfigService) {
  return () => {
    return configService.loadConfig();
  }
}

@NgModule({
  declarations: [
    AppComponent,
    RecetariosListComponent,
    RecetarioInfoModalComponent,
    RecetarioEditModalComponent,
    RecetasAccordionComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MdbFormsModule
  ],
  providers: [
    ConfigService,
    {
    provide: APP_INITIALIZER,
    useFactory: loadConfiguration,
    multi: true,
    deps: [
      ConfigService
    ],
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
