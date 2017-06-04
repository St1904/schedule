package com.rep.db.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "repeats")
public class Repeats extends BaseEntity {
//    @JsonIgnoreProperties("rEvent")
    @OneToOne
    @JoinColumn(name = "id_event", nullable = false, foreignKey = @ForeignKey(name = "fk_repeats_event"))
    private Event rEvent;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_final")
    private Date dateFinal;

    @Column(name = "amount")
    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "code", columnDefinition = "enum('DAILY', 'WEEKLY', 'YEARLY')", nullable = false)
    private RepeatCode repeatCode;

    @OneToMany(mappedBy = "repeats", fetch = FetchType.EAGER)
    private Set<RepeatDay> repeatDays = new HashSet<>();

    public Event getrEvent() {
        return rEvent;
    }

    public void setrEvent(Event rEvent) {
        this.rEvent = rEvent;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public RepeatCode getRepeatCode() {
        return repeatCode;
    }

    public void setRepeatCode(RepeatCode repeatCode) {
        this.repeatCode = repeatCode;
    }

    public Set<RepeatDay> getRepeatDays() {
        return repeatDays;
    }

    public void setRepeatDays(Set<RepeatDay> repeatDays) {
        this.repeatDays = repeatDays;
    }

    @Override
    public String toString() {
        return "Repeats{" +
                "event=" + rEvent +
                ", dateFinal=" + dateFinal +
                ", amount=" + amount +
//                ", repeatCode=" + repeatCode +
//                ", repeatDays=" + repeatDays +
                '}';
    }

    public Repeats() {
    }
}
