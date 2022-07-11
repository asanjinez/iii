package com.iii.servicios;

import com.iii.exceptions.ResourceNotFoundException;
import com.iii.exceptions.NombreExistenteException;
import com.iii.model.Receta;
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
    @Autowired
    RecetasServicios recetasServicios;

    public Recetario save(Recetario recetario) {
        this.nombreExistenteThrowException(recetario);
//        recetario.setRecetas(this.actualizarRecetas(recetario));
        return repo.save(recetario);
    }

    public Recetario updateById(Recetario recetario, Long id){
        Recetario recetarioBuscado = repo.findById(id).orElse(null);
        if (recetarioBuscado == null)
            throw new ResourceNotFoundException(id);
        if (!nombreValido(recetario.getNombre(), recetarioBuscado))
            throw new NombreExistenteException(recetario.getNombre());

        recetarioBuscado.setNombre(recetario.getNombre());
        recetarioBuscado.setRecetas(this.actualizarRecetas(recetario));
        return repo.save(recetarioBuscado);
    }
    public void nombreExistenteThrowException(Recetario recetario){
        Recetario recetaNombreExistente = repo.findByNombre(recetario.getNombre()).orElse(null);
        if (recetaNombreExistente != null)
            throw new NombreExistenteException(recetaNombreExistente.getNombre());
    }
    public List<Receta> actualizarRecetas(Recetario recetario){
        List<Receta> listaRecetas = recetario.getRecetas();
        for (int i =0;i < listaRecetas.size(); i++){
            Receta receta = listaRecetas.get(i);
            listaRecetas.set(i,recetasServicios.updateByNombre(receta));
        }
        return listaRecetas;
    }

    public boolean mismoNombreReceta(Recetario recetario1, Recetario recetario2){
        return recetario1.getNombre().equals(recetario2.getNombre());
    }

    public boolean nombreValido(String nombreDeseado, Recetario recetario) {
        boolean nombreValido = true;
        Recetario recetarioBuscado = repo.findByNombre(nombreDeseado).orElse(null);
        if (recetarioBuscado != null) {
            if (!mismoNombreReceta(recetario, recetarioBuscado))
                nombreValido = false;
        }
        return nombreValido;

    }

    public List<Recetario> findAll() {
        return (List<Recetario>) repo.findAll();
    }

    public Optional<Recetario> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<Recetario> findByName(String nombre){
        return repo.findByNombre(nombre);
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

