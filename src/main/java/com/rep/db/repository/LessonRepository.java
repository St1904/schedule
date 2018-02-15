package com.rep.db.repository;

import com.rep.db.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}