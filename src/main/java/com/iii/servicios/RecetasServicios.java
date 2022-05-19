package com.iii.servicios;

import com.iii.exceptions.NombreExistenteException;
import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.repositorios.RecetasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetasServicios {
    @Autowired
    RecetasRepositorio repo;
    @Autowired
    IngredientesServicios ingredientesServicios;

    public Receta save(Receta receta) {
        this.nombreExistenteThrowException(receta);
        receta.setIngredientes(this.actualizarIngredientes(receta));
        return repo.save(receta);
}
    public Receta updateByReceta(Receta recetaVieja, Receta recetaNueva) {
        if (!recetaVieja.getNombre().equals(recetaNueva.getNombre()))
            this.nombreExistenteThrowException(recetaNueva);

        recetaVieja.setNombre(recetaNueva.getNombre());
        recetaVieja.setIngredientes(this.actualizarIngredientes(recetaNueva));

        return repo.save(recetaVieja);
    }

    public Receta updateByNombre(Receta recetaNueva) {
        Receta recetaExistente = repo.findByNombre(recetaNueva.getNombre()).orElse(null);
        if (recetaExistente == null)
            return recetaNueva;
        List<Ingrediente> ingredientesNuevos = this.actualizarIngredientes(recetaNueva);

        recetaExistente.setNombre(recetaNueva.getNombre());
        recetaExistente.setIngredientes(ingredientesNuevos);
        return repo.save(recetaExistente);
    }
    public void nombreExistenteThrowException(Receta receta){
        Receta recetaNombreExistente = repo.findByNombre(receta.getNombre()).orElse(null);
        if (recetaNombreExistente != null)
            throw new NombreExistenteException(recetaNombreExistente.getNombre());

    }
    public List<Ingrediente> actualizarIngredientes(Receta receta){
        List<Ingrediente> listaIngredientes = receta.getIngredientes();
        for (int i =0;i < listaIngredientes.size(); i++){
            Ingrediente ingrediente = listaIngredientes.get(i);
            listaIngredientes.set(i,ingredientesServicios.updateByNombre(ingrediente));
        }
        return listaIngredientes;
    }
    public List<Receta> findAll() {
       return (List<Receta>) repo.findAll();
}

    public Optional<Receta> findById(Long id) {
        return repo.findById(id);
}

    public Optional<Receta> findByName(String nombre){
    return repo.findByNombre(nombre);
}

    public void deleteById(Long id) {
    repo.deleteById(id);
}
    public void delete(Receta receta){
    repo.delete(receta);
}

    public void deleteAll(){
    repo.deleteAll();
    }

    public int count(){
    return (int) repo.count();
    }
}

