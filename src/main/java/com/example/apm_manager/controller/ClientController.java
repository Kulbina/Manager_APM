package com.example.apm_manager.controller;

import com.example.apm_manager.models.Client;
import com.example.apm_manager.models.ClientSearchFIOObject;
import com.example.apm_manager.models.ClientSearchPassport;
import com.example.apm_manager.models.ClientSearchPhone;
import com.example.apm_manager.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {
    ClientService clientService = new ClientService();

    @GetMapping("/home")
    public String home(Model model) {

        List<Client> clients = clientService.findAllClients();
        ClientSearchPhone clientSearchPhone = new ClientSearchPhone();
        ClientSearchPassport clientPassportObject = new ClientSearchPassport();
        ClientSearchFIOObject clientSearchFIOObject = new ClientSearchFIOObject();

        model.addAttribute("name", "APM Manager");
        model.addAttribute("clients", clients);
        model.addAttribute("clientPhoneObject", clientSearchPhone);
        model.addAttribute("clientPassportObject", clientPassportObject);
        model.addAttribute("clientSearchFIOObject", clientSearchFIOObject);

        return "home";
    }

    @GetMapping("client/search/phone")
    public String getClientByPhone(Model model,
                                   @ModelAttribute("clientPhoneObject") ClientSearchPhone clientPhoneObject,
                                   BindingResult result) {
        Client client = clientService.findByPhoneNumber(clientPhoneObject.getPhoneNumber());
        model.addAttribute("clients", client);
        return "client/search/phone";
    }

    @GetMapping("client/search/passport")
    public String getClientByPassport(Model model,
                                      @ModelAttribute("clientPassportObject") ClientSearchPassport clientPassportObject,
                                      BindingResult result) {
        Client client = clientService.findByPassport(
                clientPassportObject.getPassportSeries(),
                clientPassportObject.getPassportNumber()
        );
        model.addAttribute("clients", client);
        return "client/search/passport";
    }

    @GetMapping("client/search/fio")
    public String getClientByFIO(Model model,
                                      @ModelAttribute("clientSearchFIOObject") ClientSearchFIOObject clientSearchFIOObject,
                                      BindingResult result) {
       List<Client> clients = clientService.findByFIO(
                clientSearchFIOObject.firstName,
                clientSearchFIOObject.secondName,
                clientSearchFIOObject.lastName
        );
        model.addAttribute("clients", clients);
        return "client/search/fio";
    }

    @PostMapping("/client/edit")
    public String updateClient(@Validated Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "client/edit";
        }
        Client updateClient = clientService.findClientById(client.getId());
        client.setId(updateClient.getId());
        clientService.updateClient(client);
        return "redirect:/home";
    }

    @GetMapping("/client/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Client client = clientService.findClientById(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));

        model.addAttribute("client", client);
        return "client/edit";
    }

    @GetMapping("client/create")
    public String createClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "client/create";
    }

    @PostMapping("/client/create")
    public String addClient(@Validated Client client,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/home";
        }

        clientService.saveClient(client);
        return "redirect:/home";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id, Model model) {
        Client removingClient = clientService.findClientById(id);
        //.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        clientService.deleteClient(removingClient);
        return "redirect:/home";
    }
}
