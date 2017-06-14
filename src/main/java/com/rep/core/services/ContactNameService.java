package com.rep.core.services;

import com.rep.db.domain.ContactName;
import com.rep.db.repository.ContactNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 14.02.2017.
 */

@Service
public class ContactNameService {
    private ContactNameRepository contactNameRepository;

    @Autowired
    public ContactNameService(ContactNameRepository contactNameRepository) {
        this.contactNameRepository = contactNameRepository;
    }

    public List<ContactName> listAllContactNames() {
        return contactNameRepository.findAll();
    }

    public List<ContactName> findAllContactNamesByIdTutor(Long idTutor) {
        return contactNameRepository.findByIdTutor(idTutor);
    }

    public ContactName findById(long id) {
        return contactNameRepository.findOne(id);
    }

    public ContactName findByName(String name) {
        return contactNameRepository.findByName(name);
    }

    public ContactName createContactName(ContactName contactName) {
        ContactName found = findByName(contactName.getName());
        if (found != null) return found;
        return contactNameRepository.saveAndFlush(contactName);
    }

    public boolean isContactNameExist(long id) {
        return contactNameRepository.exists(id);
    }

    public ContactName updateContactName(ContactName contactName) {
        return contactNameRepository.saveAndFlush(contactName);
    }

    public void deleteContactName(long id) {
        contactNameRepository.delete(id);
    }
}
