package com.example.apm_manager.dao.proposal;

import com.example.apm_manager.models.Proposal;

import java.util.List;

public interface ProposalDAO {
    public Proposal findById(int id);

    public void save(Proposal proposal);

    public void update(Proposal proposal);

    public void delete(Proposal proposal);

    public List<Proposal> findAll();

    public List<Proposal> findAllByClientId(int clientId);
}
