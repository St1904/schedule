package com.rep.core.restController;

import com.rep.core.Dto.JournalDto;
import com.rep.core.services.JournalService;
import com.rep.core.special.DateUtil;
import com.rep.db.domain.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(method = GET)
    public ResponseEntity<JournalDto> getByLessonAndDate(@RequestHeader("idTutor") Long idTutor,
                                                         @RequestParam(value = "idLesson") Long idLesson,
                                                         @RequestParam(value = "date") String date) {
        Journal found = journalService.find(idTutor, idLesson, DateUtil.toDate(date));
        if (found == null) {
            return new ResponseEntity<>(NO_CONTENT);
        }
        return new ResponseEntity<>(JournalDto.of(found), OK);
    }
}
