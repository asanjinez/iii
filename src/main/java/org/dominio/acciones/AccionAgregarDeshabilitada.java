package org.dominio.acciones;

import org.dominio.Receta;

public class AccionAgregarDeshabilitada implements Accion{
    @Override
    public void accionar(Receta receta) {
        return;
    }

    @Override
    public void cambiarEstado(Receta receta) {
        receta.setEstadoAgregar(new AccionAgregarHabilitada());
    }
}
