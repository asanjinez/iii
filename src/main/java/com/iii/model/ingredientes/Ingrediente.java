package com.iii.model.ingredientes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.model.ingredientes.cantidad.CantidadNecesaria;
import com.iii.model.ingredientes.cantidad.InfoCantidad;
import com.iii.model.ingredientes.cantidad.InfoCantidadDTO;
import com.iii.model.ingredientes.cantidad.Unidades;

import javax.persistence.*;

@Entity
@Table(name= "INGREDIENTES")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_INGREDIENTE")
    private TipoIngrediente grupo;
    @Column(name = "NOMBRE_INGREDIENTE")
    private String nombre;
    @Column(name = "CALORIAS_INGREDIENTE")
    private int calorias;

    @JoinColumn(name = "info_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    private InfoCantidadDTO infoCantidadDTO;

    @Transient
    @JsonIgnore
    private InfoCantidad infoCantidad;

    public Ingrediente() {
    }

    public Ingrediente(TipoIngrediente tipo, String nombre, InfoCantidadDTO infoCantidadDTO, int calorias) {
        this.grupo = tipo;
        this.nombre = nombre;
        this.calorias = calorias;
        this.infoCantidadDTO = infoCantidadDTO;
        this.infoCantidad = this.construirInfoCantidad(infoCantidadDTO);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public TipoIngrediente getGrupo() {
        return grupo;
    }
    public void setGrupo(TipoIngrediente grupo) {
        this.grupo = grupo;
    }
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public InfoCantidadDTO getInfoCantidad() {
        return infoCantidadDTO;
    }

    public void setInfoCantidad(InfoCantidadDTO infoCantidadDTO) {
        this.infoCantidadDTO = infoCantidadDTO;
    }
    public InfoCantidadDTO getInfoCantidadDTO() {
        return infoCantidadDTO;
    }

    public void setInfoCantidadDTO(InfoCantidadDTO infoCantidadDTO) {
        this.infoCantidadDTO = infoCantidadDTO;
    }

    public InfoCantidad construirInfoCantidad(InfoCantidadDTO infoCantidadDTO){
        if(infoCantidadDTO.getUnidad() == Unidades.CN){
            return new CantidadNecesaria();
        } else {
            return new InfoCantidad(infoCantidadDTO.getCantidad(), infoCantidadDTO.getUnidad());
        }

    }
}
