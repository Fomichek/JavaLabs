package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container.ParkingImpl;

import java.util.Objects;

public class Buyer {
    private ParkingImpl garage;
    private String name;
    private int money;


    public Buyer(){
        name = "no name";
        money = 0;
    }

    public Buyer(ParkingImpl garage, String name, int money) {
        this.garage = garage;
        this.name = name;
        this.money = money;
    }
    public Buyer(Buyer buyer){
        garage = buyer.garage;
        name = buyer.name;
        money = buyer.money;
    }

    public ParkingImpl getGarage() {
        return garage;
    }

    public void setGarage(ParkingImpl garage) {
        this.garage = garage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void buy(Transport transport) {
        getGarage().add(transport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return money == buyer.money &&
                Objects.equals(garage, buyer.garage) &&
                Objects.equals(name, buyer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garage, name, money);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\nBuyer\n");
        builder.append("Name - ").append(name).append("\nMoney - ").append(money).append("$\n");
        return builder.toString();

    }
}
