package com.rep.core.restControllers;

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

@CrossOrigin
@RestController
@RequestMapping("/rest/contactname")
public class RestContactNameController {
    private ContactNameService contactNameService;

    @Autowired
    public RestContactNameController(ContactNameService contactNameService) {
        this.contactNameService = contactNameService;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<ContactName>> findAllContactNames(@RequestHeader("idTutor") Long idTutor) {
        List<ContactName> contactNames = contactNameService.listAllContactNames();
        if (contactNames.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(contactNames, OK);
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<ContactName> getContactName(@RequestHeader("idTutor") Long idTutor,
                                                      @PathVariable("id") Long id) {
        ContactName found = contactNameService.findById(id);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> createContactName(@RequestHeader("idTutor") Long idTutor,
                                                  @RequestBody ContactName contactName,
                                                  UriComponentsBuilder ucBuilder) {
        ContactName saved = contactNameService.createContactName(contactName);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/contactname/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public ResponseEntity<ContactName> updateContactName(@RequestHeader("idTutor") Long idTutor,
                                                         @PathVariable("id") Long id,
                                                         @RequestBody ContactName contactName) {
        contactName.setId(id);
        ContactName found = contactNameService.updateContactName(contactName);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public ResponseEntity<ContactName> deleteContactName(@RequestHeader("idTutor") Long idTutor,
                                                         @PathVariable("id") Long id) {
        ContactName found = contactNameService.findById(id);
        contactNameService.deleteContactName(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
