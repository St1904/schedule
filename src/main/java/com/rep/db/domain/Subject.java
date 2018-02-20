package com.rep.db.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "subject",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_subject_id_tutor_name",
                columnNames = {"id_tutor", "name"}))
public class Subject extends BaseEntity {
    @Column(name = "id_tutor",
            nullable = false)
    private Long idTutor;

    @Column(name = "name",
            nullable = false,
            length = 100)
    private String name;

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

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
