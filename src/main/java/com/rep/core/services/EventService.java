package com.rep.core.services;

import com.rep.db.domain.Event;
import com.rep.db.domain.RepeatCode;
import com.rep.db.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> findAllEventsByIdTutor(Long idTutor) {
        return eventRepository.findAllByIdTutor(idTutor);
    }

    public List<Event> findBetweenDates(Long idTutor, String from, String to) {
        List<Event> result = new ArrayList<>();
        result.addAll(eventRepository.findAllDailyBetweenDates(idTutor,
                RepeatCode.DAILY.name(),
                from,
                to));


        return result;
    }
}
