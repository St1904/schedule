package com.rep.db.repository;

import com.rep.db.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
