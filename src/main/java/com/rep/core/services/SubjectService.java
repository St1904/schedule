package com.rep.core.services;

import com.rep.db.domain.Subject;
import com.rep.db.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by St on 14.06.2017.
 */

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findById(Long id) {
        return subjectRepository.findOne(id);
    }

    public List<Subject> findByIdTutor(Long idTutor) {
        return subjectRepository.findByIdTutor(idTutor);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }

    public Subject updateSubject(Subject subject) {
        return subjectRepository.saveAndFlush(subject);
    }
}
