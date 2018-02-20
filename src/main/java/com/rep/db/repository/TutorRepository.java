package com.rep.db.repository;

import com.rep.db.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Tutor findByNameAndAddress(@Param("name") String name, @Param("address") String address);
}
