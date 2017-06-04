package com.rep.db.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "student")
public class Student extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false, foreignKey = @ForeignKey(name = "fk_student_tutor"))
    private Tutor sTutor;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "address")
    private String address;

    public Tutor getTutor() {
        return sTutor;
    }

    public void setTutor(Tutor tutor) {
        this.sTutor = tutor;
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
                "tutor=" + sTutor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @ManyToMany
    @JoinTable(name = "student_contact",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_contact"),
            foreignKey = @ForeignKey(name = "fk_student_contact"),
            inverseForeignKey = @ForeignKey(name = "fk_contact_student"))
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
