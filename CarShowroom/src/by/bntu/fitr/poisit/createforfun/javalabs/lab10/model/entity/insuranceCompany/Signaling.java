package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.insuranceCompany;


import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;

public class Signaling extends AccessoryDecorator {
    private Transport transport;
    private final int COST = 50;

    public Signaling(Transport transport) {
        this.transport = transport;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public int getprice() {
        return this.transport.getPrice() + this.COST;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.transport.toString()).append(" + signaling:").append(COST);
        return builder.toString();
    }
}
