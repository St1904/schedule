package com.rep.core.Dto;

import com.rep.db.domain.Tutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbt-sokolova-ts on 16.02.2017.
 */
public class TutorDto {
    private Long id;
    private String name;
    private String address;

    public static TutorDto of(Tutor tutor) {
        TutorDto result = new TutorDto();
        result.setId(tutor.getId());
        result.setName(tutor.getName() == null ? "" : tutor.getName());
        result.setAddress(tutor.getAddress() == null ? "" : tutor.getAddress());
        return result;
    }

    public static List<TutorDto> of(List<Tutor> list) {
        List<TutorDto> result = new ArrayList<>();
        for (Tutor tutor : list) {
            result.add(TutorDto.of(tutor));
        }
        return result;
    }

    public TutorDto() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
