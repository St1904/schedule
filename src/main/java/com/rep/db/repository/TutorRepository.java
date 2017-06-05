package com.rep.db.repository;

import com.rep.db.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Tutor findByNameAndAddress(@Param("name") String name, @Param("address") String address);
}
