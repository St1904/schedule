package com.rep.core.Dto;

import com.rep.db.domain.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class ContactDto {
    private Long id;
    private Long idContactName;
    private String contactName;
    private String value;

    public static ContactDto of(Contact contact) {
        ContactDto result = new ContactDto();
        result.setId(contact.getId());
        result.setIdContactName(contact.getContactName().getId());
        result.setContactName(contact.getContactName().getName());
        result.setValue(contact.getValue());
        return result;
    }

    public static List<ContactDto> of(List<Contact> contacts) {
        List<ContactDto> result = new ArrayList<>();
        for (Contact contact : contacts) {
            result.add(ContactDto.of(contact));
        }
        return result;
    }

    public ContactDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdContactName() {
        return idContactName;
    }

    public void setIdContactName(Long idContactName) {
        this.idContactName = idContactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
