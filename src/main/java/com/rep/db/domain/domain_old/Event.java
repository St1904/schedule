package com.rep.db.domain.domain_old;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rep.db.domain.BaseEntity;
import com.rep.db.domain.Tutor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

//@Entity
//@Table(name = "event")
public class Event extends BaseEntity {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false, foreignKey = @ForeignKey(name = "fk_event_of_tutor"))
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

/*    @Override
    public String toString() {
        return "Event{" +
                "eTutor=" + eTutor +
                ", name='" + name + '\'' +
                ", dateStart=" + dateStart +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", comment='" + comment + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Event{" +
                "eTutor=" + eTutor +
                ", name='" + name + '\'' +
                ", dateStart=" + dateStart +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", comment='" + comment + '\'' +
                ", repeats=" + (eRepeats == null ? null : eRepeats.getId()) +
                '}';
    }

    public Event() {
    }

    @OneToOne(mappedBy = "rEvent")
    @JoinColumn(name = "id_repeats")
    private Repeats eRepeats;

    public Repeats getRepeats() {
        return eRepeats;
    }

    public void setRepeats(Repeats repeats) {
        this.eRepeats = repeats;
    }
}
