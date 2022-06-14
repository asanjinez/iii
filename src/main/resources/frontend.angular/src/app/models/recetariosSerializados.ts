import {IRecetarioWrapper} from "./recetarioWrapper";

export interface IRecetarioSerializado{
  _embedded: IRecetarioWrapper;
  links: any;

}
