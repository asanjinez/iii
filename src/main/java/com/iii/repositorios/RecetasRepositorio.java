package com.iii.repositorios;

import com.iii.model.Receta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecetasRepositorio extends CrudRepository<Receta,Long> {
    Optional<Receta> findByNombre(String nombre);
}
