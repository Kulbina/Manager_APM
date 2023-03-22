package com.example.apm_manager.dao.client;

import com.example.apm_manager.models.Client;

import java.util.List;

public interface ClientDAO {
    public Client findById(int id);

    public void save(Client client);

    public void update(Client client);

    public void delete(Client client);

    public List<Client> findAll();

    public Client findByPhoneNumber(Long phoneNumber);

    public List<Client> findByFIO(String firstName, String secondName, String lastName);

    public Client findByPassport(Integer passportSeries, Integer passportNumber);
}
