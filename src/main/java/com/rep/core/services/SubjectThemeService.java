package com.rep.core.services;

import com.rep.core.dto.ThemeDto;
import com.rep.db.domain.Subject;
import com.rep.db.domain.Theme;
import com.rep.db.repository.SubjectRepository;
import com.rep.db.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectThemeService {
    private final SubjectRepository subjectRepository;
    private final ThemeRepository  themeRepository;

    @Autowired
    public SubjectThemeService(SubjectRepository subjectRepository, ThemeRepository themeRepository) {
        this.subjectRepository = subjectRepository;
        this.themeRepository = themeRepository;
    }

    public Subject createSubject(Subject subject) {
        Subject saved = subjectRepository.saveAndFlush(subject);
        Theme theme = new Theme();
        theme.setSubject(saved);
        theme.setName(saved.getName());
        themeRepository.saveAndFlush(theme);
        return saved;
    }

    public Theme createTheme(Theme theme) {
        return themeRepository.saveAndFlush(theme);
    }

    public Theme findThemeById(Long id) {
        return themeRepository.findOne(id);
    }

    public List<Theme> findThemesByIdSubject(Long idSubject) {
        return themeRepository.findBySubjectId(idSubject);
    }

    public List<Theme> findThemesByIdParent(Long idParent) {
        return themeRepository.findByIdParentTheme(idParent);
    }

    public List<ThemeDto> findTreeByIdParent(Long idParent) {
        List<ThemeDto> result = ThemeDto.of(themeRepository.findByIdParentTheme(idParent));
        if (result.size() == 0) {
            return null;
        } else {
            for (ThemeDto theme : result) {
                theme.setChildren(findTreeByIdParent(theme.getId()));
            }
        }
        return result;
    }

    public void deleteThemeById(Long id) {
        List<Theme> children = themeRepository.findByIdParentTheme(id);
        for (Theme theme : children) {
            deleteThemeById(theme.getId());
        }
        themeRepository.delete(id);
    }
}
