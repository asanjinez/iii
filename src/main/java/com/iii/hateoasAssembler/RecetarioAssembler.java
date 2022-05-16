package com.iii.hateoasAssembler;

import com.iii.controller.RecetasController;
import com.iii.model.Recetario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecetarioAssembler implements RepresentationModelAssembler<Recetario, EntityModel<Recetario>> {
    @Override
    public EntityModel<Recetario> toModel(Recetario recetario){
        return EntityModel.of(recetario,
                linkTo(methodOn(RecetasController.class).singleReceta(recetario.getId())).withSelfRel(),
                linkTo(methodOn(RecetasController.class).all()).withRel("recetarios"));
    }
}