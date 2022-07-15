import {IIngrediente} from "./IIngrediente";

export interface IReceta{
  id: number,
  nombre: string,
  puntaje: number,
  ingredientes: IIngrediente[]

}
