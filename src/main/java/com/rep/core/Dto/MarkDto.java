package com.rep.core.Dto;

import com.rep.db.domain.Mark;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class MarkDto {
    private Long id;
    private Long idLesson;
    private Date date;
    private String markLesson;
    private String markHometask;

    public static MarkDto of(Mark mark) {
        MarkDto result = new MarkDto();
        result.setId(mark.getId());
        result.setDate(mark.getDate());
        result.setIdLesson(mark.getLesson().getId());
        result.setMarkLesson(mark.getMarkLesson());
        result.setMarkHometask(mark.getMarkHometask());
        return result;
    }

    public MarkDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(Long idLesson) {
        this.idLesson = idLesson;
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
}
