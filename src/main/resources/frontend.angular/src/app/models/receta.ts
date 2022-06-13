import {IIngrediente} from "./ingrediente";

export interface IReceta{
  id: number,
  nombre: string,
  puntaje: number,
  ingredientes: IIngrediente[],
  showIngredientes: boolean


}
