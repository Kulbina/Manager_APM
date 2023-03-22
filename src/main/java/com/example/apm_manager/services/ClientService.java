package com.example.apm_manager.services;

import com.example.apm_manager.dao.client.ClientDAO;
import com.example.apm_manager.dao.client.ClientDaoImpl;
import com.example.apm_manager.models.Client;

import java.util.List;

public class ClientService {

    private ClientDAO clientDao = new ClientDaoImpl();

    public ClientService() {

    }

    public Client findClientById(int id) {
        return clientDao.findById(id);
    }

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public List<Client> findAllClients() {
        return clientDao.findAll();
    }

    public Client findByPhoneNumber(Long phoneNumber) {
        return clientDao.findByPhoneNumber(phoneNumber);
    }

    public List<Client> findByFIO(String fn, String sn, String ln) {
        return clientDao.findByFIO(fn, sn, ln);
    }

    public Client findByPassport(Integer passportSeries, Integer passportNumber) {
        return clientDao.findByPassport(passportSeries, passportNumber);
    }
}
