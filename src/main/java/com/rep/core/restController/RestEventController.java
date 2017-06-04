package com.rep.core.restController;

import com.rep.core.services.EventService;
import com.rep.db.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    //TODO change to dto
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listAllEvents() {
        List<Event> events = eventService.listAllEvents();
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
