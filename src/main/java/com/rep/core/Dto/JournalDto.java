package com.rep.core.Dto;

import com.rep.db.domain.Journal;
import com.rep.db.domain.Student;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class JournalDto {
    private Long id;
    private Date date;
    private String studentFirstName;
    private String studentLastName;
    private String themeName;
    private String homeTask;
    private String lessonMark;
    private String hometaskMark;
    private String comment;

    public static JournalDto of(Journal journal) {
        JournalDto result = new JournalDto();
        result.setId(journal.getId());
        result.setDate(journal.getDate());
        Student student = journal.getLesson().getStudent();
        if (student != null) {
            result.setStudentFirstName(student.getFirstName());
            result.setStudentLastName(student.getLastName());
        }
        result.setThemeName(journal.getTheme().getName());
        result.setHomeTask(journal.getHometask());
        result.setLessonMark(journal.getLessonMark());
        result.setHometaskMark(journal.getHometaskMark());
        result.setComment(journal.getComment());
        return result;
    }

    public JournalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getHomeTask() {
        return homeTask;
    }

    public void setHomeTask(String homeTask) {
        this.homeTask = homeTask;
    }

    public String getLessonMark() {
        return lessonMark;
    }

    public void setLessonMark(String lessonMark) {
        this.lessonMark = lessonMark;
    }

    public String getHometaskMark() {
        return hometaskMark;
    }

    public void setHometaskMark(String hometaskMark) {
        this.hometaskMark = hometaskMark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
