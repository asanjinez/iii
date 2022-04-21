package org.dominio.acciones;

import org.dominio.Receta;

public class AccionAgregarHabilitada implements Accion{
    @Override
    public void accionar(Receta receta) {
        receta.sumarPuntaje(10);
    }

    public void cambiarEstado(Receta receta){
        receta.setEstadoAgregar(new AccionAgregarDeshabilitada());
    }
}
