package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {
    @JsonIgnore
    @Column(name = "id_student",
            nullable = false)
    private Long idStudent;

    @ManyToOne
    @JoinColumn(name = "id_contactName",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_contact_contactName"))
    private ContactName contactName;

    @Column(name = "value",
            nullable = false,
            length = 100)
    private String value;

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

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
