package by.bntu.fitr.poisit.createforfun.javalabs.lab10.controller;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container.ParkingImpl;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.*;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.car.*;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic.Manager;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.view.ConsolePrinter;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.view.Log4jPrinter;

import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.car.PorscheModel.*;
import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.car.TransportColor.BLACK;

public class CarShowroom {
    public static final String WILL_BUY = "Will buy: ";
    public static final String PROFIT = "Car showroom profit - ";
    public static final String CURRENCY = "$";

    public static void main(String[] args) {
        Porsche porsche = new Porsche(30000, "SUV", 5, "All-wheel drive", "Auto", CAYENNE);
        Porsche porsche1 = new Porsche(25000, "Hatchback", 5, "All-wheel drive", "Auto", PANAMERA);
        MAN man = new MAN(15000, "Auto transporter", 30, 400.6, "Tipper", BLACK);

        ParkingImpl parking = new ParkingImpl();
        parking.addAll(new Transport[]{porsche, porsche1, man});

        Log4jPrinter log4jPrinter = new Log4jPrinter();
        log4jPrinter.print(parking.toString());
        ParkingImpl garage = new ParkingImpl();

        Buyer buyer = new Buyer(garage, "Anatoly", 40000);
        buyer.buy(porsche);

        log4jPrinter.print(buyer.toString());
        log4jPrinter.print(WILL_BUY + porsche.getName());
        log4jPrinter.print(PROFIT + Manager.calculateProfit(buyer, parking) + CURRENCY);
        Manager.deletePurchase(parking, porsche);
        log4jPrinter.print(parking.toString());

    }
}
