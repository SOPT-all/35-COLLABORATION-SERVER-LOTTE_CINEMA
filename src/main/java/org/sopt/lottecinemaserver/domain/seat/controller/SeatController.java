package org.sopt.lottecinemaserver.domain.seat.controller;

import org.sopt.lottecinemaserver.domain.seat.dto.request.SeatReserveRequest;
import org.sopt.lottecinemaserver.domain.seat.dto.response.AvailableSeatsResponse;
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
    ResponseEntity<ApiResponse<AvailableSeatsResponse>> getAvailableSeat(@RequestParam String movie){
        return ResponseEntity.ok(
                success(SuccessType.GET_AVAILABLE_SEATS, seatService.getAvailableSeats(movie))
        );
    }

    @PostMapping
    ResponseEntity<ApiResponse> reserveSeat(@RequestBody SeatReserveRequest request){
        seatService.reserveSeats(request.getMovie(), request.getSeats());

        return ResponseEntity.ok(
                success(SuccessType.POST_RESERVE_SEATS)
        );
    }

}
