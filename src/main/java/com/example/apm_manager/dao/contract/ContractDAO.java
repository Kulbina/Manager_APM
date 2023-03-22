package com.example.apm_manager.dao.contract;

import com.example.apm_manager.models.Contract;

import java.util.List;

public interface ContractDAO {
    public Contract findById(int id);

    public void save(Contract contract);

    public void update(Contract contract);

    public void delete(Contract contract);

    public List<Contract> findAll();

}
