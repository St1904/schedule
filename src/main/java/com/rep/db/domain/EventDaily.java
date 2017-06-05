package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by St on 05.06.2017.
 */

@Entity
@Table(name = "event_daily")
public class EventDaily extends BaseEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false, foreignKey = @ForeignKey(name = "fk_event_daily_of_tutor"))
    private Tutor eTutor;

    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_start")
    private Date timeStart;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "comment")
    private String comment;

    public Tutor geteTutor() {
        return eTutor;
    }

    public void seteTutor(Tutor eTutor) {
        this.eTutor = eTutor;
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
}
