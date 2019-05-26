/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.insuranceCompany;

import java.util.Objects;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;
import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.PassengerCar;

public class InsuranceCompany {
    private static final double BASECOST = 20;
    private static final double YEARTODAY = 2019;
    private static final double BASEAGE = 23;
    private static final double BASEEXPERIENCE = 3;
    private static final double FIRSTCOEF = 0;
    private static final double SECONDCOEF = 0.6;
    private static final double THIRDCOEF = 0.7;
    private static final double FOURTHCOEF = 0.8;
    private static final double BASECOEF = 0.03;
    private static final double PASSENGERCOEF = 0.2;
    private static final double TRUCKCOEF = 0.4;

    private String nameOfCompany ;

    public InsuranceCompany(){
        this.nameOfCompany = "no name";
    }

    public InsuranceCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public InsuranceCompany(InsuranceCompany insuranceCompany) {
        this.nameOfCompany = insuranceCompany.nameOfCompany;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public int costOfInsurance(int driverExperience, int ages, int year,
                               Transport transport){
        double cost = BASECOST + (coefficientOfDriverExperience( driverExperience, ages)
                + coefficientOfYear(year)
                + coefficientOfTypeOfTransport(transport))*BASECOST;
        return (int)cost;
    }

    private double coefficientOfDriverExperience(int driverExperience, int ages){
        double coefficient = FIRSTCOEF;
        if (driverExperience < BASEEXPERIENCE && ages < BASEAGE){
            coefficient = FOURTHCOEF;}
        else if (driverExperience <= BASEEXPERIENCE && ages > BASEAGE){
            coefficient = THIRDCOEF;}
        else if (driverExperience > BASEEXPERIENCE && ages < BASEAGE){
            coefficient = SECONDCOEF;}
        return coefficient;
    }

    private double coefficientOfYear(int year){
        double coefficient = (YEARTODAY - year)*BASECOEF;
        return coefficient;
    }

    private double coefficientOfTypeOfTransport(Transport transport){
        double coefficient = TRUCKCOEF;
        if (transport instanceof PassengerCar){
            coefficient = PASSENGERCOEF;}
        return coefficient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCompany);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceCompany insuranceCompany = (InsuranceCompany) o;
        return Objects.equals(nameOfCompany, insuranceCompany.nameOfCompany);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n InsuranceCompany - ").append(nameOfCompany);
        return builder.toString();
    }
}