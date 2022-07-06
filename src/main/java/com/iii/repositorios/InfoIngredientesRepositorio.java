package com.iii.repositorios;


import com.iii.model.ingredientes.cantidad.Medibles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoIngredientesRepositorio extends CrudRepository<Medibles,Long>{

}

