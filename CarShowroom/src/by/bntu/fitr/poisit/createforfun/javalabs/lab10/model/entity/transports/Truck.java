package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;

import java.util.Objects;

public class Truck extends Transport {
    private int loadCapacity;

    public Truck() {
        super();
        loadCapacity = 0;
    }

    public Truck(int price, String bodyType,int year, int loadCapacity) {
        super(price, bodyType, year);
        this.loadCapacity = loadCapacity;
    }
    public Truck(Truck truck){
        loadCapacity = truck.loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return loadCapacity == truck.loadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

    @Override
    public String toString() {
        return super.toString() + "\nLoad capacity - " + loadCapacity;
    }
}
