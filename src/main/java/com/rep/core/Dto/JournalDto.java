package com.rep.core.Dto;

import com.rep.db.domain.Journal;

import java.util.Date;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class JournalDto {
    private Long id;
    private Long idTheme;
    private String themeName;
    private String subjectName;
    private Long idLesson;
    private Date date;

    public static JournalDto of(Journal journal) {
        JournalDto result = new JournalDto();
        result.setId(journal.getId());
        result.setDate(journal.getDate());
        result.setIdLesson(journal.getLesson().getId());
        result.setIdTheme(journal.getTheme().getId());
        result.setThemeName(journal.getTheme().getName());
        result.setSubjectName(journal.getLesson().getSubject().getName());
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

    public Long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Long idTheme) {
        this.idTheme = idTheme;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(Long idLesson) {
        this.idLesson = idLesson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
