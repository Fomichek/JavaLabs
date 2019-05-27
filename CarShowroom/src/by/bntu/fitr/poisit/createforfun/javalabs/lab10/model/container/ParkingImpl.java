package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;

import java.util.Arrays;
import java.util.Objects;

public class ParkingImpl implements Parking {
    private Transport[] parking;
    private int size;

    public ParkingImpl() {
        parking = new Transport[0];
    }

    public ParkingImpl(Transport... transports) {
        this.parking = Arrays.copyOf(transports, transports.length);
        this.size = parking.length;
    }

    public ParkingImpl(ParkingImpl parkingImpl) {
        parking = parkingImpl.parking;
    }


    public Transport getTransport(int indexTransport) {
        return parking[indexTransport];
    }

    public Transport setTransport(int indexTransport, Transport newTransport) {
        Transport transport = parking[indexTransport];
        parking[indexTransport] = newTransport;
        return transport;
    }

    public boolean add(Transport transport) {
        if (transport != null) {
            Transport[] newParking = new Transport[size + 1];
            System.arraycopy(parking, 0, newParking, 0, size);
            newParking[size] = transport;
            parking = new Transport[newParking.length];
            System.arraycopy(newParking, 0, parking, 0, newParking.length);
            size++;
            return true;
        }
        return false;
    }

    public void addAll(Transport[] transports) {
        Transport[] newParking = new Transport[size + transports.length];
        System.arraycopy(parking, 0, newParking, 0, size);
        System.arraycopy(transports, 0, newParking, size, transports.length);
        parking = new Transport[newParking.length];
        System.arraycopy(newParking, 0, parking, 0, newParking.length);
        size = newParking.length;

    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            parking[i] = null;
        }
        parking = new Transport[0];
        size = 0;
    }

    public Transport delete(int indexTransport) {
        Transport transportDeleted = getTransport(indexTransport);
        deletePrimary(indexTransport);
        return transportDeleted;
    }

    public boolean delete(Transport transport) {
        int indexTransport = findIndex(transport);
        if (indexTransport > -1) {
            deletePrimary(indexTransport);
            return true;
        }
        return false;
    }

    public void deletePrimary(int indexTransport) {
        Transport[] newParking = new Transport[size - 1];
        System.arraycopy(parking, 0, newParking, 0, indexTransport);
        System.arraycopy(parking, indexTransport + 1, newParking, indexTransport,
                size - indexTransport - 1);
        parking = new Transport[newParking.length];
        System.arraycopy(newParking, 0, parking, 0, newParking.length);
        size--;
    }

    public int findIndex(Transport transport) {

        int indexTransport = -1;
        for (int i = 0; i < size; i++) {
            if (transport.equals(parking[i])) {
                indexTransport = i;
                break;
            }

        }
        return indexTransport;
    }

    public int getSize() {
        return size;
    }

    public Transport[] getParking() {
        return parking;
    }

    public void setParking(Transport[] parking) {
        this.parking = parking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingImpl parking1 = (ParkingImpl) o;
        return size == parking1.size &&
                Arrays.equals(parking, parking1.parking);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(parking);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\nParking: \n");
        builder.append("---------------\n");
        for (Transport criterion : parking) {
            builder.append(criterion).append("\n");
            builder.append("---------------\n");
        }

        return builder.toString();
    }
}
