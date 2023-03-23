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
      
    }
}
