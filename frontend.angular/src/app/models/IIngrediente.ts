export interface IIngrediente{
  id: number,
  grupo: string,
  nombre: string,
  calorias: number,
  infoIngrediente: IInfoCantidad
}

export interface IInfoCantidad{
  id: number,
  cantidad: number,
  unidad: string,
  type: string
}
