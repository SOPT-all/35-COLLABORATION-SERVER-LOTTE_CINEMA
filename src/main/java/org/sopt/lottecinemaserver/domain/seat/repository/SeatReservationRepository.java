package org.sopt.lottecinemaserver.domain.seat.repository;

import java.util.List;
import org.sopt.lottecinemaserver.domain.seat.entity.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {
    List<SeatReservation> findByMovieId(Long movieId);

    boolean existsByMovieIdAndSeatNumber(Long movieId, Integer seatNumber);
}
