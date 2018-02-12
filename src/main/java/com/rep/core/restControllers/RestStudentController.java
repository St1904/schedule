package com.rep.core.restControllers;

import com.rep.core.services.StudentContactService;
import com.rep.db.domain.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by St on 10.06.2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/rest/student")
public class RestStudentController {
    private final StudentContactService studentContactService;

    public RestStudentController(StudentContactService studentContactService) {
        this.studentContactService = studentContactService;
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<Student> findById(@RequestHeader("idTutor") Long idTutor,
                                            @PathVariable("id") Long id) {
        Student found = studentContactService.findStudentById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<Student>(NOT_FOUND);
        }
        return new ResponseEntity<Student>(found, OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<Student>> findByIdTutor(@RequestHeader("idTutor") Long idTutor) {
        List<Student> students = studentContactService.findStudentsByIdTutor(idTutor);
        if (students.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(students, OK);
    }

    @RequestMapping(method = GET, params = "firstName")
    public ResponseEntity<List<Student>> findByName(@RequestHeader("idTutor") Long idTutor,
                                                    @RequestParam("firstName") String firstName) {
        List<Student> students = studentContactService.findStudentsByIdTutorAndFirstName(idTutor, firstName);
        if (students.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(students, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Student> createStudent(@RequestHeader("idTutor") Long idTutor,
                                                 @RequestBody Student student,
                                                 UriComponentsBuilder builder) {
        student.setIdTutor(idTutor);
        Student saved = studentContactService.createOrUpdateStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/rest/student/{id}").buildAndExpand(saved.getId()).toUri());
        return new ResponseEntity<>(headers, CREATED);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public ResponseEntity<Student> updateStudent(@RequestHeader("idTutor") Long idTutor,
                                                 @PathVariable("id") Long id,
                                                 @RequestBody Student student) {
        Student found = studentContactService.findStudentById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        student.setIdTutor(idTutor);
        student.setId(id);
        found = studentContactService.createOrUpdateStudent(student);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@RequestHeader("idTutor") Long idTutor,
                                                 @PathVariable("id") Long id) {
        Student found = studentContactService.findStudentById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        studentContactService.deleteStudent(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
