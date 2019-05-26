package by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.container;

import by.bntu.fitr.poisit.createforfun.javalabs.lab10.model.entity.Transport;

public interface Parking {
    Transport getTransport(int index);

    Transport setTransport(int index, Transport newTransport);

    boolean add(Transport transport);

    void addAll(Transport[] transport);

    void clear();

    Transport delete(int index);

    boolean delete(Transport transport);

    void deletePrimary(int index);

    int findIndex(Transport transport);
}
