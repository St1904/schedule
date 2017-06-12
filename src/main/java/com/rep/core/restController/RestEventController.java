package com.rep.core.restController;

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

@RestController
public class RestEventController {
    private final EventService eventService;

    @Autowired
    public RestEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = GET, path = "/rest/tutor/{idTutor}/event")
    public ResponseEntity<List<Event>> listAllEventsByIdTutor(@PathVariable("idTutor") Long idTutor) {
        List<Event> events;
        events = eventService.findAllEventsByIdTutor(idTutor);
        if (events.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(events, OK);
    }

    @RequestMapping(method = GET, path = "/rest/tutor/{idTutor}/event", params = {"from", "to"})
    public ResponseEntity<List<Event>> listAllEvents(@PathVariable("idTutor") Long idTutor,
                                                        @RequestParam(value = "from") String from,
                                                        @RequestParam(value = "to") String to) {
        List<Event> events;
        events = eventService.findBetweenDates(idTutor, from, to);
        if (events.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(events, OK);
    }

    @RequestMapping(method = GET, path = "/rest/tutor/{idTutor}/event/{id}")
    public ResponseEntity<Event> eventById(@PathVariable("idTutor") Long idTutor,
                                                     @PathVariable("id") Long id) {
        Event found = eventService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = POST, path = "/rest/tutor/{idTutor}/event")
    public ResponseEntity<Void> createEvent(@PathVariable("idTutor") Long idTutor,
                                            @RequestBody Event event,
                                            UriComponentsBuilder ucBuilder) {
        event.setIdTutor(idTutor);
        Event saved = eventService.createEvent(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/tutor/{idTutor}/event/{id}").buildAndExpand(saved.getIdTutor(), saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, value = "/rest/tutor/{idTutor}/event/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("idTutor") Long idTutor,
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

    @RequestMapping(method = DELETE, value = "/rest/tutor/{idTutor}/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("idTutor") Long idTutor,
                                             @PathVariable("id") long id) {
        Event found = eventService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        eventService.deleteEventById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
