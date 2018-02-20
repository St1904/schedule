package com.rep.db.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "id_event", foreignKey = @ForeignKey(name = "fk_lesson_event"))
    private Event event;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_subject", foreignKey = @ForeignKey(name = "fk_lesson_subject"))
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "id_student", foreignKey = @ForeignKey(name = "fk_lesson_student"))
    private Student student;

    @OneToMany(mappedBy = "lesson")
    private Set<Journal> journals = new HashSet<>();

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "price=" + price +
                '}';
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Set<Journal> journals) {
        this.journals = journals;
    }

    public Lesson() {
    }
}
