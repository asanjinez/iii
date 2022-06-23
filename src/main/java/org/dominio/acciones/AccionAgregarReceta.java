package org.dominio.acciones;
import org.dominio.Receta;
public class AccionAgregarReceta extends Accion {
    Receta receta;

    public AccionAgregarReceta(Object objeto) {
        this.receta = (Receta) objeto;
    }

    @Override
    public void accionar() {
        if (!this.estado)
            return;
        receta.sumarPuntaje(10);
        receta.notificarObservers();
    }
}