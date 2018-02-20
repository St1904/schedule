package com.rep.db.repository;

import com.rep.db.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByIdTutor(Long idTutor);

    List<Student> findByIdTutorAndFirstName(Long idTutor, String firstName);
}
