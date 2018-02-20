package com.rep.core.services;

import com.rep.db.domain.Journal;
import com.rep.db.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JournalService {
    private JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public Journal find(Long idTutor, Long idLesson, Date date) {
        return journalRepository.findByLessonAndDate(idTutor, idLesson, date);
    }

    public List<Journal> findPageable(Long idTutor, int limit, int offset) {
        return journalRepository.findByTutor(idTutor, limit, offset);
    }

    public Journal create(Journal journal) {
        return journalRepository.saveAndFlush(journal);
    }

    public Journal findById(Long id) {
        return journalRepository.findOne(id);
    }

    public Journal updateJournal(Journal journal) {
        return journalRepository.saveAndFlush(journal);
    }
}
