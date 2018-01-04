package com.rep.db.repository;

import com.rep.db.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByIdStudent(Long idStudent);

    void deleteById(Long id);
}
