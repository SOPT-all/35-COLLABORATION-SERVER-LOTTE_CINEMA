package org.sopt.lottecinemaserver.domain.seat.dto.response;

import java.util.List;

public class AvailableSeatsResponse {
    private final List<Integer> seatList;

    public AvailableSeatsResponse(List<Integer> seatList) {
        this.seatList = seatList;
    }

    public List<Integer> getSeatList() {
        return seatList;
    }
}
