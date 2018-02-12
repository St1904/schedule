package com.rep.core.restControllers;

import com.rep.core.dto.EventDto;
import com.rep.core.services.EventService;
import com.rep.db.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/rest/event")
public class RestEventController {
    private final EventService eventService;

    @Autowired
    public RestEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<Event>> listAllEventsByIdTutor(@RequestHeader("idTutor") Long idTutor) {
        List<Event> events;
        events = eventService.findAllEventsByIdTutor(idTutor);
        if (events.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(events, OK);
    }

    @RequestMapping(method = GET, params = {"from", "to"})
    public ResponseEntity<List<Event>> listAllEvents(@RequestHeader("idTutor") Long idTutor,
                                                     @RequestParam(value = "from") String from,
                                                     @RequestParam(value = "to") String to) {
        List<Event> events;
        events = eventService.findBetweenDates(idTutor, from, to);
        if (events.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(events, OK);
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<EventDto> eventById(@RequestHeader("idTutor") Long idTutor,
                                           @PathVariable("id") Long id) {
        Event found = eventService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(EventDto.of(found, null), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> createEvent(@RequestHeader("idTutor") Long idTutor,
                                            @RequestBody Event event,
                                            UriComponentsBuilder ucBuilder) {
        event.setIdTutor(idTutor);
        Event saved = eventService.createEvent(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/event/{id}").buildAndExpand(saved.getIdTutor(), saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, value = "/{id}")
    public ResponseEntity<Event> updateEvent(@RequestHeader("idTutor") Long idTutor,
                                             @PathVariable("id") Long id,
                                             @RequestBody Event event) {
        Event found = eventService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        event.setIdTutor(idTutor);
        event.setId(id);
        found = eventService.updateEvent(event);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteEvent(@RequestHeader("idTutor") Long idTutor,
                                            @PathVariable("id") long id) {
        Event found = eventService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        eventService.deleteEventById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
