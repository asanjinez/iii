package com.iii.servicios;

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

    public Receta save(Receta receta) {
        Receta recetaExistente = repo.findByNombre(receta.getNombre()).orElse(null);
        if (recetaExistente != null){
            return recetaExistente;
        }
        return repo.save(receta);
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

