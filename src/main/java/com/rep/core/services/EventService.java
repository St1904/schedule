package com.rep.core.services;

import com.rep.db.domain.Event;
import com.rep.db.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAllEventsByIdTutor(Long idTutor) {
        return eventRepository.findAllByIdTutor(idTutor);
    }

    public List<Event> findBetweenDates(Long idTutor, String from, String to) {
        List<Event> result = new ArrayList<>();
        result.addAll(eventRepository.findAllEventsBetweenDates(idTutor,
                from,
                to));
        return result;
    }

    public Event createEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    public Event findById(Long id) {
        return eventRepository.findOne(id);
    }

    public Event updateEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }

    public void deleteEventById(Long id) {
        eventRepository.delete(id);
    }
}
