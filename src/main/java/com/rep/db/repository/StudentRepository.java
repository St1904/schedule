package com.rep.db.repository;

import com.rep.db.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByIdTutor(Long idTutor);

    List<Student> findByIdTutorAndFirstName(Long idTutor, String firstName);
}
