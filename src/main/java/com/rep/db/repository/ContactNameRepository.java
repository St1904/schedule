package com.rep.db.repository;

import com.rep.db.domain.ContactName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactNameRepository extends JpaRepository<ContactName, Long> {
    ContactName findByName(@Param("name") String name);
}
