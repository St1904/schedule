package com.rep.db.repository;

import com.rep.db.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "select * " +
            "from Event e " +
            "where e.id_tutor = :idTutor",
            nativeQuery = true)
    List<Event> findAllByIdTutor(@Param("idTutor") Long idTutor);

    @Query(value = "select * " +
            "from Event e " +
            "where e.id_tutor = :idTutor " +
            "and e.date_start <= :to " +
            "and (e.date_end >= :from " +
            "or e.date_end is null)",
            nativeQuery = true)
    List<Event> findAllEventsBetweenDates(@Param("idTutor") Long idTutor, @Param("from") String from, @Param("to") String to);
}