package org.sopt.lottecinemaserver.domain.seat.controller;

import java.util.List;
import org.sopt.lottecinemaserver.domain.seat.dto.request.SeatReserveRequest;
import org.sopt.lottecinemaserver.domain.seat.dto.response.ReservedSeatsResponse;
import org.sopt.lottecinemaserver.domain.seat.service.SeatService;
import org.sopt.lottecinemaserver.global.common.ApiResponse;
import org.sopt.lottecinemaserver.global.common.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.lottecinemaserver.global.common.ApiResponse.success;

@RestController
@RequestMapping("/api/v1/seats")
public class SeatController {
    private final SeatService seatService;
    public SeatController(SeatService seatService){this.seatService = seatService;}

    @GetMapping
    ResponseEntity<ApiResponse<List<Integer>>> getAvailableSeat(@RequestParam long movieId){
        return ResponseEntity.ok(
                success(SuccessType.GET_AVAILABLE_SEATS, seatService.getReservedSeats(movieId))
        );
    }

    @PostMapping
    ResponseEntity<ApiResponse<?>> reserveSeat(@RequestBody SeatReserveRequest request){
        seatService.reserveSeats(request.getMovieId(), request.getSeats());

        return ResponseEntity.ok(
                success(SuccessType.POST_RESERVE_SEATS)
        );
    }
}
