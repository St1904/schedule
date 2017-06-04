package com.rep.db.repository;

import com.rep.db.domain.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sbt-sokolova-ts on 08.02.2017.
 */
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
