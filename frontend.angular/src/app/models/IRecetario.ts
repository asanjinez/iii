import {IReceta} from "./IReceta";

export interface IRecetario{
  id: number,
  nombre: string,
  recetas: IReceta[],
  links: any

}
