package com.iii.hateoasAssembler;


import com.iii.controller.IngredientesController;
import com.iii.controller.RecetasController;
import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import org.hibernate.EntityMode;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecetaAssemebler implements RepresentationModelAssembler<Receta, EntityModel<Receta>> {
    @Override
    public EntityModel<Receta> toModel(Receta receta){
        return EntityModel.of(receta,
                linkTo(methodOn(RecetasController.class).singleReceta(receta.getId())).withSelfRel(),
                linkTo(methodOn(RecetasController.class).all()).withRel("receta"));
    }
}
