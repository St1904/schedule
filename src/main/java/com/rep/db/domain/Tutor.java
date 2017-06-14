package com.rep.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "tutor",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_tutor_name_address",
                columnNames = {"name", "address"}))
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
/*

    @JsonIgnore
    @OneToMany(mappedBy = "idTutor")
    private Set<Student> students = new HashSet<>();
*/
/*
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }*/
}
