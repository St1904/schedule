package com.rep.db.repository;

import com.rep.db.domain.ContactName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by St on 08.02.2017.
 */
@Repository
public interface ContactNameRepository extends JpaRepository<ContactName, Long> {
    ContactName findByName(@Param("name") String name);

    //TODO убрать, т.к. не требуется
    @Query(value = "select distinct cn.id, cn.name " +
            "from contact_name cn " +
            "join contact c on cn.id = c.id_contact_name " +
            "join student s on s.id = c.id_student " +
            "join tutor t on t.id = s.id_tutor " +
            "where t.id = :idTutor",
            nativeQuery = true)
    List<ContactName> findByIdTutor(@Param("idTutor") Long idTutor);
}
