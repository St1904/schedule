package com.rep.db.repository;

import com.rep.db.domain.Changes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by St on 08.02.2017.
 */
public interface ChangesRepository extends JpaRepository<Changes, Long> {
}
