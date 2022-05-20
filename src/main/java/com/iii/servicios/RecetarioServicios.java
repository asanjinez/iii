package com.iii.servicios;

import com.iii.exceptions.NombreExistenteException;
import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.ingredientes.Ingrediente;
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
        recetario.setRecetas(this.actualizarRecetas(recetario));
        return repo.save(recetario);
    }
    public Recetario updateByRecetario(Recetario recetarioViejo, Recetario recetarioNuevo){
        if (!recetarioViejo.getTitulo().equals(recetarioNuevo.getTitulo()))
            this.nombreExistenteThrowException(recetarioNuevo);

        recetarioViejo.setTitulo(recetarioNuevo.getTitulo());
        recetarioViejo.setRecetas(this.actualizarRecetas(recetarioNuevo));

        return repo.save(recetarioViejo);
    }
    public Recetario updateByNombre(Recetario recetarioNuevo) {
        Recetario recetarioExistente = repo.findByTitulo(recetarioNuevo.getTitulo()).orElse(null);
        if (recetarioExistente == null)
            return recetarioNuevo;
        List<Receta> recetasNuevas = this.actualizarRecetas(recetarioNuevo);

        recetarioExistente.setTitulo(recetarioNuevo.getTitulo());
        recetarioExistente.setRecetas(recetasNuevas);
        return repo.save(recetarioExistente);
    }

    public void nombreExistenteThrowException(Recetario recetario){
        Recetario recetaNombreExistente = repo.findByTitulo(recetario.getTitulo()).orElse(null);
        if (recetaNombreExistente != null)
            throw new NombreExistenteException(recetaNombreExistente.getTitulo());
    }
    public List<Receta> actualizarRecetas(Recetario recetario){
        List<Receta> listaRecetas = recetario.getRecetas();
        for (int i =0;i < listaRecetas.size(); i++){
            Receta receta = listaRecetas.get(i);
            listaRecetas.set(i,recetasServicios.updateByNombre(receta));
        }
        return listaRecetas;
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

