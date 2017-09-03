package com.rep.core.Dto;

import com.rep.db.domain.Theme;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class ThemeDto {
    private Long id;
    private String name;
    private String comment;
    private Long idParent;

    public static ThemeDto of(Theme theme) {
        ThemeDto result = new ThemeDto();
        result.setId(theme.getId());
        result.setName(theme.getName());
        result.setComment(theme.getComment() == null ? "" : theme.getComment());
        result.setIdParent(theme.getIdParentTheme());
        return result;
    }

    public static List<ThemeDto> of(List<Theme> themes) {
        List<ThemeDto> result = new ArrayList<>();
        for (Theme theme : themes) {
            result.add(ThemeDto.of(theme));
        }
        return result;
    }

    public ThemeDto() {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getIdParent() {
        return idParent;
    }

    public void setIdParent(Long idParent) {
        this.idParent = idParent;
    }
}
