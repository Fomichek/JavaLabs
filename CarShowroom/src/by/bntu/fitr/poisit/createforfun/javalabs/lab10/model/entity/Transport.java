package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity;

import java.util.Objects;

public class Transport {
    private int price;
    private String bodyType;
    private int year;

    public Transport(){
        price = 0;
        bodyType = "no name";
    }

    public Transport(int price, String bodyType, int year) {
        this.price = price;
        this.bodyType = bodyType;
        this.year = year;
    }

    public Transport(Transport transport){
        bodyType = transport.bodyType;
        price = transport.price;
        year = transport.year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return price == transport.price &&
                year == transport.year &&
                Objects.equals(bodyType, transport.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, bodyType, year);
    }

    @Override
    public String toString() {
        return "\nPrice - " + price + "$\nBody type - " + bodyType + "\nYear - " + year;
    }
}
