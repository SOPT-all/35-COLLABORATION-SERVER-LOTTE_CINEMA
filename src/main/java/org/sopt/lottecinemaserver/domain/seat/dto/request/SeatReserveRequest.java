package org.sopt.lottecinemaserver.domain.seat.dto.request;


import java.util.List;

public class SeatReserveRequest {
    private final long movieId;
    private final List<Integer> seats;

    public SeatReserveRequest(long movieId, List<Integer> seats) {
        this.movieId = movieId;
        this.seats = seats;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public long getMovieId() {
        return movieId;
    }
}
