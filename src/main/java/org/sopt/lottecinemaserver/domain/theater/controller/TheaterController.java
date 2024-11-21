package org.sopt.lottecinemaserver.domain.theater.controller;

import org.sopt.lottecinemaserver.domain.theater.dto.TheaterListResponseDto;
import org.sopt.lottecinemaserver.domain.theater.service.TheaterService;
import org.sopt.lottecinemaserver.global.common.ApiResponse;
import org.sopt.lottecinemaserver.global.common.SuccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<TheaterListResponseDto>> getTheaterList(
            @RequestParam final Long regionId
    ) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.GET_THEATER_LIST_SUCCESS, theaterService.getTheaters(regionId)));
    }
}