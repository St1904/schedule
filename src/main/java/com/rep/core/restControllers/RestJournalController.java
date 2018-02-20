package com.rep.core.restControllers;

import com.rep.core.dto.JournalDto;
import com.rep.core.services.JournalService;
import com.rep.core.common.DateUtil;
import com.rep.db.domain.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by St on 07.01.2018.
 */

@CrossOrigin
@RestController
@RequestMapping(path = "/rest/journal")
public class RestJournalController {
    private JournalService journalService;

    @Autowired
    public RestJournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(method = GET, path = "/idLesson/{idLesson}", params = {"date"})
    public ResponseEntity<JournalDto> getByLessonAndDate(@RequestHeader("idTutor") Long idTutor,
                                                         @PathVariable("idLesson") Long idLesson,
                                                         @RequestParam(value = "date") String date) {
        Journal found = journalService.find(idTutor, idLesson, DateUtil.toDate(date));
        if (found == null) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(JournalDto.of(found), OK);
    }

    @RequestMapping(method = GET, params = {"limit", "offset"})
    public ResponseEntity<List<JournalDto>> getJournals(@RequestHeader("idTutor") Long idTutor,
                                                        @RequestParam(value = "limit") int limit,
                                                        @RequestParam(value = "offset") int offset) {
        List<Journal> found = journalService.findPageable(idTutor, limit, offset);
        if (found == null || found.isEmpty()) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(JournalDto.of(found), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> createContactName(@RequestHeader("idTutor") Long idTutor,
                                                  @RequestBody Journal journal,
                                                  UriComponentsBuilder ucBuilder) {
        Journal saved = journalService.create(journal);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/journal/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<JournalDto> getJournalById(@RequestHeader("idTutor") Long idTutor,
                                                     @PathVariable("id") Long id) {
        Journal found = journalService.findById(id);
        if (found == null || !idTutor.equals(found.getLesson().getEvent().getIdTutor())) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(JournalDto.of(found), OK);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public ResponseEntity<JournalDto> updateJournal(@RequestHeader("idTutor") Long idTutor,
                                                    @PathVariable("id") Long id,
                                                    @RequestBody Journal journal) {
        Journal found = journalService.findById(id);
        if (found == null || !idTutor.equals(found.getLesson().getEvent().getIdTutor())) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        journal.setId(id);
        journal.setDate(found.getDate());
        journal.setLesson(found.getLesson());
        Journal saved = journalService.updateJournal(journal);
        return new ResponseEntity<>(JournalDto.of(saved), OK);
    }
}
