package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.car;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.transports.PassengerCar;

public class Porsche extends PassengerCar {
    private String typeOfDrive;
    private String typeOfGearbox;
    private PorscheModel porscheModel;

    public Porsche() {
        super();
        typeOfDrive = "no name";
        typeOfGearbox = "no name";
        porscheModel = PorscheModel.BOXSTER;
    }

    public Porsche(int price, String bodyType, int numberOfPassenger, String typeOfDrive, String typeOfGearbox, PorscheModel porscheModel) {
        super(price, bodyType, numberOfPassenger);
        this.typeOfDrive = typeOfDrive;
        this.typeOfGearbox = typeOfGearbox;
        this.porscheModel = porscheModel;
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

    public String getName() {
        return "Porsche";
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Porsche\n");
        builder.append(super.toString()).append("\nType of drive - ").append(typeOfDrive).append("\nType of gearbox - ").append(typeOfGearbox).
                append("\nModel - ").append(porscheModel).append("\n");
        return builder.toString();
    }
}
