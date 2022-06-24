package org.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers;

    public Observable(){
        this.observers = new ArrayList<Observer>();
    }
    public List<Observer> getObservers(){
        return this.observers;
    }
    public void agregarObserver(Observer observer){
        this.observers.add(observer);

    }
    public void eliminarObserver(Observer observer){
        this.observers.remove(observer);
    }

    public abstract void notificarObservers();
    public abstract void notificarObservers(Object object);
}
