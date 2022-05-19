package com.iii.servicios;

import com.iii.exceptions.NombreExistenteException;
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
        this.nombreExistenteThrowException(ingrediente);
        return repo.save(ingrediente);
    }

    public Ingrediente updateByNombre(Ingrediente ingrediente) {
        Ingrediente ingredienteExistente = repo.findByNombre(ingrediente.getNombre()).orElse(null);
        if (ingredienteExistente != null){
            ingredienteExistente.setUnidad(ingrediente.getUnidad());
            ingredienteExistente.setGrupo(ingrediente.getGrupo());
            ingredienteExistente.setCantidad(ingrediente.getCantidad());
            ingredienteExistente.setCalorias(ingrediente.getCalorias());
            return repo.save(ingredienteExistente);

        }
        return repo.save(ingrediente);
    }

    public Ingrediente updateByIngrediente(Ingrediente ingredienteViejo,Ingrediente ingredienteNuevo) {
        this.nombreExistenteThrowException(ingredienteNuevo);
        ingredienteViejo.setNombre(ingredienteNuevo.getNombre());
        ingredienteViejo.setUnidad(ingredienteNuevo.getUnidad());
        ingredienteViejo.setGrupo(ingredienteNuevo.getGrupo());
        ingredienteViejo.setCantidad(ingredienteNuevo.getCantidad());
        ingredienteViejo.setCalorias(ingredienteNuevo.getCalorias());
        return repo.save(ingredienteViejo);

    }

    public void nombreExistenteThrowException(Ingrediente ingrediente){
        Ingrediente ingredienteNombreExistente = repo.findByNombre(ingrediente.getNombre()).orElse(null);
        if (ingredienteNombreExistente != null)
            throw new NombreExistenteException(ingredienteNombreExistente.getNombre());
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
