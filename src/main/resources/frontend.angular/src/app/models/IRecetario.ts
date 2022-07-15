import {IReceta} from "./IReceta";

export interface IRecetario{
  id: number,
  nombre: string,
  recetas: IReceta[],
  links: any

}
// {
//   "_embedded": {
//   "recetarioList": [
//     {
//       "id": 36,
//       "titulo": "recetarioConReceta1",
//       "recetas": [
//         {
//           "id": 90,
//           "nombre": "RecetaConIng2",
//           "puntaje": 0,
//           "ingredientes": [
//             {
//               "id": 162,
//               "grupo": "LACTEOS",
//               "nombre": "ingredienteRandom1",
//               "calorias": 2,
//               "cantidad": 10,
//               "unidad": "Unidades"
//             }
//           ]
//         }
//       ],
//       "_links": {
//         "self": {
//           "href": "http://localhost:8080/recetas/36"
//         },
//         "recetarios": {
//           "href": "http://localhost:8080/recetas"
//         }
//       }
//     },
//     {
//       "id": 37,
//       "titulo": "recetarioConReceta2",
//       "recetas": [
//         {
//           "id": 86,
//           "nombre": "RecetaConIng1",
//           "puntaje": 0,
//           "ingredientes": [
//             {
//               "id": 162,
//               "grupo": "LACTEOS",
//               "nombre": "ingredienteRandom1",
//               "calorias": 2,
//               "cantidad": 10,
//               "unidad": "Unidades"
//             },
//             {
//               "id": 163,
//               "grupo": "CARNES",
//               "nombre": "receta64",
//               "calorias": 200,
//               "cantidad": 1,
//               "unidad": "KG"
//             },
//             {
//               "id": 167,
//               "grupo": "CEREALES",
//               "nombre": "ingredienteRandom2",
//               "calorias": 250,
//               "cantidad": 1000,
//               "unidad": "Unidades"
//             }
//           ]
//         }
//       ],
//       "_links": {
//         "self": {
//           "href": "http://localhost:8080/recetas/37"
//         },
//         "recetarios": {
//           "href": "http://localhost:8080/recetas"
//         }
//       }
//     },
//     {
//       "id": 41,
//       "titulo": "recetarioConReceta3",
//       "recetas": [
//         {
//           "id": 90,
//           "nombre": "RecetaConIng2",
//           "puntaje": 0,
//           "ingredientes": [
//             {
//               "id": 162,
//               "grupo": "LACTEOS",
//               "nombre": "ingredienteRandom1",
//               "calorias": 2,
//               "cantidad": 10,
//               "unidad": "Unidades"
//             }
//           ]
//         },
//         {
//           "id": 86,
//           "nombre": "RecetaConIng1",
//           "puntaje": 0,
//           "ingredientes": [
//             {
//               "id": 162,
//               "grupo": "LACTEOS",
//               "nombre": "ingredienteRandom1",
//               "calorias": 2,
//               "cantidad": 10,
//               "unidad": "Unidades"
//             },
//             {
//               "id": 163,
//               "grupo": "CARNES",
//               "nombre": "receta64",
//               "calorias": 200,
//               "cantidad": 1,
//               "unidad": "KG"
//             },
//             {
//               "id": 167,
//               "grupo": "CEREALES",
//               "nombre": "ingredienteRandom2",
//               "calorias": 250,
//               "cantidad": 1000,
//               "unidad": "Unidades"
//             }
//           ]
//         }
//       ],
//       "_links": {
//         "self": {
//           "href": "http://localhost:8080/recetas/41"
//         },
//         "recetarios": {
//           "href": "http://localhost:8080/recetas"
//         }
//       }
//     }
//   ]
// },
//   "_links": {
//   "self": {
//     "href": "http://localhost:8080/recetarios"
//   }
// }
// }
