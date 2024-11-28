package org.sopt.lottecinemaserver.domain.seat.repository;

import java.util.Optional;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.sopt.lottecinemaserver.domain.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
    Optional<Seat> findByMovieId(Long movieId);
}
