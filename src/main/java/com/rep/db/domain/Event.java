package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by St on 05.06.2017.
 */

@Entity
@Table(name = "event")
public class Event extends BaseEntity {
    @JsonIgnore
//    @ManyToOne
    @Column(name = "id_tutor", nullable = false)
/*    @JoinColumn(name = "id_tutor",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_event_of_tutor"))*/
    private Long idTutor;

    @Column(name = "name",
            nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "code",
            columnDefinition = "enum('DAILY', 'WEEKLY', 'YEARLY', 'MONTHLY', 'NEVER')",
            nullable = false)
    private RepeatCode repeatCode;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_start", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateStart;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateEnd;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "Europe/Moscow")
    private Date timeEnd;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_start")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "Europe/Moscow")
    private Date timeStart;

    @Column(name = "comment")
    private String comment;

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

    public RepeatCode getRepeatCode() {
        return repeatCode;
    }

    public void setRepeatCode(RepeatCode repeatCode) {
        this.repeatCode = repeatCode;
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
}
