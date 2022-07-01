package com.iii.repositorios;


import com.iii.model.ingredientes.cantidad.InfoCantidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoIngredientesRepositorio extends CrudRepository<InfoCantidad,Long>{

}

