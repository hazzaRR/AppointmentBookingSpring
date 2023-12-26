package com.hazr.AppointmentBooking.dto;

public class ClientDTO {

    private String firstname;

    private String surname;

    private String email;
    private String telephone;

    public ClientDTO(String firstname, String surname, String email, String telephone) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
