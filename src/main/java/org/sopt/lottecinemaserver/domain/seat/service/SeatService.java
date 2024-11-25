package org.sopt.lottecinemaserver.domain.seat.service;

import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.sopt.lottecinemaserver.domain.movie.repository.MovieRepository;
import org.sopt.lottecinemaserver.domain.seat.repository.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final MovieRepository movieRepository;

    public SeatService(SeatRepository seatRepository, MovieRepository movieRepository) {
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
    }

    public AvailableSeatsResponse getAvailableSeats(String movieTitle){
        Movie movie = movieRepository.findByTitle(movieTitle);
        AvailableSeatResonse seats = seatRepository.
    }
}


