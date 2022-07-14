package com.iii.servicios;

import com.iii.exceptions.ResourceNotFoundException;
import com.iii.exceptions.NombreExistenteException;
import com.iii.model.Receta;
import com.iii.repositorios.RecetasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
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
        receta.setIngredientes(receta.getIngredientes());
        return repo.save(receta);

}
    public Receta updateById(Receta receta, Long id){
        Receta recetaBuscada = repo.findById(id).orElseThrow( () -> new ResourceNotFoundException(id) );
        if (!nombreValido(receta.getNombre(), recetaBuscada))
            throw new NombreExistenteException(receta.getNombre());

        recetaBuscada.setNombre(receta.getNombre());
        recetaBuscada.setIngredientes(receta.getIngredientes());
        return repo.save(recetaBuscada);
    }
    public Receta updateByNombre(Receta recetaNueva) {
        Receta recetaExistente = repo.findByNombre(recetaNueva.getNombre()).orElse(null);
        if (recetaExistente == null)
            return repo.save(recetaNueva);

        recetaExistente.setNombre(recetaNueva.getNombre());
        recetaExistente.setIngredientes(recetaNueva.getIngredientes());
        return repo.save(recetaExistente);
    }
    public void nombreExistenteThrowException(Receta receta){
        Receta recetaNombreExistente = repo.findByNombre(receta.getNombre()).orElse(null);
        if (recetaNombreExistente != null)
            throw new NombreExistenteException(recetaNombreExistente.getNombre());

    }
    public boolean mismoNombreReceta(Receta receta1, Receta receta2){
        return receta1.getNombre().equals(receta2.getNombre());
    }
    public boolean nombreValido(String nombreDeseado, Receta receta) {
        boolean nombreValido = true;
        Receta recetaBuscada = repo.findByNombre(nombreDeseado).orElse(null);
        if (recetaBuscada != null) {
            if (!mismoNombreReceta(receta, recetaBuscada))
                nombreValido = false;
        }
        return nombreValido;

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

