package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @Column(name = "date",
            nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern="yyyy-MM-dd")
    private Date date;

    @Column(name = "hometask")
    private String hometask;

    @Column(name = "lesson_mark")
    private String lessonMark;

    @Column(name = "hometask_mark")
    private String hometaskMark;

    @Column(name = "comment")
    private String comment;

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

    public String getHometask() {
        return hometask;
    }

    public void setHometask(String hometask) {
        this.hometask = hometask;
    }

    public String getLessonMark() {
        return lessonMark;
    }

    public void setLessonMark(String lessonMark) {
        this.lessonMark = lessonMark;
    }

    public String getHometaskMark() {
        return hometaskMark;
    }

    public void setHometaskMark(String hometaskMark) {
        this.hometaskMark = hometaskMark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "theme=" + theme +
                ", lesson=" + lesson +
                ", date=" + date +
                ", hometask='" + hometask + '\'' +
                ", lessonMark='" + lessonMark + '\'' +
                ", hometaskMark='" + hometaskMark + '\'' +
                '}';
    }

    public Journal() {
    }
}
