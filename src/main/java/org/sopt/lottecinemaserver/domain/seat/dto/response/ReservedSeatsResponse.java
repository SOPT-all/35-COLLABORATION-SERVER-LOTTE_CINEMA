package org.sopt.lottecinemaserver.domain.seat.dto.response;

import java.util.List;

public class ReservedSeatsResponse {
    private final List<Integer> seatList;

    public ReservedSeatsResponse(List<Integer> seatList) {
        this.seatList = seatList;
    }

    public List<Integer> getSeatList() {
        return seatList;
    }
}
