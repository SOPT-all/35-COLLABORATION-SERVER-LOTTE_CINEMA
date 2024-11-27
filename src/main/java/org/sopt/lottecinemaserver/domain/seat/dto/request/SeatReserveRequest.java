package org.sopt.lottecinemaserver.domain.seat.dto.request;


import java.util.List;

public class SeatReserveRequest {
    private final String movie;
    private final List<Integer> seats;

    public SeatReserveRequest(String movie, List<Integer> seats) {
        this.movie = movie;
        this.seats = seats;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public String getMovie() {
        return movie;
    }
}
