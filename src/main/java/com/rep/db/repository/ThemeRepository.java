package com.rep.db.repository;

import com.rep.db.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    List<Theme> findBySubjectId(Long idSubject);

    List<Theme> findByIdParentTheme(Long idParentTheme);
}
