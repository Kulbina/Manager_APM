package com.example.apm_manager.models;

import jakarta.persistence.*;

@Entity(name = "Client")
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "family_status")
    private String familyStatus;
    @Column(name = "place_of_residence")
    private String placeOfResidence;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "work_period")
    private String workPeriod;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "name_of_the_organization")
    private String nameOfTheOrganization;
    @Column(name = "passport_series")
    private Integer passportSeries;
    @Column(name = "passport_number")
    private Integer passportNumber;

    public Client() {

    }

    public Client(
            String firstName,
            String secondName,
            String lastName,
            String familyStatus,
            String placeOfResidence,
            long phoneNumber,
            String workPeriod,
            String jobTitle,
            String nameOfTheOrganization,
            Integer passportSeries,
            Integer passportNumber
    ) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.familyStatus = familyStatus;
        this.placeOfResidence = placeOfResidence;
        this.phoneNumber = phoneNumber;
        this.workPeriod = workPeriod;
        this.jobTitle = jobTitle;
        this.nameOfTheOrganization = nameOfTheOrganization;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setCountry(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;

    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(String workPeriod) {
        this.workPeriod = workPeriod;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getNameOfTheOrganization() {
        return nameOfTheOrganization;
    }

    public void setNameOfTheOrganization(String nameOfTheOrganization) {
        this.nameOfTheOrganization = nameOfTheOrganization;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(Integer passportSeries) {
        this.passportSeries = passportSeries;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name= " + firstName + ", " + secondName + ", " + lastName + ", " + phoneNumber;
    }
}
