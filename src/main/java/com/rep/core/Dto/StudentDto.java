package com.rep.core.Dto;

import com.rep.db.domain.Contact;
import com.rep.db.domain.Student;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class StudentDto {
    private Long id;
    private Long idTutor;
    private String firstName;
    private String lastName;
    private String address;
    private Set<ContactDto> contacts;

    public static StudentDto of(Student student) {
        StudentDto result = new StudentDto();
        result.setId(student.getId());
        result.setIdTutor(student.getTutor().getId());
        result.setFirstName(student.getFirstName());
        result.setLastName(student.getLastName() == null ? "" : student.getLastName());
        result.setAddress(student.getAddress() == null ? "" : student.getAddress());
        Set<ContactDto> contactSet = new HashSet<>();
        if (!student.getContacts().isEmpty()) {
            ContactDto contactDto;
            for (Contact contact : student.getContacts()) {
                contactDto = ContactDto.of(contact);
                contactSet.add(contactDto);
            }
        }
        result.setContacts(contactSet);
        return result;
    }

    public StudentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactDto> contacts) {
        this.contacts = contacts;
    }
}
