import {IRecetario} from "./IRecetario";

export interface IRecetarioSerializado{
  _embedded: IRecetarioWrapper;
  links: any;

}

export interface IRecetarioWrapper{
  recetarioList: IRecetario[];

}
