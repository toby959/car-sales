package com.carsales.CarSales.model;

import java.util.List;

public class Clients {
    private List<Client> clients;

    // Constructor vacío (requerido por Jackson)
    public Clients() {}

    public Clients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> clients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
