package com.iii.servicios;

import com.iii.exceptions.ResourceNotFoundException;
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
        return repo.save(ingrediente);
    }
    public List<Ingrediente> findAll() {
        return (List<Ingrediente>) repo.findAll();
    }
    public Ingrediente updateById(Ingrediente ingrediente, Long id){
        Ingrediente ingredienteBuscado = repo.findById(id).orElse(null);
        if (ingredienteBuscado == null)
            throw new ResourceNotFoundException(id);
        ingredienteBuscado.setInfoCantidad(ingrediente.getInfoCantidad());
        ingredienteBuscado.setCalorias(ingrediente.getCalorias());
        ingredienteBuscado.setNombre(ingrediente.getNombre());
        ingredienteBuscado.setGrupo(ingrediente.getGrupo());

        return repo.save(ingredienteBuscado);
    }

    public Optional<Ingrediente> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Ingrediente> findByNombre(String nombre){
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
