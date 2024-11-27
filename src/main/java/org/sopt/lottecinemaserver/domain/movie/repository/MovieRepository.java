package org.sopt.lottecinemaserver.domain.movie.repository;

import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);

    @Query(value = "SELECT * FROM movie WHERE release_date <= :release_date LIMIT 4", nativeQuery = true)
    List<Movie> get4ReleasedMovies(@Param("release_date") Date release_date);

    @Query(value = "SELECT * FROM movie WHERE release_date > :release_date LIMIT 4", nativeQuery = true)
    List<Movie> get4UnreleasedMovies(@Param("release_date") Date released_date);
}
