import {IIngrediente} from "./ingrediente";

export interface IReceta{
  id: number,
  nombre: string,
  ingredientes: IIngrediente[]

}
