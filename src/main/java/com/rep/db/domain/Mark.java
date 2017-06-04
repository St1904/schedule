package com.rep.db.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "mark")
public class Mark extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_lesson", nullable = false, foreignKey = @ForeignKey(name = "fk_mark_lesson"))
    private Lesson lesson;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "mark_lesson")
    private String markLesson;

    @Column(name = "mark_hometask")
    private String markHometask;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMarkLesson() {
        return markLesson;
    }

    public void setMarkLesson(String markLesson) {
        this.markLesson = markLesson;
    }

    public String getMarkHometask() {
        return markHometask;
    }

    public void setMarkHometask(String markHometask) {
        this.markHometask = markHometask;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "lesson=" + lesson +
                ", date=" + date +
                ", markLesson='" + markLesson + '\'' +
                ", markHometask='" + markHometask + '\'' +
                '}';
    }

    public Mark() {
    }
}
