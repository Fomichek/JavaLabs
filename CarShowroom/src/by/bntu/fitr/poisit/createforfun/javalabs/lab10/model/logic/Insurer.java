package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.logic;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.PassengerCar;

public class Insurer {
    private static final double BASE_COST = 2000;
    private static final double YEAR_TODAY = 2019;
    private static final double BASE_AGE = 23;
    private static final double BASE_EXPERIENCE = 3;
    private static final double FIRST_COEF = 0;
    private static final double SECOND_COEF = 0.6;
    private static final double THIRD_COEF = 0.7;
    private static final double FOURTH_COEF = 0.8;
    private static final double BASE_COEF = 0.03;
    private static final double PASSENGER_COEF = 0.2;
    private static final double TRUCK_COEF = 0.4;

    public static int costOfInsurance(int driverExperience, int age, int year,
                                      Transport transport) {
        double cost = BASE_COST + (coefficientOfDriverExperience(driverExperience, age)
                + coefficientOfYear(year)
                + coefficientOfTypeOfTransport(transport)) * BASE_COST;
        return (int) cost;
    }

    private static double coefficientOfDriverExperience(int driverExperience, int age) {
        double coefficient = FIRST_COEF;
        if (driverExperience < BASE_EXPERIENCE && age < BASE_AGE) {
            coefficient = FOURTH_COEF;
        } else if (driverExperience <= BASE_EXPERIENCE && age > BASE_AGE) {
            coefficient = THIRD_COEF;
        } else if (driverExperience > BASE_EXPERIENCE && age < BASE_AGE) {
            coefficient = SECOND_COEF;
        }
        return coefficient;
    }

    private static double coefficientOfYear(int year) {
        double coefficient = (YEAR_TODAY - year) * BASE_COEF;
        return coefficient;
    }

    private static double coefficientOfTypeOfTransport(Transport transport) {
        double coefficient = TRUCK_COEF;
        if (transport instanceof PassengerCar) {
            coefficient = PASSENGER_COEF;
        }
        return coefficient;
    }
}
