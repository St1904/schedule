package com.rep.db.domain;

import javax.persistence.*;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_contactName", nullable = false, foreignKey = @ForeignKey(name = "fk_contact_contactName"))
    private ContactName contactName;

    @Column(name = "value", length = 100, nullable = false)
    private String value;

    public ContactName getContactName() {
        return contactName;
    }

    public void setContactName(ContactName contactName) {
        this.contactName = contactName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactName=" + contactName +
                ", value='" + value + '\'' +
                '}';
    }

    public Contact() {
    }
}
