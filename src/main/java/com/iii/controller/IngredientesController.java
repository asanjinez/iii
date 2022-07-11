package com.iii.controller;

import com.iii.exceptions.ResourceNotFoundException;
import com.iii.hateoasAssembler.IngredienteAssembler;
import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.servicios.IngredientesServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientesController {
    @Autowired
    private IngredientesServicios servicioIngredientes;

    @Autowired
    private IngredienteAssembler ingredienteAssembler;

    public IngredientesController() {
    }

    @GetMapping("/ingredientes")
    public CollectionModel<EntityModel<Ingrediente>> all() {
        List<EntityModel<Ingrediente>> ingredientes = servicioIngredientes.findAll().stream().map(ingredienteAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(ingredientes,
                linkTo(methodOn(IngredientesController.class).all()).withSelfRel());
    }

    @PostMapping("/ingredientes")
    public EntityModel<Ingrediente> create(@RequestBody Ingrediente alimento) {
        return ingredienteAssembler.toModel(servicioIngredientes.save(alimento));
    }

    // Single item
    @GetMapping("/ingredientes/{id}")
    public EntityModel<Ingrediente> singleIngrediente(@PathVariable Long id) {
        Ingrediente ingrediente = servicioIngredientes.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ingredienteAssembler.toModel(ingrediente);
    }

    @PutMapping("/ingredientes/{id}")
    public EntityModel<Ingrediente> modifyIngrediente(@RequestBody Ingrediente ingredienteNuevo, @PathVariable Long id) {
        return servicioIngredientes.findById(id)
                .map(ingrediente -> {
                    return ingredienteAssembler.toModel(servicioIngredientes.updateById(ingrediente, id));
                })
                .orElseGet(() -> {
                    ingredienteNuevo.setId(id);
                    return ingredienteAssembler.toModel(servicioIngredientes.save(ingredienteNuevo));
                });
    }

    @DeleteMapping("/ingredientes/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        servicioIngredientes.deleteById(id);
    }
}
