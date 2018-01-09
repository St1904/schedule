package com.rep.db.domain.domain_old;

import com.rep.db.domain.BaseEntity;
import com.rep.db.domain.Lesson;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

//@Entity
//@Table(name = "hometask")
public class Hometask extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_lesson", nullable = false, foreignKey = @ForeignKey(name = "fk_hometask_lesson"))
    private Lesson lesson;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "task", nullable = false)
    private String task;

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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Hometask{" +
                "lesson=" + lesson +
                ", date=" + date +
                ", task='" + task + '\'' +
                '}';
    }

    public Hometask() {
    }
}
