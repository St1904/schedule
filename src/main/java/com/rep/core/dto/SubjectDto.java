package com.rep.core.dto;

import com.rep.db.domain.Subject;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class SubjectDto {
    private Long id;
    private String name;

    public static SubjectDto of(Subject subject) {
        SubjectDto result = new SubjectDto();
        result.setId(subject.getId());
        result.setName(subject.getName());
        return result;
    }

    public SubjectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
