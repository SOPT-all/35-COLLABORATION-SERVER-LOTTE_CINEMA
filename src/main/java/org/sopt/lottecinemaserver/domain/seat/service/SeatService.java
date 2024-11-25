package org.sopt.lottecinemaserver.domain.seat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.sopt.lottecinemaserver.domain.movie.repository.MovieRepository;
import org.sopt.lottecinemaserver.domain.seat.dto.response.AvailableSeatsResponse;
import org.sopt.lottecinemaserver.domain.seat.entity.Seat;
import org.sopt.lottecinemaserver.domain.seat.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final MovieRepository movieRepository;

    public SeatService(SeatRepository seatRepository, MovieRepository movieRepository) {
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
    }

    public AvailableSeatsResponse getAvailableSeats(String movieTitle) {
        ObjectMapper objectMapper = new ObjectMapper();
        Movie movie = movieRepository.findByTitle(movieTitle);
        Seat seat = seatRepository.findByMovie(movie);

        try{
            List<Integer> seats = objectMapper.readValue(seat.getReservedSeat(), new TypeReference<List<Integer>>() {});
            return new AvailableSeatsResponse(seats);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


