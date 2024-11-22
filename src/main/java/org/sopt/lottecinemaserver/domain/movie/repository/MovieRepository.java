package org.sopt.lottecinemaserver.domain.movie.repository;

import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM movie LIMIT 4", nativeQuery = true)
    List<Movie> get4AllMovies();

    @Query(value = "SELECT * FROM movie WHERE released_date <= :released_date LIMIT 4", nativeQuery = true)
    List<Movie> get4ReleasedMovies(@Param("released_date") Date released_date);

    @Query(value = "SELECT * FROM movie WHERE released_date > :released_date LIMIT 4", nativeQuery = true)
    List<Movie> get4UnreleasedMovies(@Param("released_date") Date released_date);

    List<Movie> findByIdIn(List<Long> ids);
}
