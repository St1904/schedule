package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "tutor", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "address"})})
public class Tutor extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @JsonIgnore
    @OneToMany(mappedBy = "sTutor")
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    //TODO заменить на many-to-many
//    @JsonIgnore
//    @OneToMany(mappedBy = "eTutor")
//    private Set<Event> events = new HashSet<>();
//
//    public Set<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(Set<Event> events) {
//        this.events = events;
//    }
//
//    public Tutor() {
//    }
}
