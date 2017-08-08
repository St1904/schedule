package com.rep.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "contact_name")
public class ContactName extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ContactName{" +
                "name='" + name + '\'' +
                '}';
    }

    public ContactName() {
    }

    public ContactName(String name) {
        this.name = name;
    }
}
