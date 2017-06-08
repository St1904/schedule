package com.rep.core.Dto;

import com.rep.db.domain.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sbt-sokolova-ts on 15.02.2017.
 */
public class EventDto {
    private Long idTutor;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private Date timeStart;
    private Date timeEnd;
    private String comment;

    public static EventDto of(Event event) {
        EventDto result = new EventDto();
        result.setIdTutor(event.geteTutor().getId());
        result.setName(event.getName());
        result.setDateStart(event.getDateStart());
        result.setDateEnd(event.getDateEnd());
        result.setTimeStart(event.getTimeStart());
        result.setTimeEnd(event.getTimeEnd());
        result.setComment(event.getComment());
        return result;
    }

    public static List<EventDto> of (List<Event> list) {
        List<EventDto> result = new ArrayList<>();
        for (Event event : list) {
            result.add(EventDto.of(event));
        }
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
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
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", comment='" + comment + '\'' +
                '}';
    }
}
