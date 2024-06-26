package com.iii.controller;


import com.iii.exceptions.ResourceNotFoundException;
import com.iii.hateoasAssembler.RecetaAssemebler;
import com.iii.model.Receta;
import com.iii.servicios.RecetasServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class RecetasController {
    @Autowired
    private RecetasServicios recetasServicios;

    @Autowired
    private RecetaAssemebler recetaAssembler;

    public RecetasController() {
    }
    @GetMapping("/recetas")
    public CollectionModel<EntityModel<Receta>> all() {
        List<EntityModel<Receta>> recetas = recetasServicios.findAll().stream().map(recetaAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(recetas,
                linkTo(methodOn(RecetasController.class).all()).withSelfRel());
    }

    @PostMapping("/recetas")
    public  EntityModel<Receta> create(@RequestBody Receta receta) {
        return recetaAssembler.toModel(recetasServicios.save(receta));
    }
    @GetMapping("/recetas/{id}")
    public  EntityModel<Receta> singleReceta(@PathVariable Long id) {
        Receta receta = recetasServicios.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return recetaAssembler.toModel(receta);
    }

    @PutMapping("/recetas/{id}")
    public  EntityModel<Receta> modifyReceta(@RequestBody Receta recetaNueva, @PathVariable Long id) {
        return recetaAssembler.toModel(recetasServicios.updateById(recetaNueva,id));
    }

    @DeleteMapping("/recetas/{id}")
    public  void deleteEmployee(@PathVariable Long id) {
        recetasServicios.deleteById(id);
    }
}

