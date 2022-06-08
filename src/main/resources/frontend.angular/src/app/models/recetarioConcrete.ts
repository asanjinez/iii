import {IRecetario} from "./recetario";
import {IReceta} from "./receta";

export class RecetarioConcrete implements IRecetario{
  id: number|any;
  titulo: string|any;
  recetas: IReceta[] = [];
  links: any;


}
