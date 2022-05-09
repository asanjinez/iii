package com.iii.repositorios;

import com.iii.model.ingredientes.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientesRepositorio extends CrudRepository<Ingrediente,Long> {
    Optional<Ingrediente> findByNombre(String nombre);
}
