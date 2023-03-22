package com.example.apm_manager.services;

import com.example.apm_manager.dao.proposal.ProposalDAO;
import com.example.apm_manager.dao.proposal.ProposalDAOImpl;
import com.example.apm_manager.models.Proposal;

import java.util.List;

public class ProposalService {

    public ProposalService() {

    }

    private ProposalDAO proposalDAO = new ProposalDAOImpl();

    public Proposal findProposalById(int id) {
        return proposalDAO.findById(id);
    }

    public void saveProposal(Proposal proposal) {
        proposalDAO.save(proposal);
    }

    public void deleteProposal(Proposal proposal) {
        proposalDAO.delete(proposal);
    }

    public void updateProposal(Proposal proposal) {
        proposalDAO.update(proposal);
    }

    public List<Proposal> findAllProposals() {
        return proposalDAO.findAll();
    }

    public List<Proposal> findAllByClientId(int clientId) {
        return proposalDAO.findAllByClientId(clientId);
    }
}
