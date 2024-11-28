package org.sopt.lottecinemaserver.domain.seat.dto.request;


import java.util.List;

public class SeatReserveRequest {
    private long movieId;
    private List<Integer> seats;

    public SeatReserveRequest() {

    }

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
