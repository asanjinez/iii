import {IIngrediente} from "./IIngrediente";

export interface IIngredienteSerializado{
  _embedded: IIngredienteWrapper;
  links: any;

}

export interface IIngredienteWrapper{
  ingredienteList: IIngrediente[];

}
