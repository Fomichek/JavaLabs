package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity;

import java.util.Objects;

public class Transport {
    private int price;
    private String bodyType;

    public Transport(){
        price = 0;
        bodyType = "no name";
    }

    public Transport(int price, String bodyType) {
        this.price = price;
        this.bodyType = bodyType;
    }
    
    public Transport(Transport transport){
        this.bodyType = transport.bodyType;
        this.price = transport.price;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return price == transport.price &&
                Objects.equals(bodyType, transport.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, bodyType);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nPrice - ").append(price).append("$\nBody type - ").
                append(bodyType);
        return builder.toString();
    }
}
