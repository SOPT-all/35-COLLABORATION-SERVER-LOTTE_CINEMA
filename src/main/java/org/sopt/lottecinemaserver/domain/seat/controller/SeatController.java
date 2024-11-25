package org.sopt.lottecinemaserver.domain.seat.controller;

import org.sopt.lottecinemaserver.domain.seat.dto.response.AvailableSeatsResponse;
import org.sopt.lottecinemaserver.domain.seat.service.SeatService;
import org.sopt.lottecinemaserver.global.common.ApiResponse;
import org.sopt.lottecinemaserver.global.common.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/seats")
public class SeatController {
    private final SeatService seatService;
    public SeatController(SeatService seatService){this.seatService = seatService;}

    @GetMapping
    ResponseEntity<ApiResponse<AvailableSeatsResponse>> getAvailableSeat(@RequestParam String movie){
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.GET_AVAILABLE_SEATS, seatService.getAvailableSeats(movie))
        );
    }


}
