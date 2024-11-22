package org.sopt.lottecinemaserver.domain.movie.repository;

import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
