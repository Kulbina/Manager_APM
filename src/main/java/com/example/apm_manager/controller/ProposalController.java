package com.example.apm_manager.controller;

import com.example.apm_manager.models.Client;
import com.example.apm_manager.models.Proposal;
import com.example.apm_manager.models.ProposalCreateObject;
import com.example.apm_manager.services.ClientService;
import com.example.apm_manager.services.ProposalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;

@Controller
public class ProposalController {
    ClientService clientService = new ClientService();
    ProposalService proposalService = new ProposalService();

    private static final String PROPOSAL_STATUS_OK = "Одобрено";
    private static final String PROPOSAL_STATUS_NOT_OK = "Не одобрено";

    @GetMapping("proposal/home/{id}")
    public String getProposalHome(@PathVariable("id") int id, Model model) {

        List<Proposal> proposals = proposalService.findAllByClientId(id);
        Client client = clientService.findClientById(id);

        model.addAttribute("name", "APM Manager");
        model.addAttribute("proposals", proposals);
        model.addAttribute("client", client);
        return "proposal/home";
    }

    @GetMapping("proposal/create/{idClient}")
    public String getProposalCreate(@PathVariable("idClient") int idClient, Model model) {

        ProposalCreateObject proposalCreateObject = new ProposalCreateObject();
        proposalCreateObject.proposal = new Proposal();
        proposalCreateObject.clientId = idClient;

        model.addAttribute("name", "APM Manager");
        model.addAttribute("proposalCreateObject", proposalCreateObject);
        return "proposal/create";
    }

    @PostMapping("/proposal/create")
    public String postProposal(@Validated ProposalCreateObject proposalCreateObject,
                               BindingResult result, Model model) {
        Client client = clientService.findClientById(proposalCreateObject.clientId);
        Proposal proposal = proposalCreateObject.proposal;
        proposal.setClient(client);

        if (validateStatus()) proposal.setStatus(PROPOSAL_STATUS_OK);
        else proposal.setStatus(PROPOSAL_STATUS_NOT_OK);

        proposalService.saveProposal(proposal);
        return "redirect:/home";
    }

    private boolean validateStatus() {
        int a = 0;
        int b = 100;

        int randomNumber = a + (int) (Math.random() * b);
        return randomNumber >= 50;
    }
}
