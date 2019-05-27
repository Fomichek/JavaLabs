package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container.ParkingImpl;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Buyer;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;
import org.apache.log4j.Logger;

public class Manager {
    public static final String IS_NULL = "Parking is null!";
    public static final String IS_EMPTY = "Parking is empty!";
    public static final String GET_TRANSPORT = "Attempt to get transport with index ";

    private static Logger LOGGER = Logger.getLogger(Manager.class);

    public static String calculateProfit(Buyer buyer, ParkingImpl parking) {
        if (checkNull(buyer, parking)) {
            LOGGER.warn(IS_NULL);
            return IS_NULL;
        } else if (checkEmpty(parking)) {
            LOGGER.warn(IS_EMPTY);
            return IS_EMPTY;
        }
        int profit = 0;
        for (int i = 0; i < buyer.getGarage().getSize(); i++) {
            try {
                LOGGER.trace(GET_TRANSPORT + i);
                profit += buyer.getGarage().getTransport(i).getPrice();
            } catch (IndexOutOfBoundsException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return profit + "";
    }

    public static void deletePurchase(ParkingImpl parking, Transport transport) {
        parking.delete(transport);
    }

    public static String determineMostExpensive(ParkingImpl parking) {
        int index = 0;
        if (checkEmpty(parking)) {
            LOGGER.warn(IS_EMPTY);
            return IS_EMPTY;
        }
        for (int i = 1; i < parking.getSize(); i++) {
            try {
                LOGGER.trace(GET_TRANSPORT + i);
                if (parking.getTransport(index).getPrice() < parking.getTransport(i).getPrice()) {
                    index = i;
                }
            } catch (IndexOutOfBoundsException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return parking.getTransport(index).toString();
    }

    public static String determineTotalCost(ParkingImpl parking) {
        int total = 0;
        if (checkEmpty(parking)) {
            LOGGER.warn(IS_EMPTY);
            return IS_EMPTY;
        }
        for (int i = 0; i < parking.getSize(); i++) {
            try {
                LOGGER.trace(GET_TRANSPORT + i);
                total += parking.getTransport(i).getPrice();
            } catch (IndexOutOfBoundsException e){
                LOGGER.error(e.getMessage());
            }
        }
        return total + "";
    }

    public static boolean checkNull(Buyer buyer, ParkingImpl parking) {
        boolean flag = false;
        if (buyer == null && parking == null) {
            flag = true;
        }
        return flag;
    }

    public static boolean checkEmpty(ParkingImpl parking) {
        boolean flag = false;
        if (parking.getSize() == 0) {
            flag = true;
        }
        return flag;
    }

}
