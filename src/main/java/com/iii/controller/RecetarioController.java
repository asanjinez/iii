package com.iii.controller;

import com.iii.exceptions.RecetarioNotFoundException;
import com.iii.hateoasAssembler.RecetarioAssembler;
import com.iii.model.Recetario;
import com.iii.servicios.RecetarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RecetarioController {
    @Autowired
    private RecetarioServicios servicioRecetarios;
    @Autowired
    private RecetarioAssembler recetarioAssembler;

    @GetMapping("/recetarios")
    public CollectionModel<EntityModel<Recetario>> all() {
        List<EntityModel<Recetario>> recetario = servicioRecetarios.findAll().stream().map(recetarioAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(recetario,
                linkTo(methodOn(RecetarioController.class).all()).withSelfRel());
    }

    @PostMapping("/recetarios")
    public  EntityModel<Recetario> create(@RequestBody Recetario recetario) {
        return recetarioAssembler.toModel(recetario);
    }
    // Single item
    @GetMapping("/recetarios/{id}")
    public  EntityModel<Recetario> singleRecetario(@PathVariable Long id) {
        Recetario recetario = servicioRecetarios.findById(id).orElseThrow(() -> new RecetarioNotFoundException(id));
        return recetarioAssembler.toModel(recetario);
    }

    @PutMapping("/recetarios/{id}")
    public EntityModel<Recetario> modifyRecetario(@RequestBody Recetario recetarioNuevo, @PathVariable Long id) {
        return servicioRecetarios.findById(id)
                .map(recetario -> {
                    recetario.setTitulo(recetarioNuevo.getTitulo());
                    recetario.setRecetas(recetarioNuevo.getRecetas());
                    return recetarioAssembler.toModel(recetario);
                })
                .orElseGet(() -> {
                    recetarioNuevo.setId(id);
                    return recetarioAssembler.toModel(recetarioNuevo);
                });
    }

    @DeleteMapping("/recetarios/{id}")
    public void deleteRecetario(@PathVariable Long id) {
        servicioRecetarios.deleteById(id);
    }
}