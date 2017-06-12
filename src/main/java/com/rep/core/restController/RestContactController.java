package com.rep.core.restController;

import com.rep.core.services.ContactService;
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
//@RequestMapping("/rest/contact")
public class RestContactController {
    private final ContactService contactService;

    @Autowired
    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = GET, path = "/rest/student/{idStudent}/contact")
    public ResponseEntity<List<Contact>> findAllByIdStudent(@PathVariable("idStudent") Long idStudent) {
        List<Contact> contacts = contactService.findByIdStudent(idStudent);
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, OK);
    }

    @RequestMapping(method = GET, value = "/rest/student/{idStudent}/contact/{id}")
    public ResponseEntity<Contact> findById(@PathVariable("id") Long id,
                                            @PathVariable("idStudent") Long idStudent) {
        Contact contact = contactService.findById(id);
        if (contact == null || !contact.getIdStudent().equals(idStudent)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(contact, OK);
    }

    @RequestMapping(method = POST, path = "rest/student/{idStudent}/contact")
    public ResponseEntity<Void> createContact(@PathVariable("idStudent") Long idStudent,
                                              @RequestBody Contact contact,
                                              UriComponentsBuilder ucBuilder) {
        contact.setIdStudent(idStudent);
        Contact saved = contactService.createContact(contact);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder
                .path("/rest/student/{idStudent}/contact/{id}")
                .buildAndExpand(
                        saved.getIdStudent(),
                        saved.getId())
                .toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, path = "rest/student/{idStudent}/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("idStudent") Long idStudent,
                                                 @PathVariable("id") Long id,
                                                 @RequestBody Contact contact) {
        Contact found = contactService.findById(id);
        if (found == null || !found.getIdStudent().equals(idStudent)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        contact.setId(id);
        contact.setIdStudent(idStudent);
        found = contactService.updateContact(contact);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, path = "rest/student/{idStudent}/contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("idStudent") Long idStudent,
                                              @PathVariable("id") Long id) {
        Contact found = contactService.findById(id);
        if (found == null || !found.getIdStudent().equals(idStudent)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        contactService.deleteContact(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
