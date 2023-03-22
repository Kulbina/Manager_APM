package com.example.apm_manager.models;

import jakarta.persistence.*;


@Entity(name = "Proposal")
@Table(name = "proposals")
public class Proposal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status")
    private String status;

    @Column(name = "term")
    private int term;

    @Column(name = "requested_amount")
    private int requestedAmount;

    @Column(name = "approved_amount")
    private int approvedAmount;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, referencedColumnName = "id")
    private Client client;

    public Proposal() {

    }

    public Proposal(String status, int term, int requestedAmount, int approvedAmount, Client client) {
        this.status = status;
        this.term = term;
        this.requestedAmount = requestedAmount;
        this.approvedAmount = approvedAmount;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int idProposal) {
        this.id = idProposal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public int getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(int approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "id=" + id + ", requested amount = " + requestedAmount + ", approved amount = " + approvedAmount + ", status " + status;
    }
}
