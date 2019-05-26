package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container.ParkingImpl;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Buyer;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;
public class Manager {
    public static final String IS_NULL = "Parking is null!";
    public static final String IS_EMPTY = "Parking is empty!";

    public static String calculateProfit(Buyer buyer, ParkingImpl parking) {
        if (checkNull(buyer, parking)) {
            return IS_NULL;
        } else if (checkEmpty(parking)) {
            return IS_EMPTY;
        }
        int profit = 0;
        for (int i = 0; i < buyer.getGarage().getSize(); i++) {
            profit += buyer.getGarage().getTransport(i).getPrice();
        }
        return profit + "";
    }

    public static void deletePurchase(ParkingImpl parking, Transport transport) {
        parking.delete(transport);
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
