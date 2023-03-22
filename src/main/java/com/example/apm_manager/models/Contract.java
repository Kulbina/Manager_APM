package com.example.apm_manager.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_of_singing")
    private String dateOfSigning;
    @Column(name = "status")
    private String status;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "id_proposal", nullable = false, referencedColumnName = "id")
    private Proposal proposal;

    public Contract() {

    }

    public Contract(String dateOfSigning, String status, Proposal proposal) {
        this.dateOfSigning = dateOfSigning;
        this.status = status;
        this.proposal = proposal;
    }

    public int getId() {
        return id;
    }

    public void setId(int idContract) {
        this.id = idContract;
    }

    public String getDateOfSigning() {
        return dateOfSigning;
    }

    public void setDateOfSigning(String dateOfSigning) {
        this.dateOfSigning = dateOfSigning;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + id + ", дата подписания= " + dateOfSigning + ", status = " + status;
    }
}
