package com.rep.core.dto;

import com.rep.core.common.DateUtil;
import com.rep.db.domain.Event;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 15.02.2017.
 */
public class EventDto {
    private Long id;
    private Long idTutor;
    private String name;
    private String currentDate;
    private Date timeStart;
    private Date timeEnd;
    private String repeatCode;
    private String dateStart;
    private String dateEnd;
    private String comment;
    private LessonDto lesson;

    public static EventDto of(Event event, Date currentDate) {
        EventDto result = new EventDto();
        result.setId(event.getId());
        result.setIdTutor(event.getIdTutor());
        result.setName(event.getName());
        result.setCurrentDate(DateUtil.toString(currentDate));
        result.setTimeStart(event.getTimeStart());
        result.setTimeEnd(event.getTimeEnd());
        result.setRepeatCode(event.getRepeatCode().toString());
        result.setDateStart(DateUtil.toString(event.getDateStart()));
        result.setDateEnd(DateUtil.toString(event.getDateEnd()));
        result.setComment(event.getComment());
        if (event.getLesson() != null) {
            result.setLesson(LessonDto.of(event.getLesson()));
        }
        return result;
    }
/*
    public static List<EventDto> of (List<Event> list) {
        List<EventDto> result = new ArrayList<>();
        for (Event event : list) {
            result.add(EventDto.of(event));
        }
        return result;
    }*/

    public EventDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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

    public String getRepeatCode() {
        return repeatCode;
    }

    public void setRepeatCode(String repeatCode) {
        this.repeatCode = repeatCode;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LessonDto getLesson() {
        return lesson;
    }

    public void setLesson(LessonDto lesson) {
        this.lesson = lesson;
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
