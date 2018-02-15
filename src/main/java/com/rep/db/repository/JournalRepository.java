package com.rep.db.repository;

import com.rep.db.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    @Query(value = "select * " +
            "from journal j, lesson l, event e " +
            "where e.id_tutor = :idTutor " +
            "and j.id_lesson = l.id " +
            "and l.id_event = e.id " +
            "order by j.date desc " +
            "limit :limit " +
            "offset :offset",
            nativeQuery = true)
    List<Journal> findByTutor(@Param("idTutor") Long idTutor,
                              @Param("limit") int limit,
                              @Param("offset") int offset);

    //TODO убрать?
    @Query(value = "select exists " +
            "(select * " +
            "from journal j, lesson l, event e " +
            "where e.id_tutor = :idTutor " +
            "and j.id_lesson = l.id " +
            "and l.id_event = e.id " +
            "and l.id = :idLesson " +
            "and j.date = :date)",
            nativeQuery = true)
    boolean existsUnique(@Param("idTutor") Long idTutor,
                         @Param("idLesson") Long idLesson,
                         @Param("date") Date date);

    @Query(value = "select * " +
            "from journal j, lesson l, event e " +
            "where e.id_tutor = :idTutor " +
            "and j.id_lesson = l.id " +
            "and l.id_event = e.id " +
            "and l.id = :idLesson " +
            "and j.date = :date",
            nativeQuery = true)
    Journal findByLessonAndDate(@Param("idTutor") Long idTutor,
                                @Param("idLesson") Long idLesson,
                                @Param("date") Date date);
}
