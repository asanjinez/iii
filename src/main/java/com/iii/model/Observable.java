package com.iii.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public abstract class Observable {
    @JsonIgnore
    private List<Observer> observers;

    public Observable(){
        this.observers = new ArrayList<Observer>();
    }
    public List<Observer> getObservers(){
        return this.observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void agregarObserver(Observer observer){
        this.observers.add(observer);
    }
    public void eliminarObserver(Observer observer){
        this.observers.remove(observer);
    }
    public void notificarObservers(Receta receta){
        this.observers.forEach(observer -> observer.actualizar(receta));
    }
}
