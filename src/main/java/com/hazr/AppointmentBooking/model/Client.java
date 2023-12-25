package com.hazr.AppointmentBooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", length = 40)
    private String firstname;

    @Column(name = "surname", length = 40)
    private String surname;

    @Column(unique = true, nullable = false, length = 40)
    private String email;

    @Column(length = 20)
    private String telephone;

    protected Client() {
    }

    public Client(Long id, String firstname, String surname, String email, String telephone) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public Client(String firstname, String surname, String email, String telephone) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
