package org.dominio.perfiles;

import org.dominio.Receta;
/*
	Celiaco		No contener cereales
	Vegetariano		No contener carnes
	Vegano		No contener carnes o lácteos
	Carnívoro		Contener carnes y alcanzar las 200 calorías

 */
public interface Perfil {
    public boolean puedeComer(Receta receta);

}

