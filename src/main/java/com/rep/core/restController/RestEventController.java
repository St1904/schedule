package com.rep.core.restController;

import com.rep.core.services.EventService;
import com.rep.db.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@RestController
@RequestMapping("/rest/event")
public class RestEventController {
    private final EventService eventService;

    @Autowired
    public RestEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tutor/{idTutor}")
    public ResponseEntity<List<Event>> listAllEventsByIdTutor(@PathVariable("idTutor") Long idTutor) {
        List<Event> events;
        events = eventService.findAllEventsByIdTutor(idTutor);
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tutor/{idTutor}", params = {"from", "to"})
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

/*    @RequestMapping(value = "/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listEventsFromDate() {
        List<Event> events = eventService.listEventsFromDate();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }*/
}
