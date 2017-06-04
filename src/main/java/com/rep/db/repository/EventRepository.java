package com.rep.db.repository;

import com.rep.db.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.eTutor.id = ?1")
    List<Event> findAllByTutor(Long idTutor);
}