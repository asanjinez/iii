package com.iii.repositorios;

import com.iii.model.Recetario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecetarioRepositorio extends CrudRepository<Recetario,Long> {
    Optional<Recetario> findByTitulo(String nombre);
}
