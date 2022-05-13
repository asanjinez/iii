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
}
