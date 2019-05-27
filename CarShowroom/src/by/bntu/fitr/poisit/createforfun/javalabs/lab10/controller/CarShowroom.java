package by.bntu.fitr.poisit.createforfun.javalabs.lab10.controller;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container.ParkingImpl;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.*;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.*;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic.Insurer;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic.Manager;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.view.ConsolePrinter;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.view.Log4jPrinter;

import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.PorscheModel.*;
import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.TransportColor.BLACK;

public class CarShowroom {
    public static final String WILL_BUY = "Will buy: ";
    public static final String PROFIT = "Car showroom profit - ";
    public static final String CURRENCY = "$";
    public static final String TOTAL_COST = "Total cost - ";
    public static final String INSURANCE = "Insurance - ";

    public static void main(String[] args) {
        Porsche porsche = new Porsche(30000, "SUV", 2009, 5, "All-wheel drive", "Auto", CAYENNE);
        Porsche porsche1 = new Porsche(25000, "Hatchback", 2007, 5, "All-wheel drive", "Auto", PANAMERA);
        MAN man = new MAN(15000, "Auto transporter", 2000, 30, 400.6, "Tipper", BLACK);

        ParkingImpl parking = new ParkingImpl();
        parking.addAll(new Transport[]{porsche, porsche1, man});

        Log4jPrinter log4jPrinter = new Log4jPrinter();
        log4jPrinter.print(parking.toString());
        ParkingImpl garage = new ParkingImpl();

        Buyer buyer = new Buyer(garage, "Anatoly", 40000);
        buyer.buy(porsche);

        log4jPrinter.print(buyer.toString());
        log4jPrinter.print(WILL_BUY + porsche.getName());
        log4jPrinter.print(INSURANCE + Insurer.costOfInsurance(10, 26, 2003, parking.getTransport(0)));
        log4jPrinter.print(PROFIT + Manager.calculateProfit(buyer, parking) + CURRENCY);
        log4jPrinter.print("Passenger capacity:" + Manager.calculateTotalPassengerCapacity(parking));
        log4jPrinter.print("Average load capacity:" + Manager.calculateAverageLoadCapacity(parking));
        log4jPrinter.print(TOTAL_COST + Manager.determineTotalCost(parking) + CURRENCY);
        Manager.deletePurchase(parking, porsche);
        log4jPrinter.print(parking.toString());

    }
}
