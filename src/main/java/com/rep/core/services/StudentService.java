package com.rep.core.services;

import com.rep.db.domain.Student;
import com.rep.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by St on 10.06.2017.
 */
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    public Student createStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findByIdTutor(Long idTutor) {
        return studentRepository.findByIdTutor(idTutor);
    }

    public List<Student> findByIdTutorAndFirstName(Long idTutor, String firstName) {
        return studentRepository.findByIdTutorAndFirstName(idTutor, firstName);
    }
}
