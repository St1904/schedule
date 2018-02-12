package com.rep.core.dto;

import com.rep.db.domain.ContactName;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class ContactNameDto {
    private Long id;
    private String name;

    public static ContactNameDto of(ContactName contactName) {
        ContactNameDto result = new ContactNameDto();
        result.setId(contactName.getId());
        result.setName(contactName.getName());
        return result;
    }

    public ContactNameDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
