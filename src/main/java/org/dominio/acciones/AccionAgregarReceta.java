package org.dominio.acciones;
import org.dominio.Receta;
public class AccionAgregarReceta extends Accion {
    Receta receta;

    public AccionAgregarReceta(Receta receta) {
        this.receta = receta;
    }
    @Override
    public void accionar() {
        if (!this.estado)
            return;
        receta.sumarPuntaje(10);
        receta.notificarObservers();
    }
}