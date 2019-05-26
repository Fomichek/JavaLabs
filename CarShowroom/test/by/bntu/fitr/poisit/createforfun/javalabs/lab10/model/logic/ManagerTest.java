package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container.ParkingImpl;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Buyer;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.MAN;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.Porsche;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.PorscheModel.CAYENNE;
import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.PorscheModel.PANAMERA;
import static by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars.TransportColor.BLACK;

public class ManagerTest {

    private ParkingImpl parking;
    private ParkingImpl garage;
    private Buyer buyer;


    @Before
    public void init() {
        Porsche porsche = new Porsche(30000, "SUV", 5,2009, "All-wheel drive", "Auto", CAYENNE);
        Porsche porsche1 = new Porsche(25000, "Hatchback", 5,2007, "All-wheel drive", "Auto", PANAMERA);
        MAN man = new MAN(15000, "Auto transporter", 30,2000, 400.6, "Tipper", BLACK);

        parking = new ParkingImpl();
        parking.addAll(new Transport[]{porsche, porsche1, man});

        garage = new ParkingImpl();

        buyer = new Buyer(garage, "Anatoly", 40000);
        buyer.buy(porsche);
    }

    @After
    public void clear() {
        parking = null;
        garage = null;
    }

    @Test
    public void calculateProfit() {
        String actual = Manager.calculateProfit(buyer, parking);
        String expected = "30000";
        Assert.assertEquals(expected, actual, expected);
    }

    @Test
    public void isNull() {
        String actual = Manager.calculateProfit(null, null);
        String expected = "Parking is null!";
        Assert.assertEquals(expected, actual, expected);
    }

    @Test
    public void isEmpty() {
        parking = new ParkingImpl();
        String actual = Manager.calculateProfit(buyer, parking);
        String expected = "Parking is empty!";
        Assert.assertEquals(expected, actual, expected);
    }
}