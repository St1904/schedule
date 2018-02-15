package com.rep.db.repository;

import com.rep.db.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByIdStudent(Long idStudent);
}
