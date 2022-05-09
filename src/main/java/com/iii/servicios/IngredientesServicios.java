package com.iii.servicios;

import com.iii.model.ingredientes.Ingrediente;
import com.iii.repositorios.IngredientesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientesServicios {
    @Autowired
    IngredientesRepositorio repo;

    public Ingrediente save(Ingrediente ingrediente) {
        Ingrediente ingredienteExistente = repo.findByNombre(ingrediente.getNombre()).orElse(null);
        if (ingredienteExistente != null){
            return ingredienteExistente;
        }
        return repo.save(ingrediente);


    }

    public List<Ingrediente> findAll() {
        return (List<Ingrediente>) repo.findAll();

    }

    public Optional<Ingrediente> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Ingrediente> findByName(String nombre){
        return repo.findByNombre(nombre);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
    public void delete(Ingrediente ingrediente){
        repo.delete(ingrediente);
    }

    public void deleteAll(){
        repo.deleteAll();
    }
    public int count(){
        return (int) repo.count();
    }

    public IngredientesRepositorio getRepo() {
        return repo;
    }
}
