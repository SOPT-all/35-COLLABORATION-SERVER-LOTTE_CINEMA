package org.sopt.lottecinemaserver.domain.seat.dto.request;


import java.util.List;

public record SeatReserveRequest(
        Long movieId,
        List<Integer> seats
) {
}
