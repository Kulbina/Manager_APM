package com.example.apm_manager.services;

import com.example.apm_manager.dao.contract.ContractDAO;
import com.example.apm_manager.dao.contract.ContractDAOImpl;
import com.example.apm_manager.models.Contract;

import java.util.List;

public class ContractService {
    public ContractService() {

    }

    private ContractDAO contractDAO = new ContractDAOImpl();

    public Contract findContractById(int id){return contractDAO.findById(id);}

    public void saveContract(Contract contract){contractDAO.save(contract);}

    public void updateContract(Contract contract){contractDAO.update(contract);}

    public void deleteContract(Contract contract){contractDAO.delete(contract);}

    public List<Contract> findAllContract(){return contractDAO.findAll();}

}
