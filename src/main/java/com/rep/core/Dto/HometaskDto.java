package com.rep.core.Dto;

import com.rep.db.domain.Hometask;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class HometaskDto {
    private Long id;
    private Long idLesson;
    private Date date;
    private String task;

    public static HometaskDto of(Hometask hometask) {
        HometaskDto result = new HometaskDto();
        result.setId(hometask.getId());
        result.setId(hometask.getLesson().getId());
        result.setDate(hometask.getDate());
        result.setTask(hometask.getTask());
        return result;
    }

    public HometaskDto() {
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

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
