package com.iii.model.ingredientes.cantidad;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME , include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({ @JsonSubTypes.Type(name = "Medibles", value = Medibles.class),
                @JsonSubTypes.Type(name = "CantidadNecesaria", value = CantidadNecesaria.class) })

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public abstract class InfoCantidad {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public abstract int getCantidad();
    public abstract Unidades getUnidad();

}

