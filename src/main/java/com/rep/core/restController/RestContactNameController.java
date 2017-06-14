package com.rep.core.restController;

import com.rep.core.services.ContactNameService;
import com.rep.db.domain.ContactName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@RestController
//@RequestMapping("/rest/contactname")
public class RestContactNameController {
    private ContactNameService contactNameService;

    @Autowired
    public RestContactNameController(ContactNameService contactNameService) {
        this.contactNameService = contactNameService;
    }

    @RequestMapping(method = GET, path = "/rest/tutor/{idTutor}/contactname")
    public ResponseEntity<List<ContactName>> findAllContactNames(@PathVariable("idTutor") Long idTutor) {
        List<ContactName> contactNames = contactNameService.findByIdTutor(idTutor);
        if (contactNames.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(contactNames, OK);
    }

    @RequestMapping(method = GET, path = "/rest/tutor/{idTutor}/contactname/{id}")
    public ResponseEntity<ContactName> getContactName(@PathVariable("idTutor") Long idTutor,
                                                      @PathVariable("id") Long id) {
        ContactName found = contactNameService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(found, OK);
    }

    //not sure it's necessary
    @RequestMapping(method = GET, path = "/rest/tutor/{idTutor}/contactname", params = "name")
    public ResponseEntity<ContactName> getContactNameByName(@PathVariable("idTutor") Long idTutor,
                                                            @RequestParam("name") String name) {
        ContactName found = contactNameService.findByName(name);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = POST, path = "/rest/tutor/{idTutor}/contactname")
    public ResponseEntity<Void> createContactName(@PathVariable("idTutor") Long idTutor,
                                                  @RequestBody ContactName contactName,
                                                  UriComponentsBuilder ucBuilder) {
        contactName.setIdTutor(idTutor);
        ContactName saved = contactNameService.createContactName(contactName);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/contactname/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, path = "/rest/tutor/{idTutor}/contactname/{id}")
    public ResponseEntity<ContactName> updateContactName(@PathVariable("idTutor") Long idTutor,
                                                         @PathVariable("id") Long id,
                                                         @RequestBody ContactName contactName) {
        ContactName found = contactNameService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        contactName.setIdTutor(idTutor);
        contactName.setId(id);
        found = contactNameService.updateContactName(contactName);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, path = "/rest/tutor/{idTutor}/contactname/{id}")
    public ResponseEntity<ContactName> deleteContactName(@PathVariable("idTutor") Long idTutor,
                                                         @PathVariable("id") Long id) {
        ContactName found = contactNameService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        contactNameService.deleteContactName(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
