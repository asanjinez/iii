package com.iii.controller;


import com.iii.exceptions.IngredienteNotFoundException;
import com.iii.exceptions.RecetaNotFoundException;
import com.iii.hateoasAssembler.IngredienteAssembler;
import com.iii.hateoasAssembler.RecetaAssemebler;
import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.servicios.RecetasServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RecetasController {
    @Autowired
    private RecetasServicios servicioRecetas;
    @Autowired
    private RecetaAssemebler recetaAssembler;

    public RecetasController() {
    }
    @GetMapping("/recetas")
    public CollectionModel<EntityModel<Receta>> all() {
        List<EntityModel<Receta>> recetas = servicioRecetas.findAll().stream().map(recetaAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(recetas,
                linkTo(methodOn(RecetasController.class).all()).withSelfRel());
    }

    @PostMapping("/recetas")
    public  Receta create(@RequestBody Receta receta) {
        return servicioRecetas.save(receta);
    }
    // Single item
    @GetMapping("/recetas/{id}")
    public  EntityModel<Receta> singleReceta(@PathVariable Long id) {
        Receta receta = servicioRecetas.findById(id).orElseThrow(() -> new RecetaNotFoundException(id));
        return recetaAssembler.toModel(receta);
    }

    @PutMapping("/recetas/{id}")
    public  Receta modifyReceta(@RequestBody Receta recetaNueva, @PathVariable Long id) {
        return servicioRecetas.findById(id)
                .map(receta -> {
                    receta.setNombre(recetaNueva.getNombre());
                    receta.setIngredientes(recetaNueva.getIngredientes());
                    return servicioRecetas.save(receta);
                })
                .orElseGet(() -> {
                    recetaNueva.setId(id);
                    return servicioRecetas.save(recetaNueva);
                });
    }

    @DeleteMapping("/recetas/{id}")
    public  void deleteEmployee(@PathVariable Long id) {
        servicioRecetas.deleteById(id);
    }
}

