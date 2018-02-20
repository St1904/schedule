package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {
    @JsonIgnore
    @Column(name = "id_tutor",
            nullable = false)
    private Long idTutor;

    @Column(name = "first_name",
            length = 45,
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            length = 45)
    private String lastName;

    @Column(name = "address")
    private String address;

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "tutor=" + idTutor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "idStudent")
    private Set<Contact> contacts = new HashSet<Contact>();

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Student() {
    }
}
