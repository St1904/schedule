package com.rep.core.restController;

import com.rep.core.Dto.ContactDto;
import com.rep.core.services.ContactService;
import com.rep.db.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 13.02.2017.
 */

@RestController
@RequestMapping("/rest/contact")
public class RestContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> listAllContactNames() {
        List<ContactDto> contacts = ContactDto.of(contactService.listAllContacts());
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContactDto> getContactName(@PathVariable("id") long id) {
        Contact contact = contactService.findOne(id);
        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ContactDto contactDto = ContactDto.of(contact);
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createContact(@RequestBody ContactDto contactDto, UriComponentsBuilder ucBuilder) {
        ContactDto saved = contactService.createContact(contactDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/contact/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //TODO PUT DELETE

    /*@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Contact getOne() {
        return contactService.findOne(7L);
    }*/
}
