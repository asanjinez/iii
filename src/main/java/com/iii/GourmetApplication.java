package com.iii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GourmetApplication {

	public static void main(String[] args) {
		ApplicationContext apc= SpringApplication.run(GourmetApplication.class, args);
//		IngredientesRepositorio repo = apc.getBean(IngredientesRepositorio.class);
//		repo.save(new Ingrediente(TipoIngrediente.CARNES, "Milanesa", 20, 20, "Unidades"));
//		for (Ingrediente ing: repo.findAll()){
//				System.out.println(ing.toString());
//			}
	}

//	@Bean
//	public CommandLineRunner ingredientes(IngredientesRepositorio repo) {
//		return (args) -> {
//			repo.save(new Ingrediente(TipoIngrediente.CARNES, "Milanesa", 20, 20, "Unidades"));
//
//
//			for (Ingrediente ing: repo.findAll()){
//				System.out.println(ing.toString());
//			}
//			Ingrediente ingModificar = repo.findById(1L).orElseThrow(Exception::new);
//			ingModificar.setNombre("NOMBRECAMBIADO");
//			repo.save(ingModificar);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner recetas(RecetasRepositorio repo) {
//		return (args) -> {
//			Receta receta1 = new Receta("RecetaPrueba");
//			receta1.agregarIngrediente(new Ingrediente(TipoIngrediente.CEREALES, "Cereal", 20, 20, "Unidades"));
//			repo.save(receta1);
//
//			for (Receta receta: repo.findAll()){
//				System.out.println(receta.toString());
//			}
//		};
//	}
//
//	@Bean
//	public CommandLineRunner recetarios(RecetarioRepositorio repo) {
//		return (args) -> {
//			Receta receta1 = new Receta("Receta1");
//			receta1.agregarIngrediente(new Ingrediente(TipoIngrediente.CEREALES, "Cereal", 20, 20, "Unidades"));
//
//			Recetario recetario1 = new Recetario("RecetariaoPrueba");
//			recetario1.agregarReceta(receta1);
//			repo.save(recetario1);
//
//			for (Recetario recetario: repo.findAll()){
//				System.out.println(recetario.toString());
//			}
//		};
//	}
}
