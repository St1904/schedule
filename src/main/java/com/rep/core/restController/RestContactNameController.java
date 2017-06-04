package com.rep.core.restController;

import com.rep.core.services.ContactNameService;
import com.rep.db.domain.ContactName;
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
@RequestMapping("/rest/contactname")
public class RestContactNameController {
    private ContactNameService contactNameService;

    @Autowired
    public RestContactNameController(ContactNameService contactNameService) {
        this.contactNameService = contactNameService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ContactName>> listAllContactNames() {
        List<ContactName> contactNames = contactNameService.listAllContactNames();
        if (contactNames.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contactNames, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<ContactName> getContactName(@PathVariable("id") long id) {
        ContactName contactName = contactNameService.findById(id);
        if (contactName == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contactName, HttpStatus.OK);
    }

    //not sure it's necessary
    @RequestMapping(value = "/name/{name}")
    public ResponseEntity<ContactName> getContactNameByName(@PathVariable("name") String name) {
        ContactName contactName = contactNameService.findByName(name);
        if (contactName == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contactName, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createContactName(@RequestBody ContactName contactName, UriComponentsBuilder ucBuilder) {
        ContactName saved = contactNameService.createContactNameByName(contactName);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/contactname/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ContactName> updateContactName(@PathVariable("id") long id, @RequestBody ContactName contactName) {
        ContactName current = contactNameService.findById(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        current.setName(contactName.getName());
        contactNameService.updateContactName(current);
        return new ResponseEntity<>(current, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ContactName> deleteUser(@PathVariable("id") long id) {
        ContactName contactName = contactNameService.findById(id);
        if (contactName == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contactNameService.deleteContactName(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
