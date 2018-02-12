package com.rep.core.restControllers;

import com.rep.core.dto.EventDto;
import com.rep.core.services.EventChangeUtil;
import com.rep.core.services.EventService;
import com.rep.db.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rep.core.common.DateUtil.toDate;

/**
 * Created by St on 10.06.2017.
 */

@CrossOrigin
@RestController
public class RestEventChangeController {
    private final EventChangeUtil eventChangeUtil;
    private final EventService eventService;

    @Autowired
    public RestEventChangeController(EventChangeUtil eventChangeUtil, EventService eventService) {
        this.eventChangeUtil = eventChangeUtil;
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rest/eventchange", params = {"from", "to"})
    public ResponseEntity<List<EventDto>> listAllEvents(@RequestHeader("idTutor") Long idTutor,
                                                     @RequestParam(value = "from") String from,
                                                     @RequestParam(value = "to") String to) {
        List<Event> events = eventService.findBetweenDates(idTutor, from, to);
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<EventDto> dtos = eventChangeUtil.formatAllEvents(events, toDate(from), toDate(to));
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
