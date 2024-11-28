package org.sopt.lottecinemaserver.domain.seat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.sopt.lottecinemaserver.domain.movie.entity.Movie;
import org.sopt.lottecinemaserver.domain.movie.repository.MovieRepository;
import org.sopt.lottecinemaserver.domain.seat.dto.response.ReservedSeatsResponse;
import org.sopt.lottecinemaserver.domain.seat.entity.Seat;
import org.sopt.lottecinemaserver.domain.seat.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final MovieRepository movieRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public SeatService(SeatRepository seatRepository, MovieRepository movieRepository) {
        this.seatRepository = seatRepository;
        this.movieRepository = movieRepository;
    }

    @Transactional
    public ReservedSeatsResponse getReservedSeats(String movieTitle) {
        Set<Integer> reservedSeats = findReservedSeats(movieTitle);
        return new ReservedSeatsResponse(new ArrayList<>(reservedSeats));
    }

    @Transactional
    public void reserveSeats(String movieTitle, List<Integer> seats){
        Movie movie = movieRepository.findByTitle(movieTitle);
        Seat seat = seatRepository.findByMovie(movie);

        try{
            Set<Integer> availableSeats = objectMapper.readValue(
                    seat.getReservedSeat(),
                    new TypeReference<Set<Integer>>() {}
            );

            if(checkSeatsAvailable(availableSeats, seats)){
                availableSeats.addAll(seats);
                seat.setReservedSeat(objectMapper.writeValueAsString(availableSeats));
            }else{
                throw new RuntimeException();
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @Transactional
    private Set<Integer> findReservedSeats(String movieTitle){
        Movie movie = movieRepository.findByTitle(movieTitle);
        Seat seat = seatRepository.findByMovie(movie);

        try{
            return objectMapper.readValue(seat.getReservedSeat(), new TypeReference<Set<Integer>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkSeatsAvailable(Set<Integer> seats, List<Integer> requiredSeats){
        for (Integer e : requiredSeats) {
            if (seats.contains(e)) {
                return false; // Found a common element
            }
        }
        return true;
    }
}


