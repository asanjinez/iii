import {IInfoCantidad} from "./infoCantidad";

export interface IIngrediente{
  id: number,
  grupo: string,
  nombre: string,
  calorias: number,
  infoIngrediente: IInfoCantidad
}
