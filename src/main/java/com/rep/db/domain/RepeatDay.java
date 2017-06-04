package com.rep.db.domain;

import javax.persistence.*;

/**
 * Created by sbt-sokolova-ts on 07.02.2017.
 */

@Entity
@Table(name = "repeat_day")
public class RepeatDay extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "id_repeats", foreignKey = @ForeignKey(name = "fk_repeat_day_repeats"), nullable = false)
    private Repeats repeats;

    @Column(name = "day")
    private byte day;

    public Repeats getRepeats() {
        return repeats;
    }

    public void setRepeats(Repeats repeats) {
        this.repeats = repeats;
    }

    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "RepeatDay{" +
//                "repeats=" + repeats +
                ", day=" + day +
                '}';
    }

    public RepeatDay() {
    }
}
