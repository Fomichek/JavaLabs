package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.cars;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.PassengerCar;

import java.util.Objects;

public class Porsche extends PassengerCar {
    private String typeOfDrive;
    private String typeOfGearbox;
    private PorscheModel porscheModel;

    public Porsche(){
        super();
        typeOfDrive = "no name";
        typeOfGearbox = "no name";
        porscheModel = PorscheModel.BOXSTER;
    }

    public Porsche(int price, String bodyType,
            int numberOfPassenger,int year, String typeOfDrive,
            String typeOfGearbox, PorscheModel porscheModel) {
        super(price, bodyType, numberOfPassenger, year);
        this.typeOfDrive = typeOfDrive;
        this.typeOfGearbox = typeOfGearbox;
        this.porscheModel = porscheModel;
    }
    public Porsche(Porsche porsche){
        typeOfDrive = porsche.typeOfDrive;
        typeOfGearbox = porsche.typeOfGearbox;
        porscheModel = porsche.porscheModel;
    }

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public String getTypeOfGearbox() {
        return typeOfGearbox;
    }

    public void setTypeOfGearbox(String typeOfGearbox) {
        this.typeOfGearbox = typeOfGearbox;
    }

    public PorscheModel getPorscheModel() {
        return porscheModel;
    }

    public void setPorscheModel(PorscheModel porscheModel) {
        this.porscheModel = porscheModel;
    }

    public String getName(){
        return "Porsche";
    }

    @Override
    public String toString() {
        return "Porsche\n" + super.toString() + "\nType of drive - " + typeOfDrive + "\nType of gearbox - " +
                typeOfGearbox + "\nModel - " + porscheModel + "\n";
    }
}
