package org.sopt.lottecinemaserver.domain.seat.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.sopt.lottecinemaserver.domain.movie.repository.MovieRepository;
import org.sopt.lottecinemaserver.domain.seat.dto.response.ReservedSeatsResponse;
import org.sopt.lottecinemaserver.domain.seat.entity.Seat;
import org.sopt.lottecinemaserver.domain.seat.entity.SeatReservation;
import org.sopt.lottecinemaserver.domain.seat.repository.SeatRepository;
import org.sopt.lottecinemaserver.domain.seat.repository.SeatReservationRepository;
import org.sopt.lottecinemaserver.global.exception.CustomException;
import org.sopt.lottecinemaserver.global.exception.ErrorType;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatService {
    private final SeatReservationRepository seatReservationRepository;
    private final MovieRepository movieRepository;

    public SeatService(SeatReservationRepository seatReservationRepository, MovieRepository movieRepository) {
        this.seatReservationRepository = seatReservationRepository;
        this.movieRepository = movieRepository;
    }

    @Transactional
    public void reserveSeats(Long movieId, List<Integer> seats) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MOVIE));

        // 좌석 중복 확인
        for (Integer seat : seats) {
            if (seatReservationRepository.existsByMovieIdAndSeatNumber(movieId, seat)) {
                throw new CustomException(ErrorType.DUPLE_SEAT);
            }
        }

        // 좌석 예약
        for (Integer seat : seats) {
            SeatReservation reservation = new SeatReservation(movie, seat);
            seatReservationRepository.save(reservation);
        }
    }

    @Transactional(readOnly = true)
    public List<Integer> getReservedSeats(Long movieId) {
        List<SeatReservation> reservations = seatReservationRepository.findByMovieId(movieId);
        return reservations.stream()
                .map(SeatReservation::getSeatNumber)
                .toList();
    }
}


