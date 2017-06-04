package com.rep.db.repository;

import com.rep.db.domain.Event;
import com.rep.db.domain.Repeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface RepeatsRepository extends JpaRepository<Repeats, Long> {
    @Query("select r from Repeats r where r.rEvent.id = ?1")
    Repeats findByEventId(Long id);
}
