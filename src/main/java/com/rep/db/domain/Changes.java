package com.rep.db.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "changes")
public class Changes extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_event", nullable = false, foreignKey = @ForeignKey(name = "fk_changes_of_event"))
    private com.rep.db.domain.Event event;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date", nullable = false)
    private Date date;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_start")
    private Date timeStart;

    @Temporal(value = TemporalType.TIME)
    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "canceled", nullable = false)
    private boolean isCanceled;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "Changes{" +
                "event=" + event +
                ", date=" + date +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", isDeleted=" + isDeleted +
                ", isCanceled=" + isCanceled +
                '}';
    }

    public Changes() {
    }
}
