package com.rep.core.services;

import com.rep.db.domain.Subject;
import com.rep.db.domain.Theme;
import com.rep.db.repository.SubjectRepository;
import com.rep.db.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by St on 14.06.2017.
 */

@Service
public class SubjectThemeService {
    private final SubjectRepository subjectRepository;
    private final ThemeRepository  themeRepository;

    @Autowired
    public SubjectThemeService(SubjectRepository subjectRepository, ThemeRepository themeRepository) {
        this.subjectRepository = subjectRepository;
        this.themeRepository = themeRepository;
    }

    public Subject findSubjectById(Long id) {
        return subjectRepository.findOne(id);
    }

    public List<Subject> findSubjectsByIdTutor(Long idTutor) {
        return subjectRepository.findByIdTutor(idTutor);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    public Subject updateSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
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
}
