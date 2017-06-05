package com.rep.core.Dto;

import com.rep.db.domain.domain_old.Lesson;
import com.rep.db.domain.Student;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class LessonDto {
    private Long id;
    private Long idEvent;
    private String eventName;
    private BigDecimal price;
    private String subjectName;
    private Set<StudentDto> students;

    public static LessonDto of(Lesson lesson) {
        LessonDto result = new LessonDto();
        result.setId(lesson.getId());
        result.setIdEvent(lesson.getEvent().getId());
        result.setEventName(lesson.getEvent().getName());
        result.setSubjectName(lesson.getSubject().getName());
        result.setPrice(lesson.getPrice());
        Set<StudentDto> studentSet = new HashSet<>();
        if (!lesson.getStudents().isEmpty()) {
            StudentDto studentDto;
            for (Student student : lesson.getStudents()) {
                studentDto = StudentDto.of(student);
                studentSet.add(studentDto);
            }
        }
        result.setStudents(studentSet);
        return result;
    }

    public LessonDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentDto> students) {
        this.students = students;
    }
}
