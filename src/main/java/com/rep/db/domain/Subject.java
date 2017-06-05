package com.rep.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "subject")
public class Subject extends BaseEntity {
    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }

    public Subject() {
    }
}
