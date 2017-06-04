package com.rep.core.Dto;

import com.rep.db.domain.Event;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 15.02.2017.
 */
public class EventDto {
    private Long idTutor;
    private String name;
    private Date currentDate;
    private Date timeStart;
    private Date timeEnd;
    private String comment;

    public static EventDto of(Event event, Date currentDate) {
        EventDto result = new EventDto();
        result.setIdTutor(event.geteTutor().getId());
        result.setName(event.getName());
        result.setCurrentDate(currentDate);
        result.setTimeStart(event.getTimeStart());
        result.setTimeEnd(event.getTimeEnd());
        result.setComment(event.getComment());
        return result;
    }

    public EventDto() {
    }

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

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date date) {
        this.currentDate = date;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "idTutor=" + idTutor +
                ", name='" + name + '\'' +
                ", currentDate=" + currentDate +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", comment='" + comment + '\'' +
                '}';
    }
}
