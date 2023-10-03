import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {IngredientesListComponent} from "./componentes/ingredientes/ingredientes-list/ingredientes-list.component";
import {RecetariosListComponent} from "./componentes/recetarios-list/recetarios-list.component";

const routes: Routes = [
    {
      path: 'ingredientes',
      component: IngredientesListComponent
    },
    {
      path: "recetarios",
      component: RecetariosListComponent
    }
  ]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
