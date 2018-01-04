package com.rep.core.services;

import com.rep.db.domain.Contact;
import com.rep.db.domain.ContactName;
import com.rep.db.domain.Student;
import com.rep.db.repository.ContactNameRepository;
import com.rep.db.repository.ContactRepository;
import com.rep.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by St on 10.06.2017.
 */
@Service
public class StudentContactService {
    private final StudentRepository studentRepository;
    private final ContactRepository contactRepository;
    private final ContactNameRepository contactNameRepository;

    @Autowired
    public StudentContactService(StudentRepository studentRepository, ContactRepository contactRepository, ContactNameRepository contactNameRepository) {
        this.studentRepository = studentRepository;
        this.contactRepository = contactRepository;
        this.contactNameRepository = contactNameRepository;
    }

    public Contact findContactById(Long id) {
        return contactRepository.findOne(id);
    }

    public List<Contact> findContactsByIdStudent(Long idStudent) {
        return contactRepository.findByIdStudent(idStudent);
    }

    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }

    @Transactional
    public Contact createOrUpdateContact(Contact contact) {
        ContactName contactName = contact.getContactName();
        ContactName found = contactNameRepository.findByName(contactName.getName());
        if (found == null) {
            found = contactNameRepository.saveAndFlush(contactName);
        }
        contact.setContactName(found);
        return contactRepository.saveAndFlush(contact);
    }

    @Transactional
    public Student createOrUpdateStudent(Student student) {
        Student saved = studentRepository.saveAndFlush(student);
        System.out.println(student.getContacts());
        for (Contact contact : student.getContacts()) {
            contact.setIdStudent(saved.getId());
            ContactName savedContactName = contactNameRepository.findByName(contact.getContactName().getName());
            if (savedContactName == null) {
                savedContactName = contactNameRepository.saveAndFlush(contact.getContactName());
            }
            contact.setContactName(savedContactName);
            contactRepository.saveAndFlush(contact);
        }

        //Удаляем старые ненужные контакты по id
        List<Contact> oldContacts = contactRepository.findByIdStudent(student.getId());
        for (Contact oldContact : oldContacts) {
            boolean contains = false;
            for (Contact newContact : student.getContacts()) {
                if (oldContact.getId().equals(newContact.getId())) {
                    contains = true;
                }
            }
            if (!contains) {
                contactRepository.deleteById(oldContact.getId());
            }
        }

        return saved;
    }

    public Student findStudentById(Long id) {
        return studentRepository.findOne(id);
    }

    /*public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }*/

    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findStudentsByIdTutor(Long idTutor) {
        return studentRepository.findByIdTutor(idTutor);
    }

    public List<Student> findStudentsByIdTutorAndFirstName(Long idTutor, String firstName) {
        return studentRepository.findByIdTutorAndFirstName(idTutor, firstName);
    }
}
