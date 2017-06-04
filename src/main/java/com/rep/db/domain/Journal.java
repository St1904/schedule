package com.rep.db.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "journal")
public class Journal extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_theme", foreignKey = @ForeignKey(name = "fk_journal_theme"))
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

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

    @Override
    public String toString() {
        return "Journal{" +
                "theme=" + theme +
                ", lesson=" + lesson +
                ", date=" + date +
                '}';
    }

    public Journal() {
    }
}
