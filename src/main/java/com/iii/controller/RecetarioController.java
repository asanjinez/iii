package com.iii.controller;

import com.iii.exceptions.RecetarioNotFoundException;
import com.iii.hateoasAssembler.RecetarioAssembler;
import com.iii.model.Recetario;
import com.iii.servicios.RecetarioServicios;
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
public class RecetarioController {
    @Autowired
    private RecetarioServicios recetarioServicios;

    @Autowired
    private RecetarioAssembler recetarioAssembler;

    @GetMapping("/recetarios")
    public CollectionModel<EntityModel<Recetario>> all() {
        List<EntityModel<Recetario>> recetario = recetarioServicios.findAll().stream().map(recetarioAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(recetario,
                linkTo(methodOn(RecetarioController.class).all()).withSelfRel());
    }

    @PostMapping("/recetarios")
    public  EntityModel<Recetario> create(@RequestBody Recetario recetario) {
        recetario.setRecetas(recetarioServicios.actualizarRecetas(recetario));
        return recetarioAssembler.toModel(recetarioServicios.save(recetario));
    }
    // Single item
    @GetMapping("/recetarios/{id}")
    public  EntityModel<Recetario> singleRecetario(@PathVariable Long id) {
        Recetario recetario = recetarioServicios.findById(id).orElseThrow(() -> new RecetarioNotFoundException(id));
        return recetarioAssembler.toModel(recetario);
    }

    @PutMapping("/recetarios/{id}")
    public EntityModel<Recetario> modifyRecetario(@RequestBody Recetario recetarioNuevo, @PathVariable Long id) {
        return recetarioServicios.findById(id)
                .map(recetario -> {
                    return recetarioAssembler.toModel(recetarioServicios.updateByRecetario(recetario,recetarioNuevo));
                })
                .orElseGet(() -> {
                    recetarioNuevo.setId(id);
                    return recetarioAssembler.toModel(recetarioServicios.save(recetarioNuevo));
                });
    }

    @DeleteMapping("/recetarios/{id}")
    public void deleteRecetario(@PathVariable Long id) {
        recetarioServicios.deleteById(id);
    }
}