package com.iii.servicios;

import com.iii.model.Recetario;
import com.iii.repositorios.RecetarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetarioServicios {
    @Autowired
    RecetarioRepositorio repo;

    public Recetario save(Recetario recetario) {
        Recetario recetarioExistente = repo.findByTitulo(recetario.getTitulo()).orElse(null);
        if (recetarioExistente != null){
            return recetarioExistente;
        }
            return repo.save(recetario);
    }

    public List<Recetario> findAll() {
        return (List<Recetario>) repo.findAll();
    }

    public Optional<Recetario> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Recetario> findByName(String nombre){
        return repo.findByTitulo(nombre);
    }

    public void deleteById(Long id) {
    repo.deleteById(id);
}
    public void delete(Recetario recetario){
    repo.delete(recetario);
}

    public void deleteAll(){
    repo.deleteAll();
}
}

