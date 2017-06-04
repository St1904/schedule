package com.rep.db.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "lesson")
public class Lesson extends BaseEntity {
    @Column(name = "price")
    private BigDecimal price;

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

    @OneToOne
    @JoinColumn(name = "id_event", foreignKey = @ForeignKey(name = "fk_lesson_event"))
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @ManyToOne
    @JoinColumn(name = "id_subject", foreignKey = @ForeignKey(name = "fk_lesson_subject"))
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToMany
    @JoinTable(name = "lesson_student",
            joinColumns = @JoinColumn(name = "id_lesson"),
            inverseJoinColumns = @JoinColumn(name = "id_student"),
            foreignKey = @ForeignKey(name = "fk_lesson_student"),
            inverseForeignKey = @ForeignKey(name = "fk_student_lesson"))
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Lesson() {
    }
}
