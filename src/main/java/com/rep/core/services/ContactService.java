package com.rep.core.services;

import com.rep.db.domain.Contact;
import com.rep.db.domain.ContactName;
import com.rep.db.repository.ContactNameRepository;
import com.rep.db.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 13.02.2017.
 */

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactNameRepository contactNameRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, ContactNameRepository contactNameRepository) {
        this.contactRepository = contactRepository;
        this.contactNameRepository = contactNameRepository;
    }

    //    public List<Contact> findAllContacts() {
//        return contactRepository.findAll();
//    }

    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    public List<Contact> findByIdStudent(Long idStudent) {
        return contactRepository.findByIdStudent(idStudent);
    }

    public Contact createContact(Contact contact) {
        ContactName contactName = contact.getContactName();
        if (contactNameRepository.findByName(contactName.getName()) == null) {
            contact.setContactName(contactNameRepository.saveAndFlush(contactName));
        }
        return contactRepository.saveAndFlush(contact);
    }

    public Contact updateContact(Contact contact) {
        ContactName contactName = contact.getContactName();
        if (contactNameRepository.findByName(contactName.getName()) == null) {
            contact.setContactName(contactNameRepository.saveAndFlush(contactName));
        }
        return contactRepository.saveAndFlush(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }

/*    public ContactDto createContact(ContactDto contactDto) {
        ContactName contactName = new ContactName();
        if (contactDto.getIdContactName() == null) {
            contactName = contactNameRepository.saveAndFlush(new ContactName(contactDto.getContactName()));
        } else {
            contactName.setId(contactDto.getIdContactName());
            contactName.setName(contactDto.getContactName());
        }

        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setValue(contactDto.getValue());
        contact.setContactName(contactName);

        Contact saved = contactRepository.saveAndFlush(contact);
        return ContactDto.of(saved);
    }*/
}
