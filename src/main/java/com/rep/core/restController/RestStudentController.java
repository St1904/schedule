package com.rep.core.restController;

import com.rep.core.services.StudentService;
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
    private final StudentService studentService;

    public RestStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = GET, path = "/{id}")
    public ResponseEntity<Student> findById(@RequestHeader("idTutor") Long idTutor,
                                            @PathVariable("id") Long id) {
        Student found = studentService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<Student>(NOT_FOUND);
        }
        return new ResponseEntity<Student>(found, OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<List<Student>> findByIdTutor(@RequestHeader("idTutor") Long idTutor) {
        List<Student> students = studentService.findByIdTutor(idTutor);
        if (students.isEmpty()) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(students, OK);
    }

    @RequestMapping(method = GET, params = "firstName")
    public ResponseEntity<List<Student>> findByName(@RequestHeader("idTutor") Long idTutor,
                                                    @RequestParam("firstName") String firstName) {
        List<Student> students = studentService.findByIdTutorAndFirstName(idTutor, firstName);
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
        Student saved = studentService.createStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/rest/student/{id}").buildAndExpand(saved.getIdTutor(), saved.getId()).toUri());
        return new ResponseEntity<Student>(headers, CREATED);
    }

    @RequestMapping(method = PUT, path = "/{id}")
    public ResponseEntity<Student> updateStudent(@RequestHeader("idTutor") Long idTutor,
                                                 @PathVariable("id") Long id,
                                                 @RequestBody Student student) {
        Student found = studentService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        student.setIdTutor(idTutor);
        student.setId(id);
        found = studentService.updateStudent(student);
        return new ResponseEntity<>(found, OK);
    }

    @RequestMapping(method = DELETE, path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@RequestHeader("idTutor") Long idTutor,
                                                 @PathVariable("id") Long id) {
        Student found = studentService.findById(id);
        if (found == null || !found.getIdTutor().equals(idTutor)) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
