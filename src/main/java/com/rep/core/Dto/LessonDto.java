package com.rep.core.Dto;

import com.rep.db.domain.Lesson;

import java.math.BigDecimal;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class LessonDto {
    private Long id;
    private BigDecimal price;
    private String subjectName;
    private StudentDto student;

    public static LessonDto of(Lesson lesson) {
        LessonDto result = new LessonDto();
        result.setId(lesson.getId());
        result.setSubjectName(lesson.getSubject().getName());
        result.setPrice(lesson.getPrice());
        result.setStudent(StudentDto.of(lesson.getStudent()));
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

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }
}
