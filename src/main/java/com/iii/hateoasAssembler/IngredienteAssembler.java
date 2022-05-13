package com.iii.hateoasAssembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.iii.controller.IngredientesController;
import com.iii.model.ingredientes.Ingrediente;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class IngredienteAssembler implements RepresentationModelAssembler<Ingrediente,EntityModel<Ingrediente>> {

    @Override
    public EntityModel<Ingrediente> toModel(Ingrediente ingrediente){
        return EntityModel.of(ingrediente,
                linkTo(methodOn(IngredientesController.class).singleIngrediente(ingrediente.getId())).withSelfRel(),
                linkTo(methodOn(IngredientesController.class).all()).withRel("ingrediente"));
    }
}
