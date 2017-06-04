package com.rep.core.services;

import com.rep.core.Dto.EventDto;
import com.rep.core.special.DateTranslator;
import com.rep.db.domain.Event;
import com.rep.db.domain.RepeatCode;
import com.rep.db.domain.RepeatDay;
import com.rep.db.domain.Repeats;
import com.rep.db.repository.ChangesRepository;
import com.rep.db.repository.EventRepository;
import com.rep.db.repository.RepeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@Service
public class EventService {
    private final EventRepository   eventRepository;
    private final RepeatsRepository repeatsRepository;
    private final ChangesRepository changesRepository;

    @Autowired
    public EventService(EventRepository eventRepository, RepeatsRepository repeatsRepository, ChangesRepository changesRepository) {
        this.eventRepository = eventRepository;
        this.repeatsRepository = repeatsRepository;
        this.changesRepository = changesRepository;
    }

    public List<Event> listAllEvents() {
        return eventRepository.findAll();
    }
/*
    public List<Event> listEventsWithJoin() {
        return eventRepository.findEvents();
    }*/

    //TODO
    public List<EventDto> listEventsForWeekFromDate(Date date) {
        List<Event> events = eventRepository.findAllByTutor(1L);
        List<EventDto> result = new ArrayList<>();
        for (Event event : events) {
            Repeats repeats = event.getRepeats();
            if (event.getRepeats() == null) {
                if (event.getDateStart().getTime() >= date.getTime()
                        && event.getDateStart().getTime() <= DateTranslator.nextDate(date, 7).getTime()) {
                    result.add(EventDto.of(event, event.getDateStart()));
                }
            } else {
                if (repeats.getRepeatCode() == RepeatCode.DAILY) {
                    int limit = 0;
                    if (repeats.getDateFinal() == null && repeats.getAmount() == null) {
                        limit = 7;
                    } else if (repeats.getDateFinal() != null) {
                        limit = DateTranslator.daysBetweenDates(date, repeats.getDateFinal());
                    } else if (repeats.getAmount() != null) {
                        limit = DateTranslator.daysBetweenDates(date, DateTranslator.nextDate(event.getDateStart(), repeats.getAmount()));
                    }
                    for (int i = 0; i < limit; i++) {
                        result.add(EventDto.of(event, DateTranslator.nextDate(date, i)));
                    }
                } else if (repeats.getRepeatCode() == RepeatCode.YEARLY) {
                    //TODO
                } else if (repeats.getRepeatCode() == RepeatCode.WEEKLY) {
                    if (repeats.getDateFinal() == null && repeats.getAmount() == null) {
                        Set<RepeatDay> repeatDays = repeats.getRepeatDays();
                        if (repeatDays != null) {
                            for (RepeatDay repeatDay : repeatDays) {
                                result.add(EventDto.of(event, DateTranslator.getDateByWeekDay(date, repeatDay.getDay())));
                            }
                        }
                    } else if (repeats.getDateFinal() != null) {
                        //TODO
                    } else if (repeats.getAmount() != null) {
                        //TODO
                    }
                }
            }
        }


        return result;
    }
}
