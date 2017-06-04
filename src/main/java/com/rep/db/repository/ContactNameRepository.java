package com.rep.db.repository;

import com.rep.db.domain.ContactName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by St on 08.02.2017.
 */
public interface ContactNameRepository extends JpaRepository<ContactName, Long> {
    ContactName findByName(@Param("name") String name);
}
