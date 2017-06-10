package com.rep.core.restController;

import com.rep.core.services.EventService;
import com.rep.db.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@RestController
//@RequestMapping("/rest/event")
public class RestEventController {
    private final EventService eventService;

    @Autowired
    public RestEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rest/tutor/{idTutor}/event")
    public ResponseEntity<List<Event>> listAllEventsByIdTutor(@PathVariable("idTutor") Long idTutor) {
        List<Event> events;
        events = eventService.findAllEventsByIdTutor(idTutor);
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rest/tutor/{idTutor}/event", params = {"from", "to"})
    public ResponseEntity<List<Event>> listAllEvents(@PathVariable("idTutor") Long idTutor,
                                                        @RequestParam(value = "from") String from,
                                                        @RequestParam(value = "to") String to) {
        List<Event> events;
        events = eventService.findBetweenDates(idTutor, from, to);
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/rest/tutor/{idTutor}/event")
    public ResponseEntity<Void> createEvene(@PathVariable("idTutor") Long idTutor,
                                            @RequestBody Event event,
                                            UriComponentsBuilder ucBuilder) {
        event.setIdTutor(idTutor);
        Event saved = eventService.createEvent(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/tutor/{idTutor}/event/{id}").buildAndExpand(saved.getIdTutor(), saved.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
