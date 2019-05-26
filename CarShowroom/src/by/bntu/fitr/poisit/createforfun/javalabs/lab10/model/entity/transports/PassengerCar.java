package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;

import java.util.Objects;

public class PassengerCar extends Transport {
    private int numberOfPassenger;

    public PassengerCar(){
        super();
        numberOfPassenger = 0;
    }

    public PassengerCar(int price, String bodyType,int year, int numberOfPassenger) {
        super(price, bodyType, year);
        this.numberOfPassenger = numberOfPassenger;
    }
    
    public PassengerCar(PassengerCar passengerCar){

        this.numberOfPassenger = passengerCar.numberOfPassenger;
    }
    
    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger) {
        this.numberOfPassenger = numberOfPassenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return numberOfPassenger == that.numberOfPassenger;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfPassenger);
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber of passenger - " + numberOfPassenger;
    }
}
