package com.rep.core.restControllers;

import com.rep.core.services.StudentContactService;
import com.rep.db.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sbt-sokolova-ts on 13.02.2017.
 */

@RestController
@RequestMapping("/rest/student/{idStudent}/contact")
public class RestContactController {
    private final StudentContactService studentContactService;

    @Autowired
    public RestContactController(StudentContactService contactService) {
        this.studentContactService = contactService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<Contact>> findAllByIdStudent(@PathVariable("idStudent") Long idStudent) {
        List<Contact> contacts = studentContactService.findContactsByIdStudent(idStudent);
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, OK);
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<Contact> findById(@PathVariable("id") Long id,
                                            @PathVariable("idStudent") Long idStudent) {
        Contact contact = studentContactService.findContactById(id);
        if (contact == null || !contact.getIdStudent().equals(idStudent)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(contact, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> createContact(@PathVariable("idStudent") Long idStudent,
                                              @RequestBody Contact contact,
                                              UriComponentsBuilder ucBuilder) {
        contact.setIdStudent(idStudent);
        Contact saved = studentContactService.createOrUpdateContact(contact);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder
                .path("/rest/student/{idStudent}/contact/{id}")
                .buildAndExpand(
                        saved.getIdStudent(),
                        saved.getId())
                .toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("idStudent") Long idStudent,
                                                 @PathVariable("id") Long id,
                                                 @RequestBody Contact contact) {
        Contact found = studentContactService.findContactById(id);
        if (found == null || !found.getIdStudent().equals(idStudent)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        contact.setId(id);
        contact.setIdStudent(idStudent);
        found = studentContactService.createOrUpdateContact(contact);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("idStudent") Long idStudent,
                                              @PathVariable("id") Long id) {
        Contact found = studentContactService.findContactById(id);
        if (found == null || !found.getIdStudent().equals(idStudent)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        studentContactService.deleteContact(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
