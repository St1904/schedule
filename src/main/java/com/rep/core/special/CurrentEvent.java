package com.rep.core.special;

import com.rep.db.domain.domain_old.Event;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class CurrentEvent {
    private Event event;
    private Date currentDate;

    public CurrentEvent() {
    }

    public CurrentEvent(Event event, Date currentDate) {
        this.event = event;
        this.currentDate = currentDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
