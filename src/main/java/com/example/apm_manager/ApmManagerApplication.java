package com.example.apm_manager;

import com.example.apm_manager.models.Client;
import com.example.apm_manager.models.Proposal;
import com.example.apm_manager.services.ClientService;
import com.example.apm_manager.services.ProposalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApmManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApmManagerApplication.class, args);
        // clientCRUDTest();
    }
    public static void printAllClients(ClientService clientService){
        for(Client client: clientService.findAllClients()){
            System.out.println(client.toString());
        }
    }

    public static void printAllProposals(ProposalService proposalService){
        for(Proposal proposal : proposalService.findAllProposals()){
            System.out.println(proposal.toString());
        }
    }

    public  static void clientCRUDTest(){
        Client client = new Client(
                "sobaka1",
                "sobaka",
                "sobaka",
                "sobaka",
                "sobaka",
                454654,
                "cat",
                "cat",
                "cat",
                46546,
                476574
        );

        ClientService clientService = new ClientService();
        clientService.saveClient(client);
        clientService.findByFIO("sobaka","5555", "sobaka");
//        System.out.println("SAVE");
//        printAllClients(clientService);
//
//
//        client.setFirstName("5555");
//        clientService.updateClient(client);
//        System.out.println("UPDATE");
//        printAllClients(clientService);
//
//        //clientService.deleteClient(client);
//        System.out.println("DEL");
//        printAllClients(clientService);
//
//        ProposalService proposalService = new ProposalService();
//        proposalService.saveProposal(new Proposal(
//                "open",
//                212,
//                1111,
//                2222,
//                client
//        ));
//        printAllProposals(proposalService);
    }
}
