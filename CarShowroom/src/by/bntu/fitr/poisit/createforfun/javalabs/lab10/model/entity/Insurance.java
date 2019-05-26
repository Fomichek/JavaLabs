package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity;

public class Insurance extends AccessoryDecorator {
    private Transport transport;
    private int cost;

    public Insurance(Transport transport, int cost) {
        this.transport = transport;
        this.cost = cost;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
    
    @Override
    public int getprice(){
        return this.transport.getPrice() + this.cost;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.transport.toString()).append(" + insurance:").append(cost) ;
        return builder.toString();
    }
    
}
