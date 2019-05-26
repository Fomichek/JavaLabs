package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.Truck;

import java.util.Objects;

public class MAN extends Truck {
    private double fuelTankCapacity;
    private String vehicleType;
    private TransportColor transportColor;

    public MAN(){
        super();
        fuelTankCapacity = 0.0;
        vehicleType = "no name";
        transportColor = TransportColor.BLACK;
    }

    public MAN(int price, String bodyType, int loadCapacity, double fuelTankCapacity, String vehicleType, TransportColor transportColor) {
        super(price, bodyType, loadCapacity);
        this.fuelTankCapacity = fuelTankCapacity;
        this.vehicleType = vehicleType;
        this.transportColor = transportColor;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public TransportColor getTransportColor() {
        return transportColor;
    }

    public void setTransportColor(TransportColor transportColor) {
        this.transportColor = transportColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MAN man = (MAN) o;
        return Double.compare(man.fuelTankCapacity, fuelTankCapacity) == 0 &&
                Objects.equals(vehicleType, man.vehicleType) &&
                transportColor == man.transportColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelTankCapacity, vehicleType, transportColor);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MAN\n");
        builder.append(super.toString()).append("\nFuel tank capacity - ").append(fuelTankCapacity).append("l\nVehicle type - ").append(vehicleType).
                append("\nTransport color - ").append(transportColor).append("\n");
        return builder.toString();
    }
}
