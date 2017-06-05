package com.rep.core.services;

import com.rep.core.Dto.TutorDto;
import com.rep.db.domain.Tutor;
import com.rep.db.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by St on 05.06.2017.
 */

@Service
public class TutorService {
    private TutorRepository tutorRepository;

    @Autowired
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> listAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor findById(Long id) {
        return tutorRepository.findOne(id);
    }

    private Tutor createByNameAndAddress(String name, String address) {
        Tutor found = tutorRepository.findByNameAndAddress(name, address);
        if (found != null)
            return found;
        Tutor tutor = new Tutor();
        tutor.setName(name);
        tutor.setAddress(address);
        return tutorRepository.saveAndFlush(tutor);
    }

    public Tutor createTutor(TutorDto tutorDto) {
        return createByNameAndAddress(tutorDto.getName(), tutorDto.getAddress());
    }

    public Tutor updateTutor(Tutor tutor) {
        return tutorRepository.saveAndFlush(tutor);
    }

    public void deleteTutor(Long id) {
        tutorRepository.delete(id);
    }
}
