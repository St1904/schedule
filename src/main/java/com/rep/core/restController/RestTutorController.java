package com.rep.core.restController;

import com.rep.core.Dto.TutorDto;
import com.rep.core.services.TutorService;
import com.rep.db.domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by St on 05.06.2017.
 */

@RestController
@RequestMapping("/rest/tutor")
public class RestTutorController {
    private TutorService tutorService;

    @Autowired
    RestTutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TutorDto>> listAllTutors() {
        List<TutorDto> contacts = TutorDto.of(tutorService.listAllTutors());
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TutorDto> getTutor(@PathVariable("id") long id) {
        Tutor tutor = tutorService.findById(id);
        if (tutor == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        TutorDto contactDto = TutorDto.of(tutor);
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tutor> createTutor(@RequestBody TutorDto tutorDto) {
        Tutor saved = tutorService.createTutor(tutorDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tutor> updateTutor(@PathVariable("id") long id, @RequestBody Tutor tutor) {
        Tutor current = tutorService.findById(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current.setName(tutor.getName());
        current.setAddress(tutor.getAddress());
        tutorService.updateTutor(current);
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTutor(@PathVariable("id") long id) {
        Tutor current = tutorService.findById(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tutorService.deleteTutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
